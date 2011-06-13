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

package org.gnenc.internet.mycourses.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.gnenc.internet.mycourses.model.Entity;

/**
 * The persistence interface for the entity service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link EntityUtil} to access the entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see EntityPersistenceImpl
 * @see EntityUtil
 * @generated
 */
public interface EntityPersistence extends BasePersistence<Entity> {
	/**
	* Caches the entity in the entity cache if it is enabled.
	*
	* @param entity the entity to cache
	*/
	public void cacheResult(org.gnenc.internet.mycourses.model.Entity entity);

	/**
	* Caches the entities in the entity cache if it is enabled.
	*
	* @param entities the entities to cache
	*/
	public void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.Entity> entities);

	/**
	* Creates a new entity with the primary key. Does not add the entity to the database.
	*
	* @param entityId the primary key for the new entity
	* @return the new entity
	*/
	public org.gnenc.internet.mycourses.model.Entity create(long entityId);

	/**
	* Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entityId the primary key of the entity to remove
	* @return the entity that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity remove(long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

	public org.gnenc.internet.mycourses.model.Entity updateImpl(
		org.gnenc.internet.mycourses.model.Entity entity, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the entity with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchEntityException} if it could not be found.
	*
	* @param entityId the primary key of the entity to find
	* @return the entity
	* @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity findByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

	/**
	* Finds the entity with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param entityId the primary key of the entity to find
	* @return the entity, or <code>null</code> if a entity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Entity fetchByPrimaryKey(
		long entityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the entities where emailDomains = &#63;.
	*
	* @param emailDomains the email domains to search with
	* @return the matching entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findByEmailDomain(
		java.lang.String emailDomains)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findByEmailDomain(
		java.lang.String emailDomains, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findByEmailDomain(
		java.lang.String emailDomains, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gnenc.internet.mycourses.model.Entity findByEmailDomain_First(
		java.lang.String emailDomains,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

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
	public org.gnenc.internet.mycourses.model.Entity findByEmailDomain_Last(
		java.lang.String emailDomains,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

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
	public org.gnenc.internet.mycourses.model.Entity[] findByEmailDomain_PrevAndNext(
		long entityId, java.lang.String emailDomains,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

	/**
	* Finds all the entities where url = &#63;.
	*
	* @param url the url to search with
	* @return the matching entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findByUrl(
		java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findByUrl(
		java.lang.String url, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findByUrl(
		java.lang.String url, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.gnenc.internet.mycourses.model.Entity findByUrl_First(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

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
	public org.gnenc.internet.mycourses.model.Entity findByUrl_Last(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

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
	public org.gnenc.internet.mycourses.model.Entity[] findByUrl_PrevAndNext(
		long entityId, java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchEntityException;

	/**
	* Finds all the entities.
	*
	* @return the entities
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.gnenc.internet.mycourses.model.Entity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the entities where emailDomains = &#63; from the database.
	*
	* @param emailDomains the email domains to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmailDomain(java.lang.String emailDomains)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the entities where url = &#63; from the database.
	*
	* @param url the url to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the entities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the entities where emailDomains = &#63;.
	*
	* @param emailDomains the email domains to search with
	* @return the number of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailDomain(java.lang.String emailDomains)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the entities where url = &#63;.
	*
	* @param url the url to search with
	* @return the number of matching entities
	* @throws SystemException if a system exception occurred
	*/
	public int countByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the entities.
	*
	* @return the number of entities
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the courses associated with the entity.
	*
	* @param pk the primary key of the entity to get the associated courses for
	* @return the courses associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the courses associated with the entity.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the entity to get the associated courses for
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @return the range of courses associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the courses associated with the entity.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the entity to get the associated courses for
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of courses associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of courses associated with the entity.
	*
	* @param pk the primary key of the entity to get the number of associated courses for
	* @return the number of courses associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public int getCoursesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the course is associated with the entity.
	*
	* @param pk the primary key of the entity
	* @param coursePK the primary key of the course
	* @return <code>true</code> if the course is associated with the entity; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsCourse(long pk, long coursePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the entity has any courses associated with it.
	*
	* @param pk the primary key of the entity to check for associations with courses
	* @return <code>true</code> if the entity has any courses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsCourses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the hosts associated with the entity.
	*
	* @param pk the primary key of the entity to get the associated hosts for
	* @return the hosts associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the hosts associated with the entity.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the entity to get the associated hosts for
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @return the range of hosts associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the hosts associated with the entity.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the entity to get the associated hosts for
	* @param start the lower bound of the range of entities to return
	* @param end the upper bound of the range of entities to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of hosts associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of hosts associated with the entity.
	*
	* @param pk the primary key of the entity to get the number of associated hosts for
	* @return the number of hosts associated with the entity
	* @throws SystemException if a system exception occurred
	*/
	public int getHostsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the host is associated with the entity.
	*
	* @param pk the primary key of the entity
	* @param hostPK the primary key of the host
	* @return <code>true</code> if the host is associated with the entity; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsHost(long pk, long hostPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the entity has any hosts associated with it.
	*
	* @param pk the primary key of the entity to check for associations with hosts
	* @return <code>true</code> if the entity has any hosts associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsHosts(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}