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

import org.gnenc.internet.mycourses.model.Site;

import java.util.List;

/**
 * The persistence utility for the site service. This utility wraps {@link SitePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see SitePersistence
 * @see SitePersistenceImpl
 * @generated
 */
public class SiteUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Site site) {
		getPersistence().clearCache(site);
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
	public static List<Site> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Site> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Site> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Site remove(Site site) throws SystemException {
		return getPersistence().remove(site);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Site update(Site site, boolean merge)
		throws SystemException {
		return getPersistence().update(site, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Site update(Site site, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(site, merge, serviceContext);
	}

	/**
	* Caches the site in the entity cache if it is enabled.
	*
	* @param site the site to cache
	*/
	public static void cacheResult(org.gnenc.internet.mycourses.model.Site site) {
		getPersistence().cacheResult(site);
	}

	/**
	* Caches the sites in the entity cache if it is enabled.
	*
	* @param sites the sites to cache
	*/
	public static void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.Site> sites) {
		getPersistence().cacheResult(sites);
	}

	/**
	* Creates a new site with the primary key. Does not add the site to the database.
	*
	* @param siteId the primary key for the new site
	* @return the new site
	*/
	public static org.gnenc.internet.mycourses.model.Site create(long siteId) {
		return getPersistence().create(siteId);
	}

	/**
	* Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteId the primary key of the site to remove
	* @return the site that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Site remove(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence().remove(siteId);
	}

	public static org.gnenc.internet.mycourses.model.Site updateImpl(
		org.gnenc.internet.mycourses.model.Site site, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(site, merge);
	}

	/**
	* Finds the site with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchSiteException} if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site
	* @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Site findByPrimaryKey(
		long siteId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence().findByPrimaryKey(siteId);
	}

	/**
	* Finds the site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site, or <code>null</code> if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Site fetchByPrimaryKey(
		long siteId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(siteId);
	}

	/**
	* Finds all the sites where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site[] findByCompanyId_PrevAndNext(
		long siteId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(siteId, companyId,
			orderByComparator);
	}

	/**
	* Finds all the sites where emailDomain = &#63;.
	*
	* @param emailDomain the email domain to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByEmailDomain(
		java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailDomain(emailDomain);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByEmailDomain(
		java.lang.String emailDomain, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailDomain(emailDomain, start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByEmailDomain(
		java.lang.String emailDomain, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailDomain(emailDomain, start, end, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site findByEmailDomain_First(
		java.lang.String emailDomain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence()
				   .findByEmailDomain_First(emailDomain, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site findByEmailDomain_Last(
		java.lang.String emailDomain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence()
				   .findByEmailDomain_Last(emailDomain, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site[] findByEmailDomain_PrevAndNext(
		long siteId, java.lang.String emailDomain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence()
				   .findByEmailDomain_PrevAndNext(siteId, emailDomain,
			orderByComparator);
	}

	/**
	* Finds all the sites where url = &#63;.
	*
	* @param url the url to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByUrl(
		java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUrl(url);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByUrl(
		java.lang.String url, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUrl(url, start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findByUrl(
		java.lang.String url, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUrl(url, start, end, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site findByUrl_First(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence().findByUrl_First(url, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site findByUrl_Last(
		java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence().findByUrl_Last(url, orderByComparator);
	}

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
	public static org.gnenc.internet.mycourses.model.Site[] findByUrl_PrevAndNext(
		long siteId, java.lang.String url,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchSiteException {
		return getPersistence()
				   .findByUrl_PrevAndNext(siteId, url, orderByComparator);
	}

	/**
	* Finds all the sites.
	*
	* @return the sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Site> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sites where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the sites where emailDomain = &#63; from the database.
	*
	* @param emailDomain the email domain to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmailDomain(java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmailDomain(emailDomain);
	}

	/**
	* Removes all the sites where url = &#63; from the database.
	*
	* @param url the url to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUrl(url);
	}

	/**
	* Removes all the sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the sites where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Counts all the sites where emailDomain = &#63;.
	*
	* @param emailDomain the email domain to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailDomain(java.lang.String emailDomain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailDomain(emailDomain);
	}

	/**
	* Counts all the sites where url = &#63;.
	*
	* @param url the url to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUrl(java.lang.String url)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUrl(url);
	}

	/**
	* Counts all the sites.
	*
	* @return the number of sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the courses associated with the site.
	*
	* @param pk the primary key of the site to get the associated courses for
	* @return the courses associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getCourses(pk);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getCourses(pk, start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getCourses(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of courses associated with the site.
	*
	* @param pk the primary key of the site to get the number of associated courses for
	* @return the number of courses associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public static int getCoursesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getCoursesSize(pk);
	}

	/**
	* Determines if the course is associated with the site.
	*
	* @param pk the primary key of the site
	* @param coursePK the primary key of the course
	* @return <code>true</code> if the course is associated with the site; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsCourse(long pk, long coursePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsCourse(pk, coursePK);
	}

	/**
	* Determines if the site has any courses associated with it.
	*
	* @param pk the primary key of the site to check for associations with courses
	* @return <code>true</code> if the site has any courses associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsCourses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsCourses(pk);
	}

	/**
	* Gets all the hosts associated with the site.
	*
	* @param pk the primary key of the site to get the associated hosts for
	* @return the hosts associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getHosts(pk);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getHosts(pk, start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Host> getHosts(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getHosts(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of hosts associated with the site.
	*
	* @param pk the primary key of the site to get the number of associated hosts for
	* @return the number of hosts associated with the site
	* @throws SystemException if a system exception occurred
	*/
	public static int getHostsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getHostsSize(pk);
	}

	/**
	* Determines if the host is associated with the site.
	*
	* @param pk the primary key of the site
	* @param hostPK the primary key of the host
	* @return <code>true</code> if the host is associated with the site; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsHost(long pk, long hostPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsHost(pk, hostPK);
	}

	/**
	* Determines if the site has any hosts associated with it.
	*
	* @param pk the primary key of the site to check for associations with hosts
	* @return <code>true</code> if the site has any hosts associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsHosts(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsHosts(pk);
	}

	public static SitePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SitePersistence)PortletBeanLocatorUtil.locate(org.gnenc.internet.mycourses.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					SitePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(SitePersistence persistence) {
		_persistence = persistence;
	}

	private static SitePersistence _persistence;
}