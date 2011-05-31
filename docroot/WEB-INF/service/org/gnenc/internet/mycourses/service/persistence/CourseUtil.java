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

import org.gnenc.internet.mycourses.model.Course;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link CoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see CoursePersistence
 * @see CoursePersistenceImpl
 * @generated
 */
public class CourseUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Course course) {
		getPersistence().clearCache(course);
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
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Course remove(Course course) throws SystemException {
		return getPersistence().remove(course);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Course update(Course course, boolean merge)
		throws SystemException {
		return getPersistence().update(course, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Course update(Course course, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(course, merge, serviceContext);
	}

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course to cache
	*/
	public static void cacheResult(
		org.gnenc.internet.mycourses.model.Course course) {
		getPersistence().cacheResult(course);
	}

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses to cache
	*/
	public static void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.Course> courses) {
		getPersistence().cacheResult(courses);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param courseId the primary key for the new course
	* @return the new course
	*/
	public static org.gnenc.internet.mycourses.model.Course create(
		long courseId) {
		return getPersistence().create(courseId);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param courseId the primary key of the course to remove
	* @return the course that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course remove(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence().remove(courseId);
	}

	public static org.gnenc.internet.mycourses.model.Course updateImpl(
		org.gnenc.internet.mycourses.model.Course course, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(course, merge);
	}

	/**
	* Finds the course with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchCourseException} if it could not be found.
	*
	* @param courseId the primary key of the course to find
	* @return the course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course findByPrimaryKey(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence().findByPrimaryKey(courseId);
	}

	/**
	* Finds the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param courseId the primary key of the course to find
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course fetchByPrimaryKey(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(courseId);
	}

	/**
	* Finds all the courses.
	*
	* @return the courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the entities associated with the course.
	*
	* @param pk the primary key of the course to get the associated entities for
	* @return the entities associated with the course
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> getEntities(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEntities(pk);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> getEntities(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEntities(pk, start, end);
	}

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
	public static java.util.List<org.gnenc.internet.mycourses.model.Entity> getEntities(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEntities(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of entities associated with the course.
	*
	* @param pk the primary key of the course to get the number of associated entities for
	* @return the number of entities associated with the course
	* @throws SystemException if a system exception occurred
	*/
	public static int getEntitiesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getEntitiesSize(pk);
	}

	/**
	* Determines if the entity is associated with the course.
	*
	* @param pk the primary key of the course
	* @param entityPK the primary key of the entity
	* @return <code>true</code> if the entity is associated with the course; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsEntity(long pk, long entityPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsEntity(pk, entityPK);
	}

	/**
	* Determines if the course has any entities associated with it.
	*
	* @param pk the primary key of the course to check for associations with entities
	* @return <code>true</code> if the course has any entities associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsEntities(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsEntities(pk);
	}

	public static CoursePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoursePersistence)PortletBeanLocatorUtil.locate(org.gnenc.internet.mycourses.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					CoursePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(CoursePersistence persistence) {
		_persistence = persistence;
	}

	private static CoursePersistence _persistence;
}