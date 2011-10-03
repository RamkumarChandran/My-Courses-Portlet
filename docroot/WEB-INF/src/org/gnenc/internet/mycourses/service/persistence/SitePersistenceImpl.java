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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gnenc.internet.mycourses.NoSuchSiteException;
import org.gnenc.internet.mycourses.model.Site;
import org.gnenc.internet.mycourses.model.impl.SiteImpl;
import org.gnenc.internet.mycourses.model.impl.SiteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the site service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link SiteUtil} to access the site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see SitePersistence
 * @see SiteUtil
 * @generated
 */
public class SitePersistenceImpl extends BasePersistenceImpl<Site>
	implements SitePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SiteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILDOMAIN = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByEmailDomain",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILDOMAIN = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByEmailDomain", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_URL = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUrl",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_URL = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUrl", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the site in the entity cache if it is enabled.
	 *
	 * @param site the site to cache
	 */
	public void cacheResult(Site site) {
		EntityCacheUtil.putResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey(), site);
	}

	/**
	 * Caches the sites in the entity cache if it is enabled.
	 *
	 * @param sites the sites to cache
	 */
	public void cacheResult(List<Site> sites) {
		for (Site site : sites) {
			if (EntityCacheUtil.getResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
						SiteImpl.class, site.getPrimaryKey(), this) == null) {
				cacheResult(site);
			}
		}
	}

	/**
	 * Clears the cache for all sites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(SiteImpl.class.getName());
		EntityCacheUtil.clearCache(SiteImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the site.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Site site) {
		EntityCacheUtil.removeResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey());
	}

	/**
	 * Creates a new site with the primary key. Does not add the site to the database.
	 *
	 * @param siteId the primary key for the new site
	 * @return the new site
	 */
	public Site create(long siteId) {
		Site site = new SiteImpl();

		site.setNew(true);
		site.setPrimaryKey(siteId);

		return site;
	}

	/**
	 * Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the site to remove
	 * @return the site that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param siteId the primary key of the site to remove
	 * @return the site that was removed
	 * @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site remove(long siteId) throws NoSuchSiteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Site site = (Site)session.get(SiteImpl.class, new Long(siteId));

			if (site == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + siteId);
				}

				throw new NoSuchSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					siteId);
			}

			return remove(site);
		}
		catch (NoSuchSiteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Site removeImpl(Site site) throws SystemException {
		site = toUnwrappedModel(site);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, site);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey());

		return site;
	}

	public Site updateImpl(org.gnenc.internet.mycourses.model.Site site,
		boolean merge) throws SystemException {
		site = toUnwrappedModel(site);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, site, merge);

			site.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey(), site);

		return site;
	}

	protected Site toUnwrappedModel(Site site) {
		if (site instanceof SiteImpl) {
			return site;
		}

		SiteImpl siteImpl = new SiteImpl();

		siteImpl.setNew(site.isNew());
		siteImpl.setPrimaryKey(site.getPrimaryKey());

		siteImpl.setSiteId(site.getSiteId());
		siteImpl.setSiteName(site.getSiteName());
		siteImpl.setUrl(site.getUrl());
		siteImpl.setEmailDomain(site.getEmailDomain());
		siteImpl.setDbServer(site.getDbServer());
		siteImpl.setDbName(site.getDbName());
		siteImpl.setDbUser(site.getDbUser());
		siteImpl.setDbPass(site.getDbPass());
		siteImpl.setCompanyId(site.getCompanyId());

		return siteImpl;
	}

	/**
	 * Finds the site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the site to find
	 * @return the site
	 * @throws com.liferay.portal.NoSuchModelException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the site with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchSiteException} if it could not be found.
	 *
	 * @param siteId the primary key of the site to find
	 * @return the site
	 * @throws org.gnenc.internet.mycourses.NoSuchSiteException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findByPrimaryKey(long siteId)
		throws NoSuchSiteException, SystemException {
		Site site = fetchByPrimaryKey(siteId);

		if (site == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + siteId);
			}

			throw new NoSuchSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				siteId);
		}

		return site;
	}

	/**
	 * Finds the site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the site to find
	 * @return the site, or <code>null</code> if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param siteId the primary key of the site to find
	 * @return the site, or <code>null</code> if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site fetchByPrimaryKey(long siteId) throws SystemException {
		Site site = (Site)EntityCacheUtil.getResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
				SiteImpl.class, siteId, this);

		if (site == null) {
			Session session = null;

			try {
				session = openSession();

				site = (Site)session.get(SiteImpl.class, new Long(siteId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (site != null) {
					cacheResult(site);
				}

				closeSession(session);
			}
		}

		return site;
	}

	/**
	 * Finds all the sites where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findByCompanyId(long companyId) throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<Site> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	public List<Site> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Site> list = (List<Site>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SITE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Site>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Site findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		List<Site> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Site findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		int count = countByCompanyId(companyId);

		List<Site> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Site[] findByCompanyId_PrevAndNext(long siteId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		Site site = findByPrimaryKey(siteId);

		Session session = null;

		try {
			session = openSession();

			Site[] array = new SiteImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, site, companyId,
					orderByComparator, true);

			array[1] = site;

			array[2] = getByCompanyId_PrevAndNext(session, site, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Site getByCompanyId_PrevAndNext(Session session, Site site,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(SiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(site);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Site> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the sites where emailDomain = &#63;.
	 *
	 * @param emailDomain the email domain to search with
	 * @return the matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findByEmailDomain(String emailDomain)
		throws SystemException {
		return findByEmailDomain(emailDomain, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Site> findByEmailDomain(String emailDomain, int start, int end)
		throws SystemException {
		return findByEmailDomain(emailDomain, start, end, null);
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
	public List<Site> findByEmailDomain(String emailDomain, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				emailDomain,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Site> list = (List<Site>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILDOMAIN,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SITE_WHERE);

			if (emailDomain == null) {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_1);
			}
			else {
				if (emailDomain.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailDomain != null) {
					qPos.add(emailDomain);
				}

				list = (List<Site>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_EMAILDOMAIN,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EMAILDOMAIN,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Site findByEmailDomain_First(String emailDomain,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		List<Site> list = findByEmailDomain(emailDomain, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailDomain=");
			msg.append(emailDomain);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Site findByEmailDomain_Last(String emailDomain,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		int count = countByEmailDomain(emailDomain);

		List<Site> list = findByEmailDomain(emailDomain, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailDomain=");
			msg.append(emailDomain);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Site[] findByEmailDomain_PrevAndNext(long siteId,
		String emailDomain, OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		Site site = findByPrimaryKey(siteId);

		Session session = null;

		try {
			session = openSession();

			Site[] array = new SiteImpl[3];

			array[0] = getByEmailDomain_PrevAndNext(session, site, emailDomain,
					orderByComparator, true);

			array[1] = site;

			array[2] = getByEmailDomain_PrevAndNext(session, site, emailDomain,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Site getByEmailDomain_PrevAndNext(Session session, Site site,
		String emailDomain, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITE_WHERE);

		if (emailDomain == null) {
			query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_1);
		}
		else {
			if (emailDomain.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_3);
			}
			else {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(SiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (emailDomain != null) {
			qPos.add(emailDomain);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(site);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Site> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the sites where url = &#63;.
	 *
	 * @param url the url to search with
	 * @return the matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findByUrl(String url) throws SystemException {
		return findByUrl(url, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Site> findByUrl(String url, int start, int end)
		throws SystemException {
		return findByUrl(url, start, end, null);
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
	public List<Site> findByUrl(String url, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				url,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Site> list = (List<Site>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_URL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SITE_WHERE);

			if (url == null) {
				query.append(_FINDER_COLUMN_URL_URL_1);
			}
			else {
				if (url.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_URL_URL_3);
				}
				else {
					query.append(_FINDER_COLUMN_URL_URL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (url != null) {
					qPos.add(url);
				}

				list = (List<Site>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_URL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_URL,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Site findByUrl_First(String url, OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		List<Site> list = findByUrl(url, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("url=");
			msg.append(url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Site findByUrl_Last(String url, OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		int count = countByUrl(url);

		List<Site> list = findByUrl(url, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("url=");
			msg.append(url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Site[] findByUrl_PrevAndNext(long siteId, String url,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		Site site = findByPrimaryKey(siteId);

		Session session = null;

		try {
			session = openSession();

			Site[] array = new SiteImpl[3];

			array[0] = getByUrl_PrevAndNext(session, site, url,
					orderByComparator, true);

			array[1] = site;

			array[2] = getByUrl_PrevAndNext(session, site, url,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Site getByUrl_PrevAndNext(Session session, Site site, String url,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITE_WHERE);

		if (url == null) {
			query.append(_FINDER_COLUMN_URL_URL_1);
		}
		else {
			if (url.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URL_URL_3);
			}
			else {
				query.append(_FINDER_COLUMN_URL_URL_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(SiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (url != null) {
			qPos.add(url);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(site);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Site> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the sites.
	 *
	 * @return the sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Site> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Site> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Site> list = (List<Site>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SITE.concat(SiteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Site>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Site>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sites where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Site site : findByCompanyId(companyId)) {
			remove(site);
		}
	}

	/**
	 * Removes all the sites where emailDomain = &#63; from the database.
	 *
	 * @param emailDomain the email domain to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmailDomain(String emailDomain)
		throws SystemException {
		for (Site site : findByEmailDomain(emailDomain)) {
			remove(site);
		}
	}

	/**
	 * Removes all the sites where url = &#63; from the database.
	 *
	 * @param url the url to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUrl(String url) throws SystemException {
		for (Site site : findByUrl(url)) {
			remove(site);
		}
	}

	/**
	 * Removes all the sites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Site site : findAll()) {
			remove(site);
		}
	}

	/**
	 * Counts all the sites where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SITE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the sites where emailDomain = &#63;.
	 *
	 * @param emailDomain the email domain to search with
	 * @return the number of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmailDomain(String emailDomain) throws SystemException {
		Object[] finderArgs = new Object[] { emailDomain };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILDOMAIN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SITE_WHERE);

			if (emailDomain == null) {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_1);
			}
			else {
				if (emailDomain.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailDomain != null) {
					qPos.add(emailDomain);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILDOMAIN,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the sites where url = &#63;.
	 *
	 * @param url the url to search with
	 * @return the number of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUrl(String url) throws SystemException {
		Object[] finderArgs = new Object[] { url };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_URL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SITE_WHERE);

			if (url == null) {
				query.append(_FINDER_COLUMN_URL_URL_1);
			}
			else {
				if (url.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_URL_URL_3);
				}
				else {
					query.append(_FINDER_COLUMN_URL_URL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (url != null) {
					qPos.add(url);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_URL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the sites.
	 *
	 * @return the number of sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SITE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Gets all the courses associated with the site.
	 *
	 * @param pk the primary key of the site to get the associated courses for
	 * @return the courses associated with the site
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.gnenc.internet.mycourses.model.Course> getCourses(long pk)
		throws SystemException {
		return getCourses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	public List<org.gnenc.internet.mycourses.model.Course> getCourses(long pk,
		int start, int end) throws SystemException {
		return getCourses(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_COURSES = new FinderPath(org.gnenc.internet.mycourses.model.impl.CourseModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.CourseModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.CoursePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCourses",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

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
	public List<org.gnenc.internet.mycourses.model.Course> getCourses(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<org.gnenc.internet.mycourses.model.Course> list = (List<org.gnenc.internet.mycourses.model.Course>)FinderCacheUtil.getResult(FINDER_PATH_GET_COURSES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETCOURSES.concat(ORDER_BY_CLAUSE)
										 .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETCOURSES.concat(org.gnenc.internet.mycourses.model.impl.CourseModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("MC_Course",
					org.gnenc.internet.mycourses.model.impl.CourseImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<org.gnenc.internet.mycourses.model.Course>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_COURSES,
						finderArgs);
				}
				else {
					coursePersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_COURSES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_COURSES_SIZE = new FinderPath(org.gnenc.internet.mycourses.model.impl.CourseModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.CourseModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.CoursePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getCoursesSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of courses associated with the site.
	 *
	 * @param pk the primary key of the site to get the number of associated courses for
	 * @return the number of courses associated with the site
	 * @throws SystemException if a system exception occurred
	 */
	public int getCoursesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_COURSES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETCOURSESSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_COURSES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_COURSE = new FinderPath(org.gnenc.internet.mycourses.model.impl.CourseModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.CourseModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.CoursePersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsCourse",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines if the course is associated with the site.
	 *
	 * @param pk the primary key of the site
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the site; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsCourse(long pk, long coursePK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, coursePK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_COURSE,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsCourse.contains(pk, coursePK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_COURSE,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines if the site has any courses associated with it.
	 *
	 * @param pk the primary key of the site to check for associations with courses
	 * @return <code>true</code> if the site has any courses associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsCourses(long pk) throws SystemException {
		if (getCoursesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Gets all the hosts associated with the site.
	 *
	 * @param pk the primary key of the site to get the associated hosts for
	 * @return the hosts associated with the site
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.gnenc.internet.mycourses.model.Host> getHosts(long pk)
		throws SystemException {
		return getHosts(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	public List<org.gnenc.internet.mycourses.model.Host> getHosts(long pk,
		int start, int end) throws SystemException {
		return getHosts(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_HOSTS = new FinderPath(org.gnenc.internet.mycourses.model.impl.HostModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.HostModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.HostPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getHosts",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

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
	public List<org.gnenc.internet.mycourses.model.Host> getHosts(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<org.gnenc.internet.mycourses.model.Host> list = (List<org.gnenc.internet.mycourses.model.Host>)FinderCacheUtil.getResult(FINDER_PATH_GET_HOSTS,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETHOSTS.concat(ORDER_BY_CLAUSE)
									   .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETHOSTS.concat(org.gnenc.internet.mycourses.model.impl.HostModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("MC_Host",
					org.gnenc.internet.mycourses.model.impl.HostImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<org.gnenc.internet.mycourses.model.Host>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_HOSTS,
						finderArgs);
				}
				else {
					hostPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_HOSTS,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_HOSTS_SIZE = new FinderPath(org.gnenc.internet.mycourses.model.impl.HostModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.HostModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.HostPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getHostsSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of hosts associated with the site.
	 *
	 * @param pk the primary key of the site to get the number of associated hosts for
	 * @return the number of hosts associated with the site
	 * @throws SystemException if a system exception occurred
	 */
	public int getHostsSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_HOSTS_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETHOSTSSIZE);

				q.addScalar(COUNT_COLUMN_NAME,
					com.liferay.portal.kernel.dao.orm.Type.LONG);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_GET_HOSTS_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_HOST = new FinderPath(org.gnenc.internet.mycourses.model.impl.HostModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.HostModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.HostPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsHost",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines if the host is associated with the site.
	 *
	 * @param pk the primary key of the site
	 * @param hostPK the primary key of the host
	 * @return <code>true</code> if the host is associated with the site; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsHost(long pk, long hostPK) throws SystemException {
		Object[] finderArgs = new Object[] { pk, hostPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_HOST,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsHost.contains(pk, hostPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_HOST,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines if the site has any hosts associated with it.
	 *
	 * @param pk the primary key of the site to check for associations with hosts
	 * @return <code>true</code> if the site has any hosts associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsHosts(long pk) throws SystemException {
		if (getHostsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the site persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gnenc.internet.mycourses.model.Site")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Site>> listenersList = new ArrayList<ModelListener<Site>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Site>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsCourse = new ContainsCourse(this);

		containsHost = new ContainsHost(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SiteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = SitePersistence.class)
	protected SitePersistence sitePersistence;
	@BeanReference(type = UserEnrollmentPersistence.class)
	protected UserEnrollmentPersistence userEnrollmentPersistence;
	@BeanReference(type = HostPersistence.class)
	protected HostPersistence hostPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	protected ContainsCourse containsCourse;
	protected ContainsHost containsHost;

	protected class ContainsCourse {
		protected ContainsCourse(SitePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCOURSE,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long siteId, long id) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(siteId), new Long(id)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	protected class ContainsHost {
		protected ContainsHost(SitePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSHOST,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long siteId, long hostId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(siteId), new Long(hostId)
					});

			if (results.size() > 0) {
				Integer count = results.get(0);

				if (count.intValue() > 0) {
					return true;
				}
			}

			return false;
		}

		private MappingSqlQuery<Integer> _mappingSqlQuery;
	}

	private static final String _SQL_SELECT_SITE = "SELECT site FROM Site site";
	private static final String _SQL_SELECT_SITE_WHERE = "SELECT site FROM Site site WHERE ";
	private static final String _SQL_COUNT_SITE = "SELECT COUNT(site) FROM Site site";
	private static final String _SQL_COUNT_SITE_WHERE = "SELECT COUNT(site) FROM Site site WHERE ";
	private static final String _SQL_GETCOURSES = "SELECT {MC_Course.*} FROM MC_Course INNER JOIN MC_Site ON (MC_Site.siteId = MC_Course.siteId) WHERE (MC_Site.siteId = ?)";
	private static final String _SQL_GETCOURSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Course WHERE siteId = ?";
	private static final String _SQL_CONTAINSCOURSE = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Course WHERE siteId = ? AND id_ = ?";
	private static final String _SQL_GETHOSTS = "SELECT {MC_Host.*} FROM MC_Host INNER JOIN MC_Site ON (MC_Site.siteId = MC_Host.siteId) WHERE (MC_Site.siteId = ?)";
	private static final String _SQL_GETHOSTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Host WHERE siteId = ?";
	private static final String _SQL_CONTAINSHOST = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Host WHERE siteId = ? AND hostId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "site.companyId = ?";
	private static final String _FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_1 = "site.emailDomain IS NULL";
	private static final String _FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_2 = "site.emailDomain = ?";
	private static final String _FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAIN_3 = "(site.emailDomain IS NULL OR site.emailDomain = ?)";
	private static final String _FINDER_COLUMN_URL_URL_1 = "site.url IS NULL";
	private static final String _FINDER_COLUMN_URL_URL_2 = "site.url = ?";
	private static final String _FINDER_COLUMN_URL_URL_3 = "(site.url IS NULL OR site.url = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "site.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Site exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Site exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(SitePersistenceImpl.class);
}