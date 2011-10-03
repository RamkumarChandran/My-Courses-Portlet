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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Company;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Site;
import org.gnenc.internet.mycourses.model.impl.SiteImpl;
import org.gnenc.internet.mycourses.service.SiteLocalServiceUtil;
public class MyCoursesAdminPortlet extends MVCPortlet {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addSite(ActionRequest request, ActionResponse response)
			throws Exception {
		Site site = new SiteImpl();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Company c = themeDisplay.getCompany();

		site.setSiteId(CounterLocalServiceUtil.increment(Site.class
				.getName()));
		site.setSiteName(ParamUtil.getString(request, "siteName"));
		site.setUrl(ParamUtil.getString(request, "siteUrl"));
		site.setEmailDomain(ParamUtil
				.getString(request, "siteEmailDomain"));
		site.setDbServer(ParamUtil.getString(request, "siteDbServer"));
		site.setDbName(ParamUtil.getString(request, "siteDbName"));
		site.setDbUser(ParamUtil.getString(request, "siteDbUser"));
		site.setDbPass(ParamUtil.getString(request, "siteDbPass"));
		site.setCompanyId(c.getCompanyId());

		ArrayList<String> errors = new ArrayList();
		String dbUrl = site.getDbServer() + "/" + site.getDbName();

		if (validateSite(site, errors)) {

			if (DBConn.connectToDB(dbUrl, site.getDbUser(),
					site.getDbPass()) != null) {
				SiteLocalServiceUtil.addSite(site);
				SessionMessages.add(request, "siteSaved");

			} else {
				SessionErrors.add(request, "error-db-connect");
				request.setAttribute("addSite", site);

			}

		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);

			}
			request.setAttribute("addSite", site);

		}

	}

	public void editSite(ActionRequest request, ActionResponse response)
			throws Exception {
		long siteKey = ParamUtil.getLong(request, "resourcePrimKey");

		if (Validator.isNotNull(siteKey)) {
			Site site = SiteLocalServiceUtil.getSite(siteKey);
			request.setAttribute("site", site);
			response.setRenderParameter("jspPage", editSiteJSP);

		}

	}

	public void deleteSite(ActionRequest request, ActionResponse response)
			throws Exception {
		long siteKey = ParamUtil.getLong(request, "resourcePrimKey");
		// ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
		// WebKeys.THEME_DISPLAY);

		if (Validator.isNotNull(siteKey)) {
			SiteLocalServiceUtil.deleteSite(siteKey);
			SessionMessages.add(request, "siteDeleted");

		} else {
			SessionErrors.add(request, "error-deleting");

		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateSite(ActionRequest request, ActionResponse response)
			throws Exception {
		long siteKey = ParamUtil.getLong(request, "resourcePrimKey");
		Site site = SiteLocalServiceUtil.getSite(siteKey);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Company c = themeDisplay.getCompany();

		site.setSiteName(ParamUtil.getString(request, "siteName"));
		site.setUrl(ParamUtil.getString(request, "siteUrl"));
		site.setEmailDomain(ParamUtil
				.getString(request, "siteEmailDomain"));
		site.setDbServer(ParamUtil.getString(request, "siteDbServer"));
		site.setDbName(ParamUtil.getString(request, "siteDbName"));
		site.setDbUser(ParamUtil.getString(request, "siteDbUser"));
		site.setDbPass(ParamUtil.getString(request, "siteDbPass"));
		site.setCompanyId(c.getCompanyId());

		ArrayList<String> errors = new ArrayList();

		String dbUrl = site.getDbServer() + "/" + site.getDbName();

		if (Validator.isNotNull(siteKey)) {
			if (validateSite(site, errors)) {
				if (DBConn.connectToDB(dbUrl, site.getDbUser(),
						site.getDbPass()) != null) {
					SiteLocalServiceUtil.updateSite(site);
					SessionMessages.add(request, "siteSaved");

				} else {
					SessionErrors.add(request, "error-db-connect");

					request.setAttribute("site", site);
					response.setRenderParameter("jspPage", editSiteJSP);

				}

			} else {
				for (String error : errors) {
					SessionErrors.add(request, error);

				}
				request.setAttribute("site", site);
				response.setRenderParameter("jspPage", editSiteJSP);

			}

		} else {
			SessionErrors.add(request, "error-updating");

			request.setAttribute("site", site);
			response.setRenderParameter("jspPage", editSiteJSP);

		}
	}

	public static List<Site> getSites(RenderRequest request) {
		List<Site> tempResults;

		try {
			tempResults = SiteLocalServiceUtil.getSites(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
		}

		catch (SystemException ex) {
			tempResults = Collections.emptyList();

		}

		return tempResults;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean validateSite(Site site, List errors) {
		boolean valid = true;

		if (Validator.isNull(site.getSiteName())) {
			errors.add("site-name-required");
			valid = false;

		}

		if (Validator.isNull(site.getUrl())) {
			errors.add("site-url-required");
			valid = false;

		} else if (Validator.isDomain(site.getUrl())) {
			errors.add("site-invalid-url");
			valid = false;

		}

		if (Validator.isNull(site.getEmailDomain())) {
			errors.add("site-email-domain-required");
			valid = false;

		} else if (Validator.isChar(site.getEmailDomain())) {
			errors.add("site-invalid-email-domain");
			valid = false;

		}

		if (Validator.isNull(site.getDbServer())) {
			errors.add("site-db-server-required");
			valid = false;

		} else {
			// Validate URL

		}

		if (Validator.isNull(site.getDbName())) {
			errors.add("site-db-name-required");
			valid = false;

		}

		if (Validator.isNull(site.getDbUser())) {
			errors.add("site-db-user-required");
			valid = false;

		}

		if (Validator.isNull(site.getDbPass())) {
			errors.add("site-db-pass-required");
			valid = false;

		}
		return valid;

	}

	protected String editSiteJSP = "/admin/edit_site.jsp";

}