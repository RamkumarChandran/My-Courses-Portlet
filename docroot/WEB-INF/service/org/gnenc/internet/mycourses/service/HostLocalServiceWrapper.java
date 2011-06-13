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

/**
 * <p>
 * This class is a wrapper for {@link HostLocalService}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       HostLocalService
 * @generated
 */
public class HostLocalServiceWrapper implements HostLocalService {
	public HostLocalServiceWrapper(HostLocalService hostLocalService) {
		_hostLocalService = hostLocalService;
	}

	/**
	* Adds the host to the database. Also notifies the appropriate model listeners.
	*
	* @param host the host to add
	* @return the host that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host addHost(
		org.gnenc.internet.mycourses.model.Host host)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hostLocalService.addHost(host);
	}

	/**
	* Creates a new host with the primary key. Does not add the host to the database.
	*
	* @param hostId the primary key for the new host
	* @return the new host
	*/
	public org.gnenc.internet.mycourses.model.Host createHost(long hostId) {
		return _hostLocalService.createHost(hostId);
	}

	/**
	* Deletes the host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hostId the primary key of the host to delete
	* @throws PortalException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHost(long hostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_hostLocalService.deleteHost(hostId);
	}

	/**
	* Deletes the host from the database. Also notifies the appropriate model listeners.
	*
	* @param host the host to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteHost(org.gnenc.internet.mycourses.model.Host host)
		throws com.liferay.portal.kernel.exception.SystemException {
		_hostLocalService.deleteHost(host);
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
		return _hostLocalService.dynamicQuery(dynamicQuery);
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
		return _hostLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _hostLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _hostLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the host with the primary key.
	*
	* @param hostId the primary key of the host to get
	* @return the host
	* @throws PortalException if a host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host getHost(long hostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _hostLocalService.getHost(hostId);
	}

	/**
	* Gets a range of all the hosts.
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
	public java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hostLocalService.getHosts(start, end);
	}

	/**
	* Gets the number of hosts.
	*
	* @return the number of hosts
	* @throws SystemException if a system exception occurred
	*/
	public int getHostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hostLocalService.getHostsCount();
	}

	/**
	* Updates the host in the database. Also notifies the appropriate model listeners.
	*
	* @param host the host to update
	* @return the host that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host updateHost(
		org.gnenc.internet.mycourses.model.Host host)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hostLocalService.updateHost(host);
	}

	/**
	* Updates the host in the database. Also notifies the appropriate model listeners.
	*
	* @param host the host to update
	* @param merge whether to merge the host with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the host that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Host updateHost(
		org.gnenc.internet.mycourses.model.Host host, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _hostLocalService.updateHost(host, merge);
	}

	public HostLocalService getWrappedHostLocalService() {
		return _hostLocalService;
	}

	private HostLocalService _hostLocalService;
}