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

import com.liferay.portal.service.persistence.BasePersistence;

import org.gnenc.internet.mycourses.model.Host;

/**
 * The persistence interface for the host service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link HostUtil} to access the host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see HostPersistenceImpl
 * @see HostUtil
 * @generated
 */
public interface HostPersistence extends BasePersistence<Host> {
	/**
	* Caches the host in the entity cache if it is enabled.
	*
	* @param host the host to cache
	*/
	public void cacheResult(org.gnenc.internet.mycourses.model.Host host);

	/**
	* Caches the hosts in the entity cache if it is enabled.
	*
	* @param hosts the hosts to cache
	*/
	public void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.Host> hosts);

	/**
	* Creates a new host with the primary key. Does not add the host to the database.
	*
	* @param hostId the primary key for the new host
	* @return the new host
	*/
	public org.gnenc.internet.mycourses.model.Host create(long hostId);

	/**
	* Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hostId the primary key of the host to remove
	* @return the host that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host remove(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException;

	public org.gnenc.internet.mycourses.model.Host updateImpl(
		org.gnenc.internet.mycourses.model.Host host, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the host with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchHostException} if it could not be found.
	*
	* @param hostId the primary key of the host to find
	* @return the host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host findByPrimaryKey(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException;

	/**
	* Finds the host with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hostId the primary key of the host to find
	* @return the host, or <code>null</code> if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host fetchByPrimaryKey(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the hosts where siteId = &#63; and remoteSiteId = &#63;.
	*
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @return the matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> findByLRsite(
		long siteId, long remoteSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the hosts where siteId = &#63; and remoteSiteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @param start the lower bound of the range of hosts to return
	* @param end the upper bound of the range of hosts to return (not inclusive)
	* @return the range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> findByLRsite(
		long siteId, long remoteSiteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the hosts where siteId = &#63; and remoteSiteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @param start the lower bound of the range of hosts to return
	* @param end the upper bound of the range of hosts to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> findByLRsite(
		long siteId, long remoteSiteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first host in the ordered set where siteId = &#63; and remoteSiteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host findByLRsite_First(
		long siteId, long remoteSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException;

	/**
	* Finds the last host in the ordered set where siteId = &#63; and remoteSiteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host findByLRsite_Last(
		long siteId, long remoteSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException;

	/**
	* Finds the hosts before and after the current host in the ordered set where siteId = &#63; and remoteSiteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hostId the primary key of the current host
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host[] findByLRsite_PrevAndNext(
		long hostId, long siteId, long remoteSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException;

	/**
	* Finds all the hosts.
	*
	* @return the hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of hosts to return
	* @param end the upper bound of the range of hosts to return (not inclusive)
	* @return the range of hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of hosts to return
	* @param end the upper bound of the range of hosts to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of hosts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hosts where siteId = &#63; and remoteSiteId = &#63; from the database.
	*
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLRsite(long siteId, long remoteSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hosts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the hosts where siteId = &#63; and remoteSiteId = &#63;.
	*
	* @param siteId the site id to search with
	* @param remoteSiteId the remote site id to search with
	* @return the number of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countByLRsite(long siteId, long remoteSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the hosts.
	*
	* @return the number of hosts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}