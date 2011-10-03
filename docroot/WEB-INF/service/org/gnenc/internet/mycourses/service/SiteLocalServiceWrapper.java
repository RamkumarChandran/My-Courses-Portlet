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
 * This class is a wrapper for {@link SiteLocalService}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       SiteLocalService
 * @generated
 */
public class SiteLocalServiceWrapper implements SiteLocalService {
	public SiteLocalServiceWrapper(SiteLocalService siteLocalService) {
		_siteLocalService = siteLocalService;
	}

	/**
	* Adds the site to the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to add
	* @return the site that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site addSite(
		org.gnenc.internet.mycourses.model.Site site)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteLocalService.addSite(site);
	}

	/**
	* Creates a new site with the primary key. Does not add the site to the database.
	*
	* @param siteId the primary key for the new site
	* @return the new site
	*/
	public org.gnenc.internet.mycourses.model.Site createSite(long siteId) {
		return _siteLocalService.createSite(siteId);
	}

	/**
	* Deletes the site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteId the primary key of the site to delete
	* @throws PortalException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSite(long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_siteLocalService.deleteSite(siteId);
	}

	/**
	* Deletes the site from the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSite(org.gnenc.internet.mycourses.model.Site site)
		throws com.liferay.portal.kernel.exception.SystemException {
		_siteLocalService.deleteSite(site);
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
		return _siteLocalService.dynamicQuery(dynamicQuery);
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
		return _siteLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _siteLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _siteLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the site with the primary key.
	*
	* @param siteId the primary key of the site to get
	* @return the site
	* @throws PortalException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site getSite(long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _siteLocalService.getSite(siteId);
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
	public java.util.List<org.gnenc.internet.mycourses.model.Site> getSites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteLocalService.getSites(start, end);
	}

	/**
	* Gets the number of sites.
	*
	* @return the number of sites
	* @throws SystemException if a system exception occurred
	*/
	public int getSitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteLocalService.getSitesCount();
	}

	/**
	* Updates the site in the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to update
	* @return the site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site updateSite(
		org.gnenc.internet.mycourses.model.Site site)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteLocalService.updateSite(site);
	}

	/**
	* Updates the site in the database. Also notifies the appropriate model listeners.
	*
	* @param site the site to update
	* @param merge whether to merge the site with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site updateSite(
		org.gnenc.internet.mycourses.model.Site site, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteLocalService.updateSite(site, merge);
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
	public java.util.List<org.gnenc.internet.mycourses.model.Site> getSiteByDomain(
		java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _siteLocalService.getSiteByDomain(emailDomain);
	}

	public java.lang.String getSiteUrl(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return _siteLocalService.getSiteUrl(siteId);
	}

	public java.lang.String getSiteName(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return _siteLocalService.getSiteName(siteId);
	}

	public SiteLocalService getWrappedSiteLocalService() {
		return _siteLocalService;
	}

	private SiteLocalService _siteLocalService;
}