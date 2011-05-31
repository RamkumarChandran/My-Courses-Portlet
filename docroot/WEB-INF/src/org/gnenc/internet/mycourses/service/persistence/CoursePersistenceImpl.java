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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.gnenc.internet.mycourses.NoSuchCourseException;
import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.impl.CourseImpl;
import org.gnenc.internet.mycourses.model.impl.CourseModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the course service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see CoursePersistence
 * @see CourseUtil
 * @generated
 */
public class CoursePersistenceImpl extends BasePersistenceImpl<Course>
	implements CoursePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = CourseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the course in the entity cache if it is enabled.
	 *
	 * @param course the course to cache
	 */
	public void cacheResult(Course course) {
		EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course);
	}

	/**
	 * Caches the courses in the entity cache if it is enabled.
	 *
	 * @param courses the courses to cache
	 */
	public void cacheResult(List<Course> courses) {
		for (Course course : courses) {
			if (EntityCacheUtil.getResult(
						CourseModelImpl.ENTITY_CACHE_ENABLED, CourseImpl.class,
						course.getPrimaryKey(), this) == null) {
				cacheResult(course);
			}
		}
	}

	/**
	 * Clears the cache for all courses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(CourseImpl.class.getName());
		EntityCacheUtil.clearCache(CourseImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the course.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Course course) {
		EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey());
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	public Course create(long courseId) {
		Course course = new CourseImpl();

		course.setNew(true);
		course.setPrimaryKey(courseId);

		return course;
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course to remove
	 * @return the course that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course to remove
	 * @return the course that was removed
	 * @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course remove(long courseId)
		throws NoSuchCourseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Course course = (Course)session.get(CourseImpl.class,
					new Long(courseId));

			if (course == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + courseId);
				}

				throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					courseId);
			}

			return remove(course);
		}
		catch (NoSuchCourseException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Course removeImpl(Course course) throws SystemException {
		course = toUnwrappedModel(course);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, course);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey());

		return course;
	}

	public Course updateImpl(org.gnenc.internet.mycourses.model.Course course,
		boolean merge) throws SystemException {
		course = toUnwrappedModel(course);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, course, merge);

			course.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
			CourseImpl.class, course.getPrimaryKey(), course);

		return course;
	}

	protected Course toUnwrappedModel(Course course) {
		if (course instanceof CourseImpl) {
			return course;
		}

		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setNew(course.isNew());
		courseImpl.setPrimaryKey(course.getPrimaryKey());

		courseImpl.setCourseId(course.getCourseId());
		courseImpl.setName(course.getName());
		courseImpl.setLastRefresh(course.getLastRefresh());

		return courseImpl;
	}

	/**
	 * Finds the course with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the course to find
	 * @return the course
	 * @throws com.liferay.portal.NoSuchModelException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the course with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchCourseException} if it could not be found.
	 *
	 * @param courseId the primary key of the course to find
	 * @return the course
	 * @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course findByPrimaryKey(long courseId)
		throws NoSuchCourseException, SystemException {
		Course course = fetchByPrimaryKey(courseId);

		if (course == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + courseId);
			}

			throw new NoSuchCourseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				courseId);
		}

		return course;
	}

	/**
	 * Finds the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course to find
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseId the primary key of the course to find
	 * @return the course, or <code>null</code> if a course with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Course fetchByPrimaryKey(long courseId) throws SystemException {
		Course course = (Course)EntityCacheUtil.getResult(CourseModelImpl.ENTITY_CACHE_ENABLED,
				CourseImpl.class, courseId, this);

		if (course == null) {
			Session session = null;

			try {
				session = openSession();

				course = (Course)session.get(CourseImpl.class,
						new Long(courseId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (course != null) {
					cacheResult(course);
				}

				closeSession(session);
			}
		}

		return course;
	}

	/**
	 * Finds all the courses.
	 *
	 * @return the courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses to return
	 * @param end the upper bound of the range of courses to return (not inclusive)
	 * @return the range of courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses to return
	 * @param end the upper bound of the range of courses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of courses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Course> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Course> list = (List<Course>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COURSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COURSE.concat(CourseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Course>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the courses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Course course : findAll()) {
			remove(course);
		}
	}

	/**
	 * Counts all the courses.
	 *
	 * @return the number of courses
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

				Query q = session.createQuery(_SQL_COUNT_COURSE);

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
	 * Gets all the entities associated with the course.
	 *
	 * @param pk the primary key of the course to get the associated entities for
	 * @return the entities associated with the course
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.gnenc.internet.mycourses.model.Entity> getEntities(long pk)
		throws SystemException {
		return getEntities(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Gets a range of all the entities associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the course to get the associated entities for
	 * @param start the lower bound of the range of courses to return
	 * @param end the upper bound of the range of courses to return (not inclusive)
	 * @return the range of entities associated with the course
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.gnenc.internet.mycourses.model.Entity> getEntities(
		long pk, int start, int end) throws SystemException {
		return getEntities(pk, start, end, null);
	}

	public static final FinderPath FINDER_PATH_GET_ENTITIES = new FinderPath(org.gnenc.internet.mycourses.model.impl.EntityModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.EntityModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.EntityPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getEntities",
			new String[] {
				Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});

	/**
	 * Gets an ordered range of all the entities associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param pk the primary key of the course to get the associated entities for
	 * @param start the lower bound of the range of courses to return
	 * @param end the upper bound of the range of courses to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of entities associated with the course
	 * @throws SystemException if a system exception occurred
	 */
	public List<org.gnenc.internet.mycourses.model.Entity> getEntities(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				pk, String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<org.gnenc.internet.mycourses.model.Entity> list = (List<org.gnenc.internet.mycourses.model.Entity>)FinderCacheUtil.getResult(FINDER_PATH_GET_ENTITIES,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				String sql = null;

				if (orderByComparator != null) {
					sql = _SQL_GETENTITIES.concat(ORDER_BY_CLAUSE)
										  .concat(orderByComparator.getOrderBy());
				}
				else {
					sql = _SQL_GETENTITIES.concat(org.gnenc.internet.mycourses.model.impl.EntityModelImpl.ORDER_BY_SQL);
				}

				SQLQuery q = session.createSQLQuery(sql);

				q.addEntity("MC_Entity",
					org.gnenc.internet.mycourses.model.impl.EntityImpl.class);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pk);

				list = (List<org.gnenc.internet.mycourses.model.Entity>)QueryUtil.list(q,
						getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_GET_ENTITIES,
						finderArgs);
				}
				else {
					entityPersistence.cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_GET_ENTITIES,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	public static final FinderPath FINDER_PATH_GET_ENTITIES_SIZE = new FinderPath(org.gnenc.internet.mycourses.model.impl.EntityModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.EntityModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.EntityPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"getEntitiesSize", new String[] { Long.class.getName() });

	/**
	 * Gets the number of entities associated with the course.
	 *
	 * @param pk the primary key of the course to get the number of associated entities for
	 * @return the number of entities associated with the course
	 * @throws SystemException if a system exception occurred
	 */
	public int getEntitiesSize(long pk) throws SystemException {
		Object[] finderArgs = new Object[] { pk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_GET_ENTITIES_SIZE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				SQLQuery q = session.createSQLQuery(_SQL_GETENTITIESSIZE);

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

				FinderCacheUtil.putResult(FINDER_PATH_GET_ENTITIES_SIZE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public static final FinderPath FINDER_PATH_CONTAINS_ENTITY = new FinderPath(org.gnenc.internet.mycourses.model.impl.EntityModelImpl.ENTITY_CACHE_ENABLED,
			org.gnenc.internet.mycourses.model.impl.EntityModelImpl.FINDER_CACHE_ENABLED,
			org.gnenc.internet.mycourses.service.persistence.EntityPersistenceImpl.FINDER_CLASS_NAME_LIST,
			"containsEntity",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Determines if the entity is associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @param entityPK the primary key of the entity
	 * @return <code>true</code> if the entity is associated with the course; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsEntity(long pk, long entityPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { pk, entityPK };

		Boolean value = (Boolean)FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_ENTITY,
				finderArgs, this);

		if (value == null) {
			try {
				value = Boolean.valueOf(containsEntity.contains(pk, entityPK));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (value == null) {
					value = Boolean.FALSE;
				}

				FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_ENTITY,
					finderArgs, value);
			}
		}

		return value.booleanValue();
	}

	/**
	 * Determines if the course has any entities associated with it.
	 *
	 * @param pk the primary key of the course to check for associations with entities
	 * @return <code>true</code> if the course has any entities associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	public boolean containsEntities(long pk) throws SystemException {
		if (getEntitiesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Initializes the course persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.gnenc.internet.mycourses.model.Course")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Course>> listenersList = new ArrayList<ModelListener<Course>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Course>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		containsEntity = new ContainsEntity(this);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CourseImpl.class.getName());
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
	protected ContainsEntity containsEntity;

	protected class ContainsEntity {
		protected ContainsEntity(CoursePersistenceImpl persistenceImpl) {
			super();

			_mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
					_SQL_CONTAINSENTITY,
					new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
					RowMapper.COUNT);
		}

		protected boolean contains(long courseId, long entityId) {
			List<Integer> results = _mappingSqlQuery.execute(new Object[] {
						new Long(courseId), new Long(entityId)
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

	private static final String _SQL_SELECT_COURSE = "SELECT course FROM Course course";
	private static final String _SQL_COUNT_COURSE = "SELECT COUNT(course) FROM Course course";
	private static final String _SQL_GETENTITIES = "SELECT {MC_Entity.*} FROM MC_Entity INNER JOIN MC_Course ON (MC_Course.courseId = MC_Entity.courseId) WHERE (MC_Course.courseId = ?)";
	private static final String _SQL_GETENTITIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Entity WHERE courseId = ?";
	private static final String _SQL_CONTAINSENTITY = "SELECT COUNT(*) AS COUNT_VALUE FROM MC_Entity WHERE courseId = ? AND entityId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "course.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Course exists with the primary key ";
	private static Log _log = LogFactoryUtil.getLog(CoursePersistenceImpl.class);
}