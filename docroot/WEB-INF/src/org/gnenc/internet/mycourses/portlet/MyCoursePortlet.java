package org.gnenc.internet.mycourses.portlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.service.CourseLocalServiceUtil;
import org.gnenc.internet.mycourses.service.EntityLocalService;
import org.gnenc.internet.mycourses.service.EntityLocalServiceUtil;
import org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil;
import org.gnenc.internet.mycourses.service.impl.EntityLocalServiceImpl;

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
		
		/** long entityId = getUserHomeSchool(request); */
		long entityId = 1;
		
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
		/** Strip domain out of email address to determine home school */
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		String userEmail = themeDisplay.getUser().getEmailAddress();
		
		String[] tokens = userEmail.split("@");
		String domain = tokens[1];
		
		List<Entity> entity = EntityLocalServiceUtil.getEntityByDomain(domain);
		long entityId = entity.get(0).getEntityId();
		
		return entityId;
	}
}
