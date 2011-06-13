/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the entity local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link EntityLocalServiceUtil} to access the entity local service. Add custom service methods to {@link org.gnenc.internet.mycourses.service.impl.EntityLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see EntityLocalServiceUtil
 * @see org.gnenc.internet.mycourses.service.base.EntityLocalServiceBaseImpl
 * @see org.gnenc.internet.mycourses.service.impl.EntityLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EntityLocalService {
	/**
	* Adds the entity to the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity to add
	* @return the entity that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity addEntity(
		org.gnenc.internet.mycourses.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new entity with the primary key. Does not add the entity to the database.
	*
	* @param entityId the primary key for the new entity
	* @return the new entity
	*/
	public org.gnenc.internet.mycourses.model.Entity createEntity(long entityId);

	/**
	* Deletes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity to delete
	* @throws PortalException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the entity from the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteEntity(org.gnenc.internet.mycourses.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the entity with the primary key.
	*
	* @param entityId the primary key of the entity to get
	* @return the entity
	* @throws PortalException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gnenc.internet.mycourses.model.Entity getEntity(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> getEntities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of entities.
	*
	* @return the number of entities
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEntitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the entity in the database. Also notifies the appropriate model listeners.
	*
	* @param entity the entity to update
	* @return the entity that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity updateEntity(
		org.gnenc.internet.mycourses.model.Entity entity)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns entity from the database. Also notifies the appropriate model listeners.
	*
	* @param emailDomain the email domain to find by
	* @return the entity that was found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> getEntityByDomain(
		java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getEntityUrl(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getEntityName(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;
}