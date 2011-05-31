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

package org.gnenc.internet.mycourses.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import org.gnenc.internet.mycourses.model.Entity;

import java.util.List;

/**
 * The persistence utility for the entity service. This utility wraps {@link EntityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see EntityPersistence
 * @see EntityPersistenceImpl
 * @generated
 */
public class EntityUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Entity entity) {
		getPersistence().clearCache(entity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Entity> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Entity> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Entity> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Entity remove(Entity entity) throws SystemException {
		return getPersistence().remove(entity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Entity update(Entity entity, boolean merge)
		throws SystemException {
		return getPersistence().update(entity, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Entity update(Entity entity, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(entity, merge, serviceContext);
	}

	/**
	* Caches the entity in the entity cache if it is enabled.
	*
	* @param entity the entity to cache
	*/
	public static void cacheResult(
		org.gnenc.internet.mycourses.model.Entity entity) {
		getPersistence().cacheResult(entity);
	}

	/**
	* Caches the entities in the entity cache if it is enabled.
	*
	* @param entities the entities to cache
	*/
	public static void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.Entity> entities) {
		getPersistence().cacheResult(entities);
	}

	/**
	* Creates a new entity with the primary key. Does not add the entity to the database.
	*
	* @param entityId the primary key for the new entity
	* @return the new entity
	*/
	public static org.gnenc.internet.mycourses.model.Entity create(
		long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	* Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity to remove
	* @return the entity that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity remove(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence().remove(entityId);
	}

	public static org.gnenc.internet.mycourses.model.Entity updateImpl(
		org.gnenc.internet.mycourses.model.Entity entity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(entity, merge);
	}

	/**
	* Finds the entity with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchEntityException} if it could not be found.
	*
	* @param entityId the primary key of the entity to find
	* @return the entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity findByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	* Finds the entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the entity to find
	* @return the entity, or <code>null</code> if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	* Finds all the entities where emailDomains = &#63;.
	*
	* @param emailDomains the email domains to search with
	* @return the matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findByEmailDomain(
		java.lang.String emailDomains)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailDomain(emailDomains);
	}

	/**
	* Finds a range of all the entities where emailDomains = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomains the email domains to search with
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @return the range of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findByEmailDomain(
		java.lang.String emailDomains, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailDomain(emailDomains, start, end);
	}

	/**
	* Finds an ordered range of all the entities where emailDomains = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomains the email domains to search with
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findByEmailDomain(
		java.lang.String emailDomains, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailDomain(emailDomains, start, end,
			orderByComparator);
	}

	/**
	* Finds the first entity in the ordered set where emailDomains = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomains the email domains to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity findByEmailDomain_First(
		java.lang.String emailDomains,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence()
				   .findByEmailDomain_First(emailDomains, orderByComparator);
	}

	/**
	* Finds the last entity in the ordered set where emailDomains = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomains the email domains to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity findByEmailDomain_Last(
		java.lang.String emailDomains,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence()
				   .findByEmailDomain_Last(emailDomains, orderByComparator);
	}

	/**
	* Finds the entities before and after the current entity in the ordered set where emailDomains = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entityId the primary key of the current entity
	* @param emailDomains the email domains to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity[] findByEmailDomain_PrevAndNext(
		long entityId, java.lang.String emailDomains,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence()
				   .findByEmailDomain_PrevAndNext(entityId, emailDomains,
			orderByComparator);
	}

	/**
	* Finds all the entities where url = &#63;.
	*
	* @param url the url to search with
	* @return the matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findByUrl(
		java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUrl(url);
	}

	/**
	* Finds a range of all the entities where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @return the range of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findByUrl(
		java.lang.String url, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUrl(url, start, end);
	}

	/**
	* Finds an ordered range of all the entities where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findByUrl(
		java.lang.String url, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUrl(url, start, end, orderByComparator);
	}

	/**
	* Finds the first entity in the ordered set where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity findByUrl_First(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence().findByUrl_First(url, orderByComparator);
	}

	/**
	* Finds the last entity in the ordered set where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a matching entity could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity findByUrl_Last(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence().findByUrl_Last(url, orderByComparator);
	}

	/**
	* Finds the entities before and after the current entity in the ordered set where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param entityId the primary key of the current entity
	* @param url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Entity[] findByUrl_PrevAndNext(
		long entityId, java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException {
		return getPersistence()
				   .findByUrl_PrevAndNext(entityId, url, orderByComparator);
	}

	/**
	* Finds all the entities.
	*
	* @return the entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the entities.
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
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the entities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of entities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the entities where emailDomains = &#63; from the database.
	*
	* @param emailDomains the email domains to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmailDomain(java.lang.String emailDomains)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmailDomain(emailDomains);
	}

	/**
	* Removes all the entities where url = &#63; from the database.
	*
	* @param url the url to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUrl(url);
	}

	/**
	* Removes all the entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the entities where emailDomains = &#63;.
	*
	* @param emailDomains the email domains to search with
	* @return the number of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailDomain(java.lang.String emailDomains)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailDomain(emailDomains);
	}

	/**
	* Counts all the entities where url = &#63;.
	*
	* @param url the url to search with
	* @return the number of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUrl(url);
	}

	/**
	* Counts all the entities.
	*
	* @return the number of entities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EntityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EntityPersistence)PortletBeanLocatorUtil.locate(org.gnenc.internet.mycourses.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					EntityPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(EntityPersistence persistence) {
		_persistence = persistence;
	}

	private static EntityPersistence _persistence;
}