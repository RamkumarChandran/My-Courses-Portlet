/**
*  Copyright (c) 2010-2011 Educational Service Unit 10. 
*
*  This file is part of the My Courses portlet.
*  
*  My Courses portlet is free software: you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
* 
*  My Courses is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with the My Courses portlet.  If not, see <http://www.gnu.org/licenses/>.
**/

package org.gnenc.internet.mycourses.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
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
import org.gnenc.internet.mycourses.model.Site;
import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.model.impl.CourseImpl;
import org.gnenc.internet.mycourses.model.impl.SiteImpl;
import org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl;
import org.gnenc.internet.mycourses.service.CourseLocalServiceUtil;
import org.gnenc.internet.mycourses.service.SiteLocalServiceUtil;
import org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil;

public class MyCoursesPortlet extends MVCPortlet {
	public static List<Course> getAllEnrollments(RenderRequest request)
			throws SystemException, PortalException {
		List<Course> courseInfo = new ArrayList<Course>();
		long siteId = -1;
		Site site = new SiteImpl();
		site.setSiteId(-1);

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUser().getUserId();
		String userEmail = themeDisplay.getUser().getEmailAddress();
		Boolean isDefaultUser = themeDisplay.getUser().isDefaultUser();

		PortletPreferences prefs = request.getPreferences();
		String preferredSite = prefs.getValue("site", "no");

		if ((preferredSite == "no") && (!isDefaultUser)) {

			// Logged in and no preferred site set

			String[] tokens = userEmail.split("@");
			String domain = tokens[1];

			List<Site> sites = SiteLocalServiceUtil
					.getSiteByDomain(domain);
			if (!sites.isEmpty()) {

				// User-Site affiliation found

				siteId = sites.get(0).getSiteId();
				site = SiteLocalServiceUtil.getSite(siteId);

			}

		} else if (preferredSite != "no") {

			// Logged in and preferred site set

			siteId = Long.valueOf(preferredSite);
			site = SiteLocalServiceUtil.getSite(siteId);

		}

		if (siteId != -1) {

			// User affiliation found or preferred site set

			checkCourses(userEmail, siteId, userId);

			List<UserEnrollment> enrollments = UserEnrollmentLocalServiceUtil
					.getUserEnrollmentsByUserId(userId);

			for (UserEnrollment enrollment : enrollments) {
				Course course = CourseLocalServiceUtil.getCourse(enrollment
						.getCourseId());

				if (course != null) {
					courseInfo.add(course);

				}

			}

		} else {
			courseInfo = null;

		}
		request.setAttribute("isDefaultUser", isDefaultUser);
		request.setAttribute("site", site);
		return courseInfo;

	}

	public void changeSite(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
			.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUser().getUserId();
		String userEmail = themeDisplay.getUser().getEmailAddress();
		PortletPreferences prefs = request.getPreferences();
		String str = ParamUtil.getString(request, "siteId");
		
		if (Validator.isNotNull(str)) {
			long siteId = Long.valueOf(ParamUtil.getString(request, "siteId"));
			prefs.setValue("site", ParamUtil.getString(request, "siteId"));
			prefs.store();

			updateCourses(userEmail, siteId, userId);
			
		} 
		
	}

	private static void checkCourses(String userEmail, long siteId,
			long userId) throws PortalException, SystemException {

		List<UserEnrollment> enrollments = UserEnrollmentLocalServiceUtil
				.getUserEnrollmentsByUserId(userId);

		if (enrollments.size() == 0) {
			updateCourses(userEmail, siteId, userId);

		}

		for (UserEnrollment enrollment : enrollments) {
			Date today = new Date();
			long oneWeek = 604800000;
			Date lastRefresh = enrollment.getLastRefresh();

			if ((today.getTime() - lastRefresh.getTime()) > oneWeek) {

				// Update Course Enrollments

				updateCourses(userEmail, siteId, userId);
				break;

			}

		}

	}

	@SuppressWarnings("rawtypes")
	private static void updateCourses(String userEmail, long siteId,
			long userId) throws PortalException, SystemException {
		Site site = SiteLocalServiceUtil.getSite(siteId);
		String dbName = site.getDbName();
		String dbServer = site.getDbServer();
		String dbUrl = dbServer + "/" + dbName;
		String dbUser = site.getDbUser();
		String dbPass = site.getDbPass();

		ArrayList mCourses = DBConn.findCoursesByEmail(userEmail, dbUrl,
				dbUser, dbPass);

		ArrayList courseName = ((ArrayList) mCourses.get(0));
		ArrayList courseId = ((ArrayList) mCourses.get(1));

		for (int i = courseName.size() - 1; i >= 0; i--) {
			String str = courseId.get(i).toString();
			String name = courseName.get(i).toString();
			long id = Long.valueOf(str);
			Course course = new CourseImpl();

			if (CourseLocalServiceUtil.getCourseBySite(
					id, siteId) == null) {

				// Insert new course

				Course c = new CourseImpl();

				c.setName(name);
				c.setCourseId(id);
				c.setSiteId(siteId);
				c.setId(CounterLocalServiceUtil.increment(Course.class
						.getName()));

				course = CourseLocalServiceUtil.addCourse(c);

			} else {

				// Update existing course

				Course c = CourseLocalServiceUtil.getCourseBySite(id,
						siteId);
				c.setName(name);
				c.setNew(false);

				course = CourseLocalServiceUtil.updateCourse(c);

			}

			UserEnrollment u = UserEnrollmentLocalServiceUtil
					.getByUid_CourseId(userId, course.getId());
			if (u == null) {

				// Insert new user enrollment

				u = new UserEnrollmentImpl();

				u.setUserId(userId);
				u.setCourseId(course.getId());
				u.setId(CounterLocalServiceUtil.increment(UserEnrollment.class
						.getName()));
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