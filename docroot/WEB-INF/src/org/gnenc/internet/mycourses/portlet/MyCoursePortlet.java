package org.gnenc.internet.mycourses.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.service.CourseLocalServiceUtil;
import org.gnenc.internet.mycourses.service.EntityLocalServiceUtil;
import org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil;

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
		
		for (UserEnrollment enrollment : enrollments) {
			Course course = CourseLocalServiceUtil.getCourseByEntity(
					enrollment.getCourseId(),entityId
			);
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
}
