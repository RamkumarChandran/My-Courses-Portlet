package org.gnenc.internet.mycourses.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.model.impl.CourseImpl;
import org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl;
import org.gnenc.internet.mycourses.service.CourseLocalServiceUtil;
import org.gnenc.internet.mycourses.service.EntityLocalServiceUtil;
import org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil;

public class MyCoursePortlet extends MVCPortlet {

	public static List<Course> getAllEnrollments(RenderRequest request) throws SystemException, PortalException {
		List<Course> courseInfo = new ArrayList<Course>();

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUser().getUserId();
		String userEmail = themeDisplay.getUser().getEmailAddress();

		long entityId = getUserHomeSchool(request);

		checkCourses(userEmail,entityId,userId);

		List<UserEnrollment> enrollments = UserEnrollmentLocalServiceUtil.getUserEnrollmentsByUserId(userId);

		for (UserEnrollment enrollment : enrollments) {
			Course course = CourseLocalServiceUtil.getCourse(enrollment.getCourseId());

			if (course != null) {
				courseInfo.add(course);
			}
		}

		return courseInfo;
	}

	public static long getUserHomeSchool(RenderRequest request) throws SystemException {
		/** This needs to change.  A better idea is to probably tie the user to a user group in Liferay
		 *  We have define the user group association from the directory.  We can define the relationship
		 *  between a user group and a school/ESU in the Entity table manually via the future
		 *  control panel portlet.
		 *  */
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String userEmail = themeDisplay.getUser().getEmailAddress();

		String[] tokens = userEmail.split("@");
		String domain = tokens[1];

		List<Entity> entity = EntityLocalServiceUtil.getEntityByDomain(domain);
		long entityId = entity.get(0).getEntityId();

		return entityId;
	}

	private static void checkCourses(String userEmail, long entityId, long userId) throws PortalException, SystemException {

		List<UserEnrollment> enrollments = UserEnrollmentLocalServiceUtil.getUserEnrollmentsByUserId(userId);

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
	private static void updateCourses (String userEmail, long entityId, long userId) throws PortalException, SystemException
	{
		String dbServer = "corin.vps.gnenc.org";
		Entity entity = EntityLocalServiceUtil.getEntity(entityId);
		String dbName = entity.getDbName();
		String dbUrl = dbServer + "/" + dbName;
		String dbUser = "esu10moodle";
		String dbPass = "UtVz85rTEZpR";

		ArrayList mCourses = MoodleJdbc.findCoursesByEmail(userEmail, dbUrl, dbUser, dbPass);

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

			UserEnrollment u = UserEnrollmentLocalServiceUtil.getByUid_CourseId(userId,course.getId());
			if (u == null) {

				// Insert new user enrollment

				u = new UserEnrollmentImpl();

				u.setUserId(userId);
				u.setCourseId(course.getId());
				u.setId(CounterLocalServiceUtil.increment(UserEnrollment.class.getName()));
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