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

import org.gnenc.internet.mycourses.model.Site;

/**
 * The persistence interface for the site service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SiteUtil} to access the site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see SitePersistenceImpl
 * @see SiteUtil
 * @generated
 */
public interface SitePersistence extends BasePersistence<Site> {
	/**
	* Caches the site in the entity cache if it is enabled.
	*
	* @param site the site to cache
	*/
	public void cacheResult(org.gnenc.internet.mycourses.model.Site site);

	/**
	* Caches the sites in the entity cache if it is enabled.
	*
	* @param sites the sites to cache
	*/
	public void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.Site> sites);

	/**
	* Creates a new site with the primary key. Does not add the site to the database.
	*
	* @param siteId the primary key for the new site
	* @return the new site
	*/
	public org.gnenc.internet.mycourses.model.Site create(long siteId);

	/**
	* Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteId the primary key of the site to remove
	* @return the site that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site remove(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	public org.gnenc.internet.mycourses.model.Site updateImpl(
		org.gnenc.internet.mycourses.model.Site site, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the site with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchSiteException} if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site findByPrimaryKey(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds the site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site, or <code>null</code> if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site fetchByPrimaryKey(
		long siteId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the sites where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the sites where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @return the range of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the sites where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first site in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a matching site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds the last site in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a matching site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds the sites before and after the current site in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the primary key of the current site
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site[] findByCompanyId_PrevAndNext(
		long siteId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds all the sites where emailDomain = &#63;.
	*
	* @param emailDomain the email domain to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByEmailDomain(
		java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the sites where emailDomain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomain the email domain to search with
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @return the range of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByEmailDomain(
		java.lang.String emailDomain, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the sites where emailDomain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomain the email domain to search with
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByEmailDomain(
		java.lang.String emailDomain, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first site in the ordered set where emailDomain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomain the email domain to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a matching site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site findByEmailDomain_First(
		java.lang.String emailDomain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds the last site in the ordered set where emailDomain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param emailDomain the email domain to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a matching site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site findByEmailDomain_Last(
		java.lang.String emailDomain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds the sites before and after the current site in the ordered set where emailDomain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the primary key of the current site
	* @param emailDomain the email domain to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site[] findByEmailDomain_PrevAndNext(
		long siteId, java.lang.String emailDomain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds all the sites where url = &#63;.
	*
	* @param url the url to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByUrl(
		java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the sites where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @return the range of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByUrl(
		java.lang.String url, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the sites where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findByUrl(
		java.lang.String url, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first site in the ordered set where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a matching site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site findByUrl_First(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds the last site in the ordered set where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a matching site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site findByUrl_Last(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds the sites before and after the current site in the ordered set where url = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the primary key of the current site
	* @param url the url to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Site[] findByUrl_PrevAndNext(
		long siteId, java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException;

	/**
	* Finds all the sites.
	*
	* @return the sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the sites.
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
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Site> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sites where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sites where emailDomain = &#63; from the database.
	*
	* @param emailDomain the email domain to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmailDomain(java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sites where url = &#63; from the database.
	*
	* @param url the url to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the sites where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the sites where emailDomain = &#63;.
	*
	* @param emailDomain the email domain to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailDomain(java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the sites where url = &#63;.
	*
	* @param url the url to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the sites.
	*
	* @return the number of sites
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the courses associated with the site.
	*
	* @param pk the primary key of the site to get the associated courses for
	* @return the courses associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the courses associated with the site.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the site to get the associated courses for
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @return the range of courses associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the courses associated with the site.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the site to get the associated courses for
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of courses associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of courses associated with the site.
	*
	* @param pk the primary key of the site to get the number of associated courses for
	* @return the number of courses associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public int getCoursesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the course is associated with the site.
	*
	* @param pk the primary key of the site
	* @param coursePK the primary key of the course
	* @return <code>true</code> if the course is associated with the site; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsCourse(long pk, long coursePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the site has any courses associated with it.
	*
	* @param pk the primary key of the site to check for associations with courses
	* @return <code>true</code> if the site has any courses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsCourses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the hosts associated with the site.
	*
	* @param pk the primary key of the site to get the associated hosts for
	* @return the hosts associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the hosts associated with the site.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the site to get the associated hosts for
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @return the range of hosts associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the hosts associated with the site.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the site to get the associated hosts for
	* @param start the lower bound of the range of sites to return
	* @param end the upper bound of the range of sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of hosts associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of hosts associated with the site.
	*
	* @param pk the primary key of the site to get the number of associated hosts for
	* @return the number of hosts associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public int getHostsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the host is associated with the site.
	*
	* @param pk the primary key of the site
	* @param hostPK the primary key of the host
	* @return <code>true</code> if the host is associated with the site; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsHost(long pk, long hostPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the site has any hosts associated with it.
	*
	* @param pk the primary key of the site to check for associations with hosts
	* @return <code>true</code> if the site has any hosts associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsHosts(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}