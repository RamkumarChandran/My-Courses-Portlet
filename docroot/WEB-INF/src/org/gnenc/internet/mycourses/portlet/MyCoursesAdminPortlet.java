/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.gnenc.internet.mycourses.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.impl.EntityImpl;
import org.gnenc.internet.mycourses.service.EntityLocalServiceUtil;
public class MyCoursesAdminPortlet extends MVCPortlet {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addEntity(ActionRequest request, ActionResponse response)
			throws Exception {
		Entity entity = new EntityImpl();

		entity.setEntityId(CounterLocalServiceUtil.increment(Entity.class
				.getName()));
		entity.setEntityName(ParamUtil.getString(request, "entityName"));
		entity.setUrl(ParamUtil.getString(request, "entityUrl"));
		entity.setEmailDomains(ParamUtil
				.getString(request, "entityEmailDomain"));
		entity.setDbServer(ParamUtil.getString(request, "entityDbServer"));
		entity.setDbName(ParamUtil.getString(request, "entityDbName"));
		entity.setDbUser(ParamUtil.getString(request, "entityDbUser"));
		entity.setDbPass(ParamUtil.getString(request, "entityDbPass"));

		ArrayList<String> errors = new ArrayList();
		String dbUrl = entity.getDbServer() + "/" + entity.getDbName();

		if (validateEntity(entity, errors)) {

			if (MoodleJdbc.connectToDB(dbUrl, entity.getDbUser(),
					entity.getDbPass()) != null) {
				EntityLocalServiceUtil.addEntity(entity);
				SessionMessages.add(request, "entitySaved");

			} else {
				SessionErrors.add(request, "error-db-connect");
				request.setAttribute("addEntity", entity);

			}

		} else {
			for (String error : errors) {
				SessionErrors.add(request, error);

			}
			request.setAttribute("addEntity", entity);

		}

	}

	public void editEntity(ActionRequest request, ActionResponse response)
			throws Exception {
		long entityKey = ParamUtil.getLong(request, "resourcePrimKey");

		if (Validator.isNotNull(entityKey)) {
			Entity entity = EntityLocalServiceUtil.getEntity(entityKey);
			request.setAttribute("entity", entity);
			response.setRenderParameter("jspPage", editEntityJSP);

		}

	}

	public void deleteEntity(ActionRequest request, ActionResponse response)
			throws Exception {
		long entityKey = ParamUtil.getLong(request, "resourcePrimKey");
		// ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(
		// WebKeys.THEME_DISPLAY);

		if (Validator.isNotNull(entityKey)) {
			EntityLocalServiceUtil.deleteEntity(entityKey);
			SessionMessages.add(request, "entityDeleted");

		} else {
			SessionErrors.add(request, "error-deleting");

		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateEntity(ActionRequest request, ActionResponse response)
			throws Exception {
		long entityKey = ParamUtil.getLong(request, "resourcePrimKey");
		Entity entity = EntityLocalServiceUtil.getEntity(entityKey);

		entity.setEntityName(ParamUtil.getString(request, "entityName"));
		entity.setUrl(ParamUtil.getString(request, "entityUrl"));
		entity.setEmailDomains(ParamUtil
				.getString(request, "entityEmailDomain"));
		entity.setDbServer(ParamUtil.getString(request, "entityDbServer"));
		entity.setDbName(ParamUtil.getString(request, "entityDbName"));
		entity.setDbUser(ParamUtil.getString(request, "entityDbUser"));
		entity.setDbPass(ParamUtil.getString(request, "entityDbPass"));

		ArrayList<String> errors = new ArrayList();

		String dbUrl = entity.getDbServer() + "/" + entity.getDbName();

		if (Validator.isNotNull(entityKey)) {
			if (validateEntity(entity, errors)) {
				if (MoodleJdbc.connectToDB(dbUrl, entity.getDbUser(),
						entity.getDbPass()) != null) {
					EntityLocalServiceUtil.updateEntity(entity);
					SessionMessages.add(request, "entitySaved");

				} else {
					SessionErrors.add(request, "error-db-connect");

					request.setAttribute("entity", entity);
					response.setRenderParameter("jspPage", editEntityJSP);

				}

			} else {
				for (String error : errors) {
					SessionErrors.add(request, error);

				}
				request.setAttribute("entity", entity);
				response.setRenderParameter("jspPage", editEntityJSP);

			}

		} else {
			SessionErrors.add(request, "error-updating");

			request.setAttribute("entity", entity);
			response.setRenderParameter("jspPage", editEntityJSP);

		}
	}

	public static List<Entity> getEntities(RenderRequest request) {
		List<Entity> tempResults;

		try {
			tempResults = EntityLocalServiceUtil.getEntities(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
		}

		catch (SystemException ex) {
			tempResults = Collections.emptyList();

		}

		return tempResults;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean validateEntity(Entity entity, List errors) {
		boolean valid = true;

		if (Validator.isNull(entity.getEntityName())) {
			errors.add("entity-name-required");
			valid = false;

		}

		if (Validator.isNull(entity.getUrl())) {
			errors.add("entity-url-required");
			valid = false;

		} else if (Validator.isDomain(entity.getUrl())) {
			errors.add("entity-invalid-url");
			valid = false;

		}

		if (Validator.isNull(entity.getEmailDomains())) {
			errors.add("entity-email-domain-required");
			valid = false;

		} else if (Validator.isChar(entity.getEmailDomains())) {
			errors.add("entity-invalid-email-domain");
			valid = false;

		}

		if (Validator.isNull(entity.getDbServer())) {
			errors.add("entity-db-server-required");
			valid = false;

		} else {
			// Validate URL

		}

		if (Validator.isNull(entity.getDbName())) {
			errors.add("entity-db-name-required");
			valid = false;

		}

		if (Validator.isNull(entity.getDbUser())) {
			errors.add("entity-db-user-required");
			valid = false;

		}

		if (Validator.isNull(entity.getDbPass())) {
			errors.add("entity-db-pass-required");
			valid = false;

		}
		return valid;

	}

	protected String editEntityJSP = "/admin/edit_entity.jsp";

}