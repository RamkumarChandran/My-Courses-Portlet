package org.gnenc.internet.mycourses.portlet;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.model.impl.CourseImpl;
import org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl;
import org.gnenc.internet.mycourses.service.CourseLocalServiceUtil;
import org.gnenc.internet.mycourses.service.EntityLocalServiceUtil;
import org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class MyCoursePortlet extends MVCPortlet {

	public static List<Course> getAllEnrollments(RenderRequest request) throws SystemException, PortalException {
		List<Course> courseInfo = new ArrayList<Course>();
		
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUser().getUserId();
		String userEmail = themeDisplay.getUser().getEmailAddress();
		
		long entityId = getUserHomeSchool(request);
		
		List<UserEnrollment> enrollments = UserEnrollmentLocalServiceUtil.getUserEnrollmentsByUserId(userId);
		
		long numberCoursesEnrolled = enrollments.size();
		
		if (numberCoursesEnrolled == 0)
		{
			performTableUpdate(userEmail,entityId,userId);
		}
			
		
		
		/** Insert check to test # of enrollments - If = 0, go get from Moodle DB.  Else, go on. */
		
		for (UserEnrollment enrollment : enrollments) {
			
			
			
			/** Check last refresh date on enrollment.  If older than standard, go get from Moodle DB
			 * 
			 *  Make the following in a new method:
			 *  If one enrollment is old, we assume they all are, and go update all user's enrollments
			 *  We want to exit this loop if we have to go update
			 *  
			 *  The Moodle DB will send back the Course Name and Id, too, so we might as well
			 *  go ahead and check and update the Course Info in Liferay while we're at it.
			 *  There is no last refresh on course info so we check, update if necessary, and move on
			 */
			Course course = CourseLocalServiceUtil.getCourseByEntity(
					enrollment.getCourseId(),entityId);
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
	
	public static void courseUpdate ()
	{
		
		
		/**
		 * Name will probably be changed.  This method will call the perfromTableUpdate
		 * method that gets all of the moodle courses.  Once it has all of the updated
		 * courses, each column will be compared with a specified date to see
		 * if it needs to be refreshed.  Will call UpdateCourse, send it a course object or user enroll object
		 * .  Build it in the same way.
		 */
	}
	
	public static void performTableUpdate (String userEmail, long entId, long userId) throws SystemException, PortalException
	{
		
		
		String dbServer = "corin.vps.gnenc.org";
		Entity entity = EntityLocalServiceUtil.getEntity(entId);
		String dbName = entity.getDbName();
		String dbUrl = dbServer + "/" + dbName;	
		String dbUser = "esu10moodle";
		String dbPass = "UtVz85rTEZpR";
			
		ArrayList courses = MoodleJdbc.findCoursesByEmail(userEmail, dbUrl, dbUser, dbPass);
		
		ArrayList courseName = ((ArrayList)courses.get(0));
		ArrayList courseId = ((ArrayList)courses.get(1));
	
		
		
		for (int count = courseName.size()-1;count>=0;count--)
		{
			String str = courseId.get(count).toString();
			long id = Long.valueOf(str);
			
			String name = courseName.get(count).toString();
			
			Course course = new CourseImpl();
			
			course.setName(name);
			course.setCourseId(id);
			course.setEntityId(entId);
			course.setId(CounterLocalServiceUtil.increment(Course.class.getName()));
			Course course1 = CourseLocalServiceUtil.addCourse(course);
			
			UserEnrollment userEnroll = new UserEnrollmentImpl();
			
			userEnroll.setUserId(userId);
			userEnroll.setCourseId(course1.getId());
			userEnroll.setId(CounterLocalServiceUtil.increment(UserEnrollment.class.getName()));
			userEnroll.setLastRefresh(new Date());
		
			
			UserEnrollmentLocalServiceUtil.addUserEnrollment(userEnroll);
			
		}
		
			
			
		/**
		 * The method name will need to change.  This method will go get all
		 * of the Moodle DB's information.  It will be inserted into the list of
		 * the users courses.  Call add course for each one I get back from moodle.
		 * CourseLocalServiceUtil.addCourse(parameters).
		 */
		
	}
}
