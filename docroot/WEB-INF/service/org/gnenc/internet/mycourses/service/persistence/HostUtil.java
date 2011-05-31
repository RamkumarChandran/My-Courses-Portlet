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

import org.gnenc.internet.mycourses.model.Host;

import java.util.List;

/**
 * The persistence utility for the host service. This utility wraps {@link HostPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see HostPersistence
 * @see HostPersistenceImpl
 * @generated
 */
public class HostUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Host host) {
		getPersistence().clearCache(host);
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
	public static List<Host> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Host> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Host> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Host remove(Host host) throws SystemException {
		return getPersistence().remove(host);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Host update(Host host, boolean merge)
		throws SystemException {
		return getPersistence().update(host, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Host update(Host host, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(host, merge, serviceContext);
	}

	/**
	* Caches the host in the entity cache if it is enabled.
	*
	* @param host the host to cache
	*/
	public static void cacheResult(org.gnenc.internet.mycourses.model.Host host) {
		getPersistence().cacheResult(host);
	}

	/**
	* Caches the hosts in the entity cache if it is enabled.
	*
	* @param hosts the hosts to cache
	*/
	public static void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.Host> hosts) {
		getPersistence().cacheResult(hosts);
	}

	/**
	* Creates a new host with the primary key. Does not add the host to the database.
	*
	* @param hostId the primary key for the new host
	* @return the new host
	*/
	public static org.gnenc.internet.mycourses.model.Host create(long hostId) {
		return getPersistence().create(hostId);
	}

	/**
	* Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hostId the primary key of the host to remove
	* @return the host that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Host remove(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException {
		return getPersistence().remove(hostId);
	}

	public static org.gnenc.internet.mycourses.model.Host updateImpl(
		org.gnenc.internet.mycourses.model.Host host, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(host, merge);
	}

	/**
	* Finds the host with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchHostException} if it could not be found.
	*
	* @param hostId the primary key of the host to find
	* @return the host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Host findByPrimaryKey(
		long hostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException {
		return getPersistence().findByPrimaryKey(hostId);
	}

	/**
	* Finds the host with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hostId the primary key of the host to find
	* @return the host, or <code>null</code> if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Host fetchByPrimaryKey(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(hostId);
	}

	/**
	* Finds all the hosts where localEntityId = &#63; and remoteEntityId = &#63;.
	*
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @return the matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> findByLRentity(
		long localEntityId, long remoteEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLRentity(localEntityId, remoteEntityId);
	}

	/**
	* Finds a range of all the hosts where localEntityId = &#63; and remoteEntityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @param start the lower bound of the range of hosts to return
	* @param end the upper bound of the range of hosts to return (not inclusive)
	* @return the range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> findByLRentity(
		long localEntityId, long remoteEntityId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLRentity(localEntityId, remoteEntityId, start, end);
	}

	/**
	* Finds an ordered range of all the hosts where localEntityId = &#63; and remoteEntityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @param start the lower bound of the range of hosts to return
	* @param end the upper bound of the range of hosts to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> findByLRentity(
		long localEntityId, long remoteEntityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLRentity(localEntityId, remoteEntityId, start, end,
			orderByComparator);
	}

	/**
	* Finds the first host in the ordered set where localEntityId = &#63; and remoteEntityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Host findByLRentity_First(
		long localEntityId, long remoteEntityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException {
		return getPersistence()
				   .findByLRentity_First(localEntityId, remoteEntityId,
			orderByComparator);
	}

	/**
	* Finds the last host in the ordered set where localEntityId = &#63; and remoteEntityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a matching host could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Host findByLRentity_Last(
		long localEntityId, long remoteEntityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException {
		return getPersistence()
				   .findByLRentity_Last(localEntityId, remoteEntityId,
			orderByComparator);
	}

	/**
	* Finds the hosts before and after the current host in the ordered set where localEntityId = &#63; and remoteEntityId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hostId the primary key of the current host
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next host
	* @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Host[] findByLRentity_PrevAndNext(
		long hostId, long localEntityId, long remoteEntityId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchHostException {
		return getPersistence()
				   .findByLRentity_PrevAndNext(hostId, localEntityId,
			remoteEntityId, orderByComparator);
	}

	/**
	* Finds all the hosts.
	*
	* @return the hosts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the hosts where localEntityId = &#63; and remoteEntityId = &#63; from the database.
	*
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLRentity(long localEntityId, long remoteEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLRentity(localEntityId, remoteEntityId);
	}

	/**
	* Removes all the hosts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the hosts where localEntityId = &#63; and remoteEntityId = &#63;.
	*
	* @param localEntityId the local entity id to search with
	* @param remoteEntityId the remote entity id to search with
	* @return the number of matching hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLRentity(long localEntityId, long remoteEntityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLRentity(localEntityId, remoteEntityId);
	}

	/**
	* Counts all the hosts.
	*
	* @return the number of hosts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HostPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HostPersistence)PortletBeanLocatorUtil.locate(org.gnenc.internet.mycourses.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					HostPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(HostPersistence persistence) {
		_persistence = persistence;
	}

	private static HostPersistence _persistence;
}