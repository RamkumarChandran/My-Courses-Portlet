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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import org.gnenc.internet.mycourses.NoSuchUserEnrollmentException;
import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl;
import org.gnenc.internet.mycourses.model.impl.UserEnrollmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the user enrollment service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link UserEnrollmentUtil} to access the user enrollment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see UserEnrollmentPersistence
 * @see UserEnrollmentUtil
 * @generated
 */
public class UserEnrollmentPersistenceImpl extends BasePersistenceImpl<UserEnrollment>
	implements UserEnrollmentPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = UserEnrollmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_USERID_COURSEID = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByUserId_CourseId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_COURSEID = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByUserId_CourseId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COURSEID = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByCourseId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COURSEID = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByCourseId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_LASTREFRESH = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findByLastRefresh",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTREFRESH = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countByLastRefresh",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the user enrollment in the entity cache if it is enabled.
	 *
	 * @param userEnrollment the user enrollment to cache
	 */
	public void cacheResult(UserEnrollment userEnrollment) {
		EntityCacheUtil.putResult(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentImpl.class, userEnrollment.getPrimaryKey(),
			userEnrollment);
	}

	/**
	 * Caches the user enrollments in the entity cache if it is enabled.
	 *
	 * @param userEnrollments the user enrollments to cache
	 */
	public void cacheResult(List<UserEnrollment> userEnrollments) {
		for (UserEnrollment userEnrollment : userEnrollments) {
			if (EntityCacheUtil.getResult(
						UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
						UserEnrollmentImpl.class,
						userEnrollment.getPrimaryKey(), this) == null) {
				cacheResult(userEnrollment);
			}
		}
	}

	/**
	 * Clears the cache for all user enrollments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(UserEnrollmentImpl.class.getName());
		EntityCacheUtil.clearCache(UserEnrollmentImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the user enrollment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(UserEnrollment userEnrollment) {
		EntityCacheUtil.removeResult(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentImpl.class, userEnrollment.getPrimaryKey());
	}

	/**
	 * Creates a new user enrollment with the primary key. Does not add the user enrollment to the database.
	 *
	 * @param id the primary key for the new user enrollment
	 * @return the new user enrollment
	 */
	public UserEnrollment create(long id) {
		UserEnrollment userEnrollment = new UserEnrollmentImpl();

		userEnrollment.setNew(true);
		userEnrollment.setPrimaryKey(id);

		return userEnrollment;
	}

	/**
	 * Removes the user enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user enrollment to remove
	 * @return the user enrollment that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the user enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the user enrollment to remove
	 * @return the user enrollment that was removed
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment remove(long id)
		throws NoSuchUserEnrollmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserEnrollment userEnrollment = (UserEnrollment)session.get(UserEnrollmentImpl.class,
					new Long(id));

			if (userEnrollment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
				}

				throw new NoSuchUserEnrollmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					id);
			}

			return remove(userEnrollment);
		}
		catch (NoSuchUserEnrollmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEnrollment removeImpl(UserEnrollment userEnrollment)
		throws SystemException {
		userEnrollment = toUnwrappedModel(userEnrollment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userEnrollment);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentImpl.class, userEnrollment.getPrimaryKey());

		return userEnrollment;
	}

	public UserEnrollment updateImpl(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment,
		boolean merge) throws SystemException {
		userEnrollment = toUnwrappedModel(userEnrollment);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userEnrollment, merge);

			userEnrollment.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
			UserEnrollmentImpl.class, userEnrollment.getPrimaryKey(),
			userEnrollment);

		return userEnrollment;
	}

	protected UserEnrollment toUnwrappedModel(UserEnrollment userEnrollment) {
		if (userEnrollment instanceof UserEnrollmentImpl) {
			return userEnrollment;
		}

		UserEnrollmentImpl userEnrollmentImpl = new UserEnrollmentImpl();

		userEnrollmentImpl.setNew(userEnrollment.isNew());
		userEnrollmentImpl.setPrimaryKey(userEnrollment.getPrimaryKey());

		userEnrollmentImpl.setId(userEnrollment.getId());
		userEnrollmentImpl.setUserId(userEnrollment.getUserId());
		userEnrollmentImpl.setCourseId(userEnrollment.getCourseId());
		userEnrollmentImpl.setLastRefresh(userEnrollment.getLastRefresh());

		return userEnrollmentImpl;
	}

	/**
	 * Finds the user enrollment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user enrollment to find
	 * @return the user enrollment
	 * @throws com.liferay.portal.NoSuchModelException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the user enrollment with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchUserEnrollmentException} if it could not be found.
	 *
	 * @param id the primary key of the user enrollment to find
	 * @return the user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByPrimaryKey(long id)
		throws NoSuchUserEnrollmentException, SystemException {
		UserEnrollment userEnrollment = fetchByPrimaryKey(id);

		if (userEnrollment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchUserEnrollmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return userEnrollment;
	}

	/**
	 * Finds the user enrollment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user enrollment to find
	 * @return the user enrollment, or <code>null</code> if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the user enrollment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the user enrollment to find
	 * @return the user enrollment, or <code>null</code> if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment fetchByPrimaryKey(long id) throws SystemException {
		UserEnrollment userEnrollment = (UserEnrollment)EntityCacheUtil.getResult(UserEnrollmentModelImpl.ENTITY_CACHE_ENABLED,
				UserEnrollmentImpl.class, id, this);

		if (userEnrollment == null) {
			Session session = null;

			try {
				session = openSession();

				userEnrollment = (UserEnrollment)session.get(UserEnrollmentImpl.class,
						new Long(id));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (userEnrollment != null) {
					cacheResult(userEnrollment);
				}

				closeSession(session);
			}
		}

		return userEnrollment;
	}

	/**
	 * Finds all the user enrollments where userId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @return the matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the user enrollments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @return the range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the user enrollments where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				userId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserEnrollment> list = (List<UserEnrollment>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
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

			query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<UserEnrollment>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_USERID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first user enrollment in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		List<UserEnrollment> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last user enrollment in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		int count = countByUserId(userId);

		List<UserEnrollment> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the user enrollments before and after the current user enrollment in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current user enrollment
	 * @param userId the user id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment[] findByUserId_PrevAndNext(long id, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		UserEnrollment userEnrollment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			UserEnrollment[] array = new UserEnrollmentImpl[3];

			array[0] = getByUserId_PrevAndNext(session, userEnrollment, userId,
					orderByComparator, true);

			array[1] = userEnrollment;

			array[2] = getByUserId_PrevAndNext(session, userEnrollment, userId,
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

	protected UserEnrollment getByUserId_PrevAndNext(Session session,
		UserEnrollment userEnrollment, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(userEnrollment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEnrollment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the user enrollments where userId = &#63; and courseId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @return the matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByUserId_CourseId(long userId, long courseId)
		throws SystemException {
		return findByUserId_CourseId(userId, courseId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the user enrollments where userId = &#63; and courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @return the range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByUserId_CourseId(long userId,
		long courseId, int start, int end) throws SystemException {
		return findByUserId_CourseId(userId, courseId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the user enrollments where userId = &#63; and courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByUserId_CourseId(long userId,
		long courseId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				userId, courseId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserEnrollment> list = (List<UserEnrollment>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID_COURSEID,
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

			query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_COURSEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_COURSEID_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(courseId);

				list = (List<UserEnrollment>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_USERID_COURSEID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID_COURSEID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first user enrollment in the ordered set where userId = &#63; and courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByUserId_CourseId_First(long userId,
		long courseId, OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		List<UserEnrollment> list = findByUserId_CourseId(userId, courseId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", courseId=");
			msg.append(courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last user enrollment in the ordered set where userId = &#63; and courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByUserId_CourseId_Last(long userId,
		long courseId, OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		int count = countByUserId_CourseId(userId, courseId);

		List<UserEnrollment> list = findByUserId_CourseId(userId, courseId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", courseId=");
			msg.append(courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the user enrollments before and after the current user enrollment in the ordered set where userId = &#63; and courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current user enrollment
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment[] findByUserId_CourseId_PrevAndNext(long id,
		long userId, long courseId, OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		UserEnrollment userEnrollment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			UserEnrollment[] array = new UserEnrollmentImpl[3];

			array[0] = getByUserId_CourseId_PrevAndNext(session,
					userEnrollment, userId, courseId, orderByComparator, true);

			array[1] = userEnrollment;

			array[2] = getByUserId_CourseId_PrevAndNext(session,
					userEnrollment, userId, courseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEnrollment getByUserId_CourseId_PrevAndNext(Session session,
		UserEnrollment userEnrollment, long userId, long courseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

		query.append(_FINDER_COLUMN_USERID_COURSEID_USERID_2);

		query.append(_FINDER_COLUMN_USERID_COURSEID_COURSEID_2);

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
			query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(courseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(userEnrollment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEnrollment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the user enrollments where courseId = &#63;.
	 *
	 * @param courseId the course id to search with
	 * @return the matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByCourseId(long courseId)
		throws SystemException {
		return findByCourseId(courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the user enrollments where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param courseId the course id to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @return the range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByCourseId(long courseId, int start, int end)
		throws SystemException {
		return findByCourseId(courseId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the user enrollments where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param courseId the course id to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByCourseId(long courseId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				courseId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserEnrollment> list = (List<UserEnrollment>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COURSEID,
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

			query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				list = (List<UserEnrollment>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_COURSEID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COURSEID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first user enrollment in the ordered set where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param courseId the course id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByCourseId_First(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		List<UserEnrollment> list = findByCourseId(courseId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseId=");
			msg.append(courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last user enrollment in the ordered set where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param courseId the course id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByCourseId_Last(long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		int count = countByCourseId(courseId);

		List<UserEnrollment> list = findByCourseId(courseId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("courseId=");
			msg.append(courseId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the user enrollments before and after the current user enrollment in the ordered set where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current user enrollment
	 * @param courseId the course id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment[] findByCourseId_PrevAndNext(long id, long courseId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		UserEnrollment userEnrollment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			UserEnrollment[] array = new UserEnrollmentImpl[3];

			array[0] = getByCourseId_PrevAndNext(session, userEnrollment,
					courseId, orderByComparator, true);

			array[1] = userEnrollment;

			array[2] = getByCourseId_PrevAndNext(session, userEnrollment,
					courseId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEnrollment getByCourseId_PrevAndNext(Session session,
		UserEnrollment userEnrollment, long courseId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

		query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

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
			query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(courseId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(userEnrollment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEnrollment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the user enrollments where lastRefresh = &#63;.
	 *
	 * @param lastRefresh the last refresh to search with
	 * @return the matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByLastRefresh(Date lastRefresh)
		throws SystemException {
		return findByLastRefresh(lastRefresh, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the user enrollments where lastRefresh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param lastRefresh the last refresh to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @return the range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByLastRefresh(Date lastRefresh, int start,
		int end) throws SystemException {
		return findByLastRefresh(lastRefresh, start, end, null);
	}

	/**
	 * Finds an ordered range of all the user enrollments where lastRefresh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param lastRefresh the last refresh to search with
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findByLastRefresh(Date lastRefresh, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				lastRefresh,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserEnrollment> list = (List<UserEnrollment>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LASTREFRESH,
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

			query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

			if (lastRefresh == null) {
				query.append(_FINDER_COLUMN_LASTREFRESH_LASTREFRESH_1);
			}
			else {
				query.append(_FINDER_COLUMN_LASTREFRESH_LASTREFRESH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (lastRefresh != null) {
					qPos.add(CalendarUtil.getTimestamp(lastRefresh));
				}

				list = (List<UserEnrollment>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_LASTREFRESH,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LASTREFRESH,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first user enrollment in the ordered set where lastRefresh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param lastRefresh the last refresh to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByLastRefresh_First(Date lastRefresh,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		List<UserEnrollment> list = findByLastRefresh(lastRefresh, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("lastRefresh=");
			msg.append(lastRefresh);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last user enrollment in the ordered set where lastRefresh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param lastRefresh the last refresh to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a matching user enrollment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment findByLastRefresh_Last(Date lastRefresh,
		OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		int count = countByLastRefresh(lastRefresh);

		List<UserEnrollment> list = findByLastRefresh(lastRefresh, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("lastRefresh=");
			msg.append(lastRefresh);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEnrollmentException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the user enrollments before and after the current user enrollment in the ordered set where lastRefresh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current user enrollment
	 * @param lastRefresh the last refresh to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next user enrollment
	 * @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEnrollment[] findByLastRefresh_PrevAndNext(long id,
		Date lastRefresh, OrderByComparator orderByComparator)
		throws NoSuchUserEnrollmentException, SystemException {
		UserEnrollment userEnrollment = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			UserEnrollment[] array = new UserEnrollmentImpl[3];

			array[0] = getByLastRefresh_PrevAndNext(session, userEnrollment,
					lastRefresh, orderByComparator, true);

			array[1] = userEnrollment;

			array[2] = getByLastRefresh_PrevAndNext(session, userEnrollment,
					lastRefresh, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEnrollment getByLastRefresh_PrevAndNext(Session session,
		UserEnrollment userEnrollment, Date lastRefresh,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERENROLLMENT_WHERE);

		if (lastRefresh == null) {
			query.append(_FINDER_COLUMN_LASTREFRESH_LASTREFRESH_1);
		}
		else {
			query.append(_FINDER_COLUMN_LASTREFRESH_LASTREFRESH_2);
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
			query.append(UserEnrollmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (lastRefresh != null) {
			qPos.add(CalendarUtil.getTimestamp(lastRefresh));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(userEnrollment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEnrollment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the user enrollments.
	 *
	 * @return the user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the user enrollments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @return the range of user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the user enrollments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user enrollments to return
	 * @param end the upper bound of the range of user enrollments to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEnrollment> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<UserEnrollment> list = (List<UserEnrollment>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERENROLLMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERENROLLMENT.concat(UserEnrollmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserEnrollment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserEnrollment>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the user enrollments where userId = &#63; from the database.
	 *
	 * @param userId the user id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (UserEnrollment userEnrollment : findByUserId(userId)) {
			remove(userEnrollment);
		}
	}

	/**
	 * Removes all the user enrollments where userId = &#63; and courseId = &#63; from the database.
	 *
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_CourseId(long userId, long courseId)
		throws SystemException {
		for (UserEnrollment userEnrollment : findByUserId_CourseId(userId,
				courseId)) {
			remove(userEnrollment);
		}
	}

	/**
	 * Removes all the user enrollments where courseId = &#63; from the database.
	 *
	 * @param courseId the course id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCourseId(long courseId) throws SystemException {
		for (UserEnrollment userEnrollment : findByCourseId(courseId)) {
			remove(userEnrollment);
		}
	}

	/**
	 * Removes all the user enrollments where lastRefresh = &#63; from the database.
	 *
	 * @param lastRefresh the last refresh to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLastRefresh(Date lastRefresh) throws SystemException {
		for (UserEnrollment userEnrollment : findByLastRefresh(lastRefresh)) {
			remove(userEnrollment);
		}
	}

	/**
	 * Removes all the user enrollments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserEnrollment userEnrollment : findAll()) {
			remove(userEnrollment);
		}
	}

	/**
	 * Counts all the user enrollments where userId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @return the number of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENROLLMENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the user enrollments where userId = &#63; and courseId = &#63;.
	 *
	 * @param userId the user id to search with
	 * @param courseId the course id to search with
	 * @return the number of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_CourseId(long userId, long courseId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, courseId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_COURSEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERENROLLMENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_COURSEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_COURSEID_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(courseId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_COURSEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the user enrollments where courseId = &#63;.
	 *
	 * @param courseId the course id to search with
	 * @return the number of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCourseId(long courseId) throws SystemException {
		Object[] finderArgs = new Object[] { courseId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COURSEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENROLLMENT_WHERE);

			query.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(courseId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COURSEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the user enrollments where lastRefresh = &#63;.
	 *
	 * @param lastRefresh the last refresh to search with
	 * @return the number of matching user enrollments
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLastRefresh(Date lastRefresh) throws SystemException {
		Object[] finderArgs = new Object[] { lastRefresh };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LASTREFRESH,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENROLLMENT_WHERE);

			if (lastRefresh == null) {
				query.append(_FINDER_COLUMN_LASTREFRESH_LASTREFRESH_1);
			}
			else {
				query.append(_FINDER_COLUMN_LASTREFRESH_LASTREFRESH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (lastRefresh != null) {
					qPos.add(CalendarUtil.getTimestamp(lastRefresh));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LASTREFRESH,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the user enrollments.
	 *
	 * @return the number of user enrollments
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

				Query q = session.createQuery(_SQL_COUNT_USERENROLLMENT);

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
	 * Initializes the user enrollment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gnenc.internet.mycourses.model.UserEnrollment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserEnrollment>> listenersList = new ArrayList<ModelListener<UserEnrollment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserEnrollment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserEnrollmentImpl.class.getName());
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
	private static final String _SQL_SELECT_USERENROLLMENT = "SELECT userEnrollment FROM UserEnrollment userEnrollment";
	private static final String _SQL_SELECT_USERENROLLMENT_WHERE = "SELECT userEnrollment FROM UserEnrollment userEnrollment WHERE ";
	private static final String _SQL_COUNT_USERENROLLMENT = "SELECT COUNT(userEnrollment) FROM UserEnrollment userEnrollment";
	private static final String _SQL_COUNT_USERENROLLMENT_WHERE = "SELECT COUNT(userEnrollment) FROM UserEnrollment userEnrollment WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userEnrollment.userId = ?";
	private static final String _FINDER_COLUMN_USERID_COURSEID_USERID_2 = "userEnrollment.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_COURSEID_COURSEID_2 = "userEnrollment.courseId = ?";
	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 = "userEnrollment.courseId = ?";
	private static final String _FINDER_COLUMN_LASTREFRESH_LASTREFRESH_1 = "userEnrollment.lastRefresh IS NULL";
	private static final String _FINDER_COLUMN_LASTREFRESH_LASTREFRESH_2 = "userEnrollment.lastRefresh = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userEnrollment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserEnrollment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserEnrollment exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(UserEnrollmentPersistenceImpl.class);
}