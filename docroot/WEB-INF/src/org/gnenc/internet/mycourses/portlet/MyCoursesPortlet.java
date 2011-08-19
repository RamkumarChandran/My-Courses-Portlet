package org.gnenc.internet.mycourses.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.model.impl.CourseImpl;
import org.gnenc.internet.mycourses.model.impl.EntityImpl;
import org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl;
import org.gnenc.internet.mycourses.service.CourseLocalServiceUtil;
import org.gnenc.internet.mycourses.service.EntityLocalServiceUtil;
import org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil;

public class MyCoursesPortlet extends MVCPortlet {

	public static List<Course> getAllEnrollments(RenderRequest request) 
			throws SystemException, PortalException {
		List<Course> courseInfo = new ArrayList<Course>();
		long entityId = -1;
		Entity entity = new EntityImpl();
		entity.setEntityId(-1);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUser().getUserId();
		String userEmail = themeDisplay.getUser().getEmailAddress();
		Boolean isDefaultUser = themeDisplay.getUser().isDefaultUser(); 
		
		PortletPreferences prefs = request.getPreferences();
		String preferredEntity = prefs.getValue("entity","no");

		if ((preferredEntity == "no") && (!isDefaultUser)) {	
			
			// Logged in and no preferred entity set
			
			String[] tokens = userEmail.split("@");
			String domain = tokens[1];
	
			List<Entity> entities = EntityLocalServiceUtil.getEntityByDomain(
					domain);
			if (!entities.isEmpty()) {
				
				// User-Entity affiliation found
				
				entityId = entities.get(0).getEntityId();
				entity = EntityLocalServiceUtil.getEntity(entityId);
				
			}
			
		} else {
			
			// Logged in and preferred entity set
			
			entityId = Long.valueOf(preferredEntity);
			entity = EntityLocalServiceUtil.getEntity(entityId);
			
		}
	
		if (entityId != -1) {
			
			// User affiliation found or preferred entity set
			
			checkCourses(userEmail,entityId,userId);
	
			List<UserEnrollment> enrollments = 
				UserEnrollmentLocalServiceUtil.getUserEnrollmentsByUserId(userId);
	
			for (UserEnrollment enrollment : enrollments) {
				Course course = CourseLocalServiceUtil.getCourse(
						enrollment.getCourseId());
	
				if (course != null) {
					courseInfo.add(course);
					
				}

			}

		} else {
			courseInfo = null;
			
		}
		request.setAttribute("isDefaultUser", isDefaultUser);
		request.setAttribute("entity", entity);
		return courseInfo;
	
	}
	
	public void changeEntity(ActionRequest request, ActionResponse response)
    		throws Exception {
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue("entity", ParamUtil.getString(request, "entityId"));
		prefs.store();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUser().getUserId();
		String userEmail = themeDisplay.getUser().getEmailAddress();
		long entityId = Long.valueOf(ParamUtil.getString(request, "entityId"));
		
		updateCourses(userEmail,entityId,userId);
	
	}

	private static void checkCourses(String userEmail, long entityId, long userId) 
			throws PortalException, SystemException {

		List<UserEnrollment> enrollments = 
			UserEnrollmentLocalServiceUtil.getUserEnrollmentsByUserId(userId);

		if (enrollments.size() == 0)
		{
			updateCourses(userEmail,entityId,userId);
		
		}

		for (UserEnrollment enrollment : enrollments) {
			Date today = new Date();
			long oneWeek = 604800000;
			Date lastRefresh = enrollment.getLastRefresh();

			if ((today.getTime()-lastRefresh.getTime()) > oneWeek) {

				//Update Course Enrollments

				updateCourses(userEmail,entityId,userId);
				break;
			
			}
		
		}
	
	}

	@SuppressWarnings("rawtypes")
	private static void updateCourses (String userEmail, long entityId, long userId) 
			throws PortalException, SystemException	{
		Entity entity = EntityLocalServiceUtil.getEntity(entityId);
		String dbName = entity.getDbName();
		String dbServer = entity.getDbServer();
		String dbUrl = dbServer + "/" + dbName;
		String dbUser = entity.getDbUser();
		String dbPass = entity.getDbPass();

		ArrayList mCourses = MoodleJdbc.findCoursesByEmail(
				userEmail, dbUrl, dbUser, dbPass);

		ArrayList courseName = ((ArrayList)mCourses.get(0));
		ArrayList courseId = ((ArrayList)mCourses.get(1));

		for (int i = courseName.size()-1;i>=0;i--)
		{
			String str = courseId.get(i).toString();
			String name = courseName.get(i).toString();
			long id = Long.valueOf(str);
			Course course = new CourseImpl();

			if (CourseLocalServiceUtil.getCourseByEntity(id, entityId) == null) {

				// Insert new course

				Course c = new CourseImpl();

				c.setName(name);
				c.setCourseId(id);
				c.setEntityId(entityId);
				c.setId(CounterLocalServiceUtil.increment(Course.class.getName()));

				course = CourseLocalServiceUtil.addCourse(c);
			
			} else {

				// Update existing course

				Course c = CourseLocalServiceUtil.getCourseByEntity(id, entityId);
				c.setName(name);
				c.setNew(false);

				course = CourseLocalServiceUtil.updateCourse(c);
			
			}

			UserEnrollment u = UserEnrollmentLocalServiceUtil.getByUid_CourseId(
					userId,course.getId());
			if (u == null) {

				// Insert new user enrollment

				u = new UserEnrollmentImpl();

				u.setUserId(userId);
				u.setCourseId(course.getId());
				u.setId(CounterLocalServiceUtil.increment(
						UserEnrollment.class.getName()));
				u.setLastRefresh(new Date());

				UserEnrollmentLocalServiceUtil.addUserEnrollment(u);
			
			} else {

				// Update existing user enrollment

				u.setLastRefresh(new Date());
				u.setNew(false);

				UserEnrollmentLocalServiceUtil.updateUserEnrollment(u);
		
			}
	
		}
	
	}
	
}