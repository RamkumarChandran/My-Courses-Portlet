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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the site local service. This utility wraps {@link org.gnenc.internet.mycourses.service.impl.SiteLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link org.gnenc.internet.mycourses.service.impl.SiteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see SiteLocalService
 * @see org.gnenc.internet.mycourses.service.base.SiteLocalServiceBaseImpl
 * @see org.gnenc.internet.mycourses.service.impl.SiteLocalServiceImpl
 * @generated
 */
public class SiteLocalServiceUtil {
	/**
	* Adds the site to the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to add
	* @return the site that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Site addSite(
		org.gnenc.internet.mycourses.model.Site site)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSite(site);
	}

	/**
	* Creates a new site with the primary key. Does not add the site to the database.
	*
	* @param siteId the primary key for the new site
	* @return the new site
	*/
	public static org.gnenc.internet.mycourses.model.Site createSite(
		long siteId) {
		return getService().createSite(siteId);
	}

	/**
	* Deletes the site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteId the primary key of the site to delete
	* @throws PortalException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSite(long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSite(siteId);
	}

	/**
	* Deletes the site from the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSite(org.gnenc.internet.mycourses.model.Site site)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSite(site);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the site with the primary key.
	*
	* @param siteId the primary key of the site to get
	* @return the site
	* @throws PortalException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Site getSite(long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSite(siteId);
	}

	/**
	* Gets a range of all the sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @return the range of sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> getSites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSites(start, end);
	}

	/**
	* Gets the number of sites.
	*
	* @return the number of sites
	* @throws SystemException if a system exception occurred
	*/
	public static int getSitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSitesCount();
	}

	/**
	* Updates the site in the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to update
	* @return the site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Site updateSite(
		org.gnenc.internet.mycourses.model.Site site)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSite(site);
	}

	/**
	* Updates the site in the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to update
	* @param merge whether to merge the site with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Site updateSite(
		org.gnenc.internet.mycourses.model.Site site, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSite(site, merge);
	}

	/**
	* Returns entity from the database. Also notifies the appropriate model
	* listeners.
	*
	* @param emailDomain
	the email domain to find by
	* @return the entity that was found
	* @throws SystemException
	if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> getSiteByDomain(
		java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSiteByDomain(emailDomain);
	}

	public static java.lang.String getSiteUrl(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getService().getSiteUrl(siteId);
	}

	public static java.lang.String getSiteName(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getService().getSiteName(siteId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SiteLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					SiteLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new SiteLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(SiteLocalService service) {
		_service = service;
	}

	private static SiteLocalService _service;
}