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

import org.gnenc.internet.mycourses.NoSuchEntityException;
import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.impl.EntityImpl;
import org.gnenc.internet.mycourses.model.impl.EntityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the entity service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link EntityUtil} to access the entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see EntityPersistence
 * @see EntityUtil
 * @generated
 */
public class EntityPersistenceImpl extends BasePersistenceImpl<Entity>
	implements EntityPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = EntityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_EMAILDOMAIN = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByEmailDomain",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILDOMAIN = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByEmailDomain", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_URL = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByUrl",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_URL = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByUrl", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the entity in the entity cache if it is enabled.
	 *
	 * @param entity the entity to cache
	 */
	public void cacheResult(Entity entity) {
		EntityCacheUtil.putResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityImpl.class, entity.getPrimaryKey(), entity);
	}

	/**
	 * Caches the entities in the entity cache if it is enabled.
	 *
	 * @param entities the entities to cache
	 */
	public void cacheResult(List<Entity> entities) {
		for (Entity entity : entities) {
			if (EntityCacheUtil.getResult(
						EntityModelImpl.ENTITY_CACHE_ENABLED, EntityImpl.class,
						entity.getPrimaryKey(), this) == null) {
				cacheResult(entity);
			}
		}
	}

	/**
	 * Clears the cache for all entities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(EntityImpl.class.getName());
		EntityCacheUtil.clearCache(EntityImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the entity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Entity entity) {
		EntityCacheUtil.removeResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityImpl.class, entity.getPrimaryKey());
	}

	/**
	 * Creates a new entity with the primary key. Does not add the entity to the database.
	 *
	 * @param entityId the primary key for the new entity
	 * @return the new entity
	 */
	public Entity create(long entityId) {
		Entity entity = new EntityImpl();

		entity.setNew(true);
		entity.setPrimaryKey(entityId);

		return entity;
	}

	/**
	 * Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the entity to remove
	 * @return the entity that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entity remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the entity to remove
	 * @return the entity that was removed
	 * @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entity remove(long entityId)
		throws NoSuchEntityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Entity entity = (Entity)session.get(EntityImpl.class,
					new Long(entityId));

			if (entity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entityId);
				}

				throw new NoSuchEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					entityId);
			}

			return remove(entity);
		}
		catch (NoSuchEntityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Entity removeImpl(Entity entity) throws SystemException {
		entity = toUnwrappedModel(entity);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, entity);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityImpl.class, entity.getPrimaryKey());

		return entity;
	}

	public Entity updateImpl(org.gnenc.internet.mycourses.model.Entity entity,
		boolean merge) throws SystemException {
		entity = toUnwrappedModel(entity);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, entity, merge);

			entity.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
			EntityImpl.class, entity.getPrimaryKey(), entity);

		return entity;
	}

	protected Entity toUnwrappedModel(Entity entity) {
		if (entity instanceof EntityImpl) {
			return entity;
		}

		EntityImpl entityImpl = new EntityImpl();

		entityImpl.setNew(entity.isNew());
		entityImpl.setPrimaryKey(entity.getPrimaryKey());

		entityImpl.setEntityId(entity.getEntityId());
		entityImpl.setEntityName(entity.getEntityName());
		entityImpl.setUrl(entity.getUrl());
		entityImpl.setEmailDomains(entity.getEmailDomains());
		entityImpl.setDbName(entity.getDbName());

		return entityImpl;
	}

	/**
	 * Finds the entity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity to find
	 * @return the entity
	 * @throws com.liferay.portal.NoSuchModelException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the entity with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchEntityException} if it could not be found.
	 *
	 * @param entityId the primary key of the entity to find
	 * @return the entity
	 * @throws org.gnenc.internet.mycourses.NoSuchEntityException if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entity findByPrimaryKey(long entityId)
		throws NoSuchEntityException, SystemException {
		Entity entity = fetchByPrimaryKey(entityId);

		if (entity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + entityId);
			}

			throw new NoSuchEntityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				entityId);
		}

		return entity;
	}

	/**
	 * Finds the entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity to find
	 * @return the entity, or <code>null</code> if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the entity to find
	 * @return the entity, or <code>null</code> if a entity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Entity fetchByPrimaryKey(long entityId) throws SystemException {
		Entity entity = (Entity)EntityCacheUtil.getResult(EntityModelImpl.ENTITY_CACHE_ENABLED,
				EntityImpl.class, entityId, this);

		if (entity == null) {
			Session session = null;

			try {
				session = openSession();

				entity = (Entity)session.get(EntityImpl.class,
						new Long(entityId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (entity != null) {
					cacheResult(entity);
				}

				closeSession(session);
			}
		}

		return entity;
	}

	/**
	 * Finds all the entities where emailDomains = &#63;.
	 *
	 * @param emailDomains the email domains to search with
	 * @return the matching entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<Entity> findByEmailDomain(String emailDomains)
		throws SystemException {
		return findByEmailDomain(emailDomains, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<Entity> findByEmailDomain(String emailDomains, int start,
		int end) throws SystemException {
		return findByEmailDomain(emailDomains, start, end, null);
	}

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
	public List<Entity> findByEmailDomain(String emailDomains, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				emailDomains,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Entity> list = (List<Entity>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EMAILDOMAIN,
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

			query.append(_SQL_SELECT_ENTITY_WHERE);

			if (emailDomains == null) {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_1);
			}
			else {
				if (emailDomains.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(EntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailDomains != null) {
					qPos.add(emailDomains);
				}

				list = (List<Entity>)QueryUtil.list(q, getDialect(), start, end);
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
	public Entity findByEmailDomain_First(String emailDomains,
		OrderByComparator orderByComparator)
		throws NoSuchEntityException, SystemException {
		List<Entity> list = findByEmailDomain(emailDomains, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailDomains=");
			msg.append(emailDomains);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntityException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Entity findByEmailDomain_Last(String emailDomains,
		OrderByComparator orderByComparator)
		throws NoSuchEntityException, SystemException {
		int count = countByEmailDomain(emailDomains);

		List<Entity> list = findByEmailDomain(emailDomains, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailDomains=");
			msg.append(emailDomains);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntityException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Entity[] findByEmailDomain_PrevAndNext(long entityId,
		String emailDomains, OrderByComparator orderByComparator)
		throws NoSuchEntityException, SystemException {
		Entity entity = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Entity[] array = new EntityImpl[3];

			array[0] = getByEmailDomain_PrevAndNext(session, entity,
					emailDomains, orderByComparator, true);

			array[1] = entity;

			array[2] = getByEmailDomain_PrevAndNext(session, entity,
					emailDomains, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Entity getByEmailDomain_PrevAndNext(Session session,
		Entity entity, String emailDomains,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITY_WHERE);

		if (emailDomains == null) {
			query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_1);
		}
		else {
			if (emailDomains.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_3);
			}
			else {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_2);
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
			query.append(EntityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (emailDomains != null) {
			qPos.add(emailDomains);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(entity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Entity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the entities where url = &#63;.
	 *
	 * @param url the url to search with
	 * @return the matching entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<Entity> findByUrl(String url) throws SystemException {
		return findByUrl(url, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Entity> findByUrl(String url, int start, int end)
		throws SystemException {
		return findByUrl(url, start, end, null);
	}

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
	public List<Entity> findByUrl(String url, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				url,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Entity> list = (List<Entity>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_URL,
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

			query.append(_SQL_SELECT_ENTITY_WHERE);

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
				query.append(EntityModelImpl.ORDER_BY_JPQL);
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

				list = (List<Entity>)QueryUtil.list(q, getDialect(), start, end);
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
	public Entity findByUrl_First(String url,
		OrderByComparator orderByComparator)
		throws NoSuchEntityException, SystemException {
		List<Entity> list = findByUrl(url, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("url=");
			msg.append(url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntityException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Entity findByUrl_Last(String url, OrderByComparator orderByComparator)
		throws NoSuchEntityException, SystemException {
		int count = countByUrl(url);

		List<Entity> list = findByUrl(url, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("url=");
			msg.append(url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchEntityException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

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
	public Entity[] findByUrl_PrevAndNext(long entityId, String url,
		OrderByComparator orderByComparator)
		throws NoSuchEntityException, SystemException {
		Entity entity = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Entity[] array = new EntityImpl[3];

			array[0] = getByUrl_PrevAndNext(session, entity, url,
					orderByComparator, true);

			array[1] = entity;

			array[2] = getByUrl_PrevAndNext(session, entity, url,
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

	protected Entity getByUrl_PrevAndNext(Session session, Entity entity,
		String url, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ENTITY_WHERE);

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
			query.append(EntityModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByValues(entity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Entity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the entities.
	 *
	 * @return the entities
	 * @throws SystemException if a system exception occurred
	 */
	public List<Entity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Entity> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<Entity> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Entity> list = (List<Entity>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ENTITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENTITY.concat(EntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Entity>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Entity>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the entities where emailDomains = &#63; from the database.
	 *
	 * @param emailDomains the email domains to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEmailDomain(String emailDomains)
		throws SystemException {
		for (Entity entity : findByEmailDomain(emailDomains)) {
			remove(entity);
		}
	}

	/**
	 * Removes all the entities where url = &#63; from the database.
	 *
	 * @param url the url to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUrl(String url) throws SystemException {
		for (Entity entity : findByUrl(url)) {
			remove(entity);
		}
	}

	/**
	 * Removes all the entities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Entity entity : findAll()) {
			remove(entity);
		}
	}

	/**
	 * Counts all the entities where emailDomains = &#63;.
	 *
	 * @param emailDomains the email domains to search with
	 * @return the number of matching entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEmailDomain(String emailDomains)
		throws SystemException {
		Object[] finderArgs = new Object[] { emailDomains };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAILDOMAIN,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITY_WHERE);

			if (emailDomains == null) {
				query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_1);
			}
			else {
				if (emailDomains.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_3);
				}
				else {
					query.append(_FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (emailDomains != null) {
					qPos.add(emailDomains);
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
	 * Counts all the entities where url = &#63;.
	 *
	 * @param url the url to search with
	 * @return the number of matching entities
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUrl(String url) throws SystemException {
		Object[] finderArgs = new Object[] { url };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_URL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ENTITY_WHERE);

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
	 * Counts all the entities.
	 *
	 * @return the number of entities
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

				Query q = session.createQuery(_SQL_COUNT_ENTITY);

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
	 * Gets all the courses associated with the entity.
	 *
	 * @param pk the primary key of the entity to get the associated courses for
	 * @return the courses associated with the entity
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.gnenc.internet.mycourses.model.Course> getCourses(long pk)
		throws SystemException {
		return getCourses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	 * Gets the number of courses associated with the entity.
	 *
	 * @param pk the primary key of the entity to get the number of associated courses for
	 * @return the number of courses associated with the entity
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
	 * Determines if the course is associated with the entity.
	 *
	 * @param pk the primary key of the entity
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the entity; <code>false</code> otherwise
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
	 * Determines if the entity has any courses associated with it.
	 *
	 * @param pk the primary key of the entity to check for associations with courses
	 * @return <code>true</code> if the entity has any courses associated with it; <code>false</code> otherwise
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
	 * Gets all the hosts associated with the entity.
	 *
	 * @param pk the primary key of the entity to get the associated hosts for
	 * @return the hosts associated with the entity
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.gnenc.internet.mycourses.model.Host> getHosts(long pk)
		throws SystemException {
		return getHosts(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	 * Gets the number of hosts associated with the entity.
	 *
	 * @param pk the primary key of the entity to get the number of associated hosts for
	 * @return the number of hosts associated with the entity
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
	 * Determines if the host is associated with the entity.
	 *
	 * @param pk the primary key of the entity
	 * @param hostPK the primary key of the host
	 * @return <code>true</code> if the host is associated with the entity; <code>false</code> otherwise
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
	 * Determines if the entity has any hosts associated with it.
	 *
	 * @param pk the primary key of the entity to check for associations with hosts
	 * @return <code>true</code> if the entity has any hosts associated with it; <code>false</code> otherwise
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
	 * Initializes the entity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gnenc.internet.mycourses.model.Entity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Entity>> listenersList = new ArrayList<ModelListener<Entity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Entity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EntityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = CoursePersistence.class)
	protected CoursePersistence coursePersistence;
	@BeanReference(type = EntityPersistence.class)
	protected EntityPersistence entityPersistence;
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
		protected ContainsCourse(EntityPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSCOURSE,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long entityId, long id) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(entityId), new Long(id)
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
		protected ContainsHost(EntityPersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSHOST,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long entityId, long hostId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(entityId), new Long(hostId)
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

	private static final String _SQL_SELECT_ENTITY = "SELECT entity FROM Entity entity";
	private static final String _SQL_SELECT_ENTITY_WHERE = "SELECT entity FROM Entity entity WHERE ";
	private static final String _SQL_COUNT_ENTITY = "SELECT COUNT(entity) FROM Entity entity";
	private static final String _SQL_COUNT_ENTITY_WHERE = "SELECT COUNT(entity) FROM Entity entity WHERE ";
	private static final String _SQL_GETCOURSES = "SELECT {MC_Course.*} FROM MC_Course INNER JOIN MC_Entity ON (MC_Entity.entityId = MC_Course.entityId) WHERE (MC_Entity.entityId = ?)";
	private static final String _SQL_GETCOURSESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Course WHERE entityId = ?";
	private static final String _SQL_CONTAINSCOURSE = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Course WHERE entityId = ? AND id_ = ?";
	private static final String _SQL_GETHOSTS = "SELECT {MC_Host.*} FROM MC_Host INNER JOIN MC_Entity ON (MC_Entity.entityId = MC_Host.entityId) WHERE (MC_Entity.entityId = ?)";
	private static final String _SQL_GETHOSTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Host WHERE entityId = ?";
	private static final String _SQL_CONTAINSHOST = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Host WHERE entityId = ? AND hostId = ?";
	private static final String _FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_1 = "entity.emailDomains IS NULL";
	private static final String _FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_2 = "entity.emailDomains = ?";
	private static final String _FINDER_COLUMN_EMAILDOMAIN_EMAILDOMAINS_3 = "(entity.emailDomains IS NULL OR entity.emailDomains = ?)";
	private static final String _FINDER_COLUMN_URL_URL_1 = "entity.url IS NULL";
	private static final String _FINDER_COLUMN_URL_URL_2 = "entity.url = ?";
	private static final String _FINDER_COLUMN_URL_URL_3 = "(entity.url IS NULL OR entity.url = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "entity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Entity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Entity exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(EntityPersistenceImpl.class);
}