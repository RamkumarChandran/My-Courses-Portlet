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

package org.gnenc.internet.mycourses.service.impl;

import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.gnenc.internet.mycourses.NoSuchEntityException;
import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.service.base.EntityLocalServiceBaseImpl;

/**
 * The implementation of the entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.gnenc.internet.mycourses.service.EntityLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use
 * {@link org.gnenc.internet.mycourses.service.EntityLocalServiceUtil} to access
 * the entity local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see org.gnenc.internet.mycourses.service.base.EntityLocalServiceBaseImpl
 * @see org.gnenc.internet.mycourses.service.EntityLocalServiceUtil
 */
public class EntityLocalServiceImpl extends EntityLocalServiceBaseImpl {

	/**
	 * Returns entity from the database. Also notifies the appropriate model
	 * listeners.
	 *
	 * @param emailDomain
	 *            the email domain to find by
	 * @return the entity that was found
	 * @throws SystemException
	 *             if a system exception occurred
	 */
	public List<Entity> getEntityByDomain(String emailDomain)
			throws SystemException {
		List<Entity> entity = entityPersistence.findByEmailDomain(emailDomain);

		return entity;
	}

	public String getEntityUrl(long entityId) throws NoSuchEntityException,
			SystemException {
		Entity entity = entityPersistence.findByPrimaryKey(entityId);
		String url = entity.getUrl();

		return url;
	}

	public String getEntityName(long entityId) throws NoSuchEntityException,
			SystemException {
		Entity entity = entityPersistence.findByPrimaryKey(entityId);
		String name = entity.getEntityName();

		return name;
	}
}