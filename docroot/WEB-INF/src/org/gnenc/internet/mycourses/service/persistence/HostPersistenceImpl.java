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
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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

import org.gnenc.internet.mycourses.NoSuchHostException;
import org.gnenc.internet.mycourses.model.Host;
import org.gnenc.internet.mycourses.model.impl.HostImpl;
import org.gnenc.internet.mycourses.model.impl.HostModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the host service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link HostUtil} to access the host persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see HostPersistence
 * @see HostUtil
 * @generated
 */
public class HostPersistenceImpl extends BasePersistenceImpl<Host>
	implements HostPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = HostImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_LRSITE = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByLRsite",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LRSITE = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByLRsite",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the host in the entity cache if it is enabled.
	 *
	 * @param host the host to cache
	 */
	public void cacheResult(Host host) {
		EntityCacheUtil.putResult(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostImpl.class, host.getPrimaryKey(), host);
	}

	/**
	 * Caches the hosts in the entity cache if it is enabled.
	 *
	 * @param hosts the hosts to cache
	 */
	public void cacheResult(List<Host> hosts) {
		for (Host host : hosts) {
			if (EntityCacheUtil.getResult(HostModelImpl.ENTITY_CACHE_ENABLED,
						HostImpl.class, host.getPrimaryKey(), this) == null) {
				cacheResult(host);
			}
		}
	}

	/**
	 * Clears the cache for all hosts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(HostImpl.class.getName());
		EntityCacheUtil.clearCache(HostImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the host.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Host host) {
		EntityCacheUtil.removeResult(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostImpl.class, host.getPrimaryKey());
	}

	/**
	 * Creates a new host with the primary key. Does not add the host to the database.
	 *
	 * @param hostId the primary key for the new host
	 * @return the new host
	 */
	public Host create(long hostId) {
		Host host = new HostImpl();

		host.setNew(true);
		host.setPrimaryKey(hostId);

		return host;
	}

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the host to remove
	 * @return the host that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Host remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the host with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hostId the primary key of the host to remove
	 * @return the host that was removed
	 * @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Host remove(long hostId) throws NoSuchHostException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Host host = (Host)session.get(HostImpl.class, new Long(hostId));

			if (host == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hostId);
				}

				throw new NoSuchHostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					hostId);
			}

			return remove(host);
		}
		catch (NoSuchHostException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host removeImpl(Host host) throws SystemException {
		host = toUnwrappedModel(host);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, host);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostImpl.class, host.getPrimaryKey());

		return host;
	}

	public Host updateImpl(org.gnenc.internet.mycourses.model.Host host,
		boolean merge) throws SystemException {
		host = toUnwrappedModel(host);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, host, merge);

			host.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(HostModelImpl.ENTITY_CACHE_ENABLED,
			HostImpl.class, host.getPrimaryKey(), host);

		return host;
	}

	protected Host toUnwrappedModel(Host host) {
		if (host instanceof HostImpl) {
			return host;
		}

		HostImpl hostImpl = new HostImpl();

		hostImpl.setNew(host.isNew());
		hostImpl.setPrimaryKey(host.getPrimaryKey());

		hostImpl.setHostId(host.getHostId());
		hostImpl.setSiteId(host.getSiteId());
		hostImpl.setRemoteSiteId(host.getRemoteSiteId());
		hostImpl.setPeerId(host.getPeerId());

		return hostImpl;
	}

	/**
	 * Finds the host with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the host to find
	 * @return the host
	 * @throws com.liferay.portal.NoSuchModelException if a host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Host findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the host with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchHostException} if it could not be found.
	 *
	 * @param hostId the primary key of the host to find
	 * @return the host
	 * @throws org.gnenc.internet.mycourses.NoSuchHostException if a host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Host findByPrimaryKey(long hostId)
		throws NoSuchHostException, SystemException {
		Host host = fetchByPrimaryKey(hostId);

		if (host == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + hostId);
			}

			throw new NoSuchHostException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				hostId);
		}

		return host;
	}

	/**
	 * Finds the host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the host to find
	 * @return the host, or <code>null</code> if a host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Host fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the host with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hostId the primary key of the host to find
	 * @return the host, or <code>null</code> if a host with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Host fetchByPrimaryKey(long hostId) throws SystemException {
		Host host = (Host)EntityCacheUtil.getResult(HostModelImpl.ENTITY_CACHE_ENABLED,
				HostImpl.class, hostId, this);

		if (host == null) {
			Session session = null;

			try {
				session = openSession();

				host = (Host)session.get(HostImpl.class, new Long(hostId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (host != null) {
					cacheResult(host);
				}

				closeSession(session);
			}
		}

		return host;
	}

	/**
	 * Finds all the hosts where siteId = &#63; and remoteSiteId = &#63;.
	 *
	 * @param siteId the site id to search with
	 * @param remoteSiteId the remote site id to search with
	 * @return the matching hosts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Host> findByLRsite(long siteId, long remoteSiteId)
		throws SystemException {
		return findByLRsite(siteId, remoteSiteId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Host> findByLRsite(long siteId, long remoteSiteId, int start,
		int end) throws SystemException {
		return findByLRsite(siteId, remoteSiteId, start, end, null);
	}

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
	public List<Host> findByLRsite(long siteId, long remoteSiteId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				siteId, remoteSiteId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Host> list = (List<Host>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LRSITE,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_HOST_WHERE);

			query.append(_FINDER_COLUMN_LRSITE_SITEID_2);

			query.append(_FINDER_COLUMN_LRSITE_REMOTESITEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(HostModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(siteId);

				qPos.add(remoteSiteId);

				list = (List<Host>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_LRSITE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LRSITE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

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
	public Host findByLRsite_First(long siteId, long remoteSiteId,
		OrderByComparator orderByComparator)
		throws NoSuchHostException, SystemException {
		List<Host> list = findByLRsite(siteId, remoteSiteId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteId=");
			msg.append(siteId);

			msg.append(", remoteSiteId=");
			msg.append(remoteSiteId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHostException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Host findByLRsite_Last(long siteId, long remoteSiteId,
		OrderByComparator orderByComparator)
		throws NoSuchHostException, SystemException {
		int count = countByLRsite(siteId, remoteSiteId);

		List<Host> list = findByLRsite(siteId, remoteSiteId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteId=");
			msg.append(siteId);

			msg.append(", remoteSiteId=");
			msg.append(remoteSiteId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHostException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Host[] findByLRsite_PrevAndNext(long hostId, long siteId,
		long remoteSiteId, OrderByComparator orderByComparator)
		throws NoSuchHostException, SystemException {
		Host host = findByPrimaryKey(hostId);

		Session session = null;

		try {
			session = openSession();

			Host[] array = new HostImpl[3];

			array[0] = getByLRsite_PrevAndNext(session, host, siteId,
					remoteSiteId, orderByComparator, true);

			array[1] = host;

			array[2] = getByLRsite_PrevAndNext(session, host, siteId,
					remoteSiteId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Host getByLRsite_PrevAndNext(Session session, Host host,
		long siteId, long remoteSiteId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HOST_WHERE);

		query.append(_FINDER_COLUMN_LRSITE_SITEID_2);

		query.append(_FINDER_COLUMN_LRSITE_REMOTESITEID_2);

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
			query.append(HostModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(siteId);

		qPos.add(remoteSiteId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(host);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Host> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the hosts.
	 *
	 * @return the hosts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Host> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Host> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Host> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Host> list = (List<Host>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HOST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HOST.concat(HostModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Host>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the hosts where siteId = &#63; and remoteSiteId = &#63; from the database.
	 *
	 * @param siteId the site id to search with
	 * @param remoteSiteId the remote site id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLRsite(long siteId, long remoteSiteId)
		throws SystemException {
		for (Host host : findByLRsite(siteId, remoteSiteId)) {
			remove(host);
		}
	}

	/**
	 * Removes all the hosts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Host host : findAll()) {
			remove(host);
		}
	}

	/**
	 * Counts all the hosts where siteId = &#63; and remoteSiteId = &#63;.
	 *
	 * @param siteId the site id to search with
	 * @param remoteSiteId the remote site id to search with
	 * @return the number of matching hosts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLRsite(long siteId, long remoteSiteId)
		throws SystemException {
		Object[] finderArgs = new Object[] { siteId, remoteSiteId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LRSITE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_HOST_WHERE);

			query.append(_FINDER_COLUMN_LRSITE_SITEID_2);

			query.append(_FINDER_COLUMN_LRSITE_REMOTESITEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(siteId);

				qPos.add(remoteSiteId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LRSITE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the hosts.
	 *
	 * @return the number of hosts
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

				Query q = session.createQuery(_SQL_COUNT_HOST);

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
	 * Initializes the host persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gnenc.internet.mycourses.model.Host")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Host>> listenersList = new ArrayList<ModelListener<Host>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Host>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(HostImpl.class.getName());
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
	private static final String _SQL_SELECT_HOST = "SELECT host FROM Host host";
	private static final String _SQL_SELECT_HOST_WHERE = "SELECT host FROM Host host WHERE ";
	private static final String _SQL_COUNT_HOST = "SELECT COUNT(host) FROM Host host";
	private static final String _SQL_COUNT_HOST_WHERE = "SELECT COUNT(host) FROM Host host WHERE ";
	private static final String _FINDER_COLUMN_LRSITE_SITEID_2 = "host.siteId = ? AND ";
	private static final String _FINDER_COLUMN_LRSITE_REMOTESITEID_2 = "host.remoteSiteId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "host.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Host exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Host exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(HostPersistenceImpl.class);
}