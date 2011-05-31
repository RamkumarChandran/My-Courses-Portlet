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

package org.gnenc.internet.mycourses.service;

/**
 * <p>
 * This class is a wrapper for {@link EntityLocalService}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       EntityLocalService
 * @generated
 */
public class EntityLocalServiceWrapper implements EntityLocalService {
	public EntityLocalServiceWrapper(EntityLocalService entityLocalService) {
		_entityLocalService = entityLocalService;
	}

	/**
	* Adds the entity to the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity to add
	* @return the entity that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity addEntity(
		org.gnenc.internet.mycourses.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.addEntity(entity);
	}

	/**
	* Creates a new entity with the primary key. Does not add the entity to the database.
	*
	* @param entityId the primary key for the new entity
	* @return the new entity
	*/
	public org.gnenc.internet.mycourses.model.Entity createEntity(long entityId) {
		return _entityLocalService.createEntity(entityId);
	}

	/**
	* Deletes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity to delete
	* @throws PortalException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_entityLocalService.deleteEntity(entityId);
	}

	/**
	* Deletes the entity from the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEntity(org.gnenc.internet.mycourses.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException {
		_entityLocalService.deleteEntity(entity);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the entity with the primary key.
	*
	* @param entityId the primary key of the entity to get
	* @return the entity
	* @throws PortalException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity getEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.getEntity(entityId);
	}

	/**
	* Gets a range of all the entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @return the range of entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> getEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.getEntities(start, end);
	}

	/**
	* Gets the number of entities.
	*
	* @return the number of entities
	* @throws SystemException if a system exception occurred
	*/
	public int getEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.getEntitiesCount();
	}

	/**
	* Updates the entity in the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity to update
	* @return the entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity updateEntity(
		org.gnenc.internet.mycourses.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.updateEntity(entity);
	}

	/**
	* Updates the entity in the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity to update
	* @param merge whether to merge the entity with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity updateEntity(
		org.gnenc.internet.mycourses.model.Entity entity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _entityLocalService.updateEntity(entity, merge);
	}

	public EntityLocalService getWrappedEntityLocalService() {
		return _entityLocalService;
	}

	private EntityLocalService _entityLocalService;
}