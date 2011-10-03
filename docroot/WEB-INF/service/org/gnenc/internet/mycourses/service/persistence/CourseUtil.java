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
	* @param id the primary key for the new course
	* @return the new course
	*/
	public static org.gnenc.internet.mycourses.model.Course create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the course to remove
	* @return the course that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence().remove(id);
	}

	public static org.gnenc.internet.mycourses.model.Course updateImpl(
		org.gnenc.internet.mycourses.model.Course course, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(course, merge);
	}

	/**
	* Finds the course with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchCourseException} if it could not be found.
	*
	* @param id the primary key of the course to find
	* @return the course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Finds the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the course to find
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Finds all the courses where siteId = &#63;.
	*
	* @param siteId the site id to search with
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findBysiteId(
		long siteId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysiteId(siteId);
	}

	/**
	* Finds a range of all the courses where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param start the lower bound of the range of courses to return
	* @param end the upper bound of the range of courses to return (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findBysiteId(
		long siteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBysiteId(siteId, start, end);
	}

	/**
	* Finds an ordered range of all the courses where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param start the lower bound of the range of courses to return
	* @param end the upper bound of the range of courses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findBysiteId(
		long siteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBysiteId(siteId, start, end, orderByComparator);
	}

	/**
	* Finds the first course in the ordered set where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course findBysiteId_First(
		long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence().findBysiteId_First(siteId, orderByComparator);
	}

	/**
	* Finds the last course in the ordered set where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course findBysiteId_Last(
		long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence().findBysiteId_Last(siteId, orderByComparator);
	}

	/**
	* Finds the courses before and after the current course in the ordered set where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current course
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course[] findBysiteId_PrevAndNext(
		long id, long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence()
				   .findBysiteId_PrevAndNext(id, siteId, orderByComparator);
	}

	/**
	* Finds all the courses where courseId = &#63; and siteId = &#63;.
	*
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findByC_E(
		long courseId, long siteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_E(courseId, siteId);
	}

	/**
	* Finds a range of all the courses where courseId = &#63; and siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @param start the lower bound of the range of courses to return
	* @param end the upper bound of the range of courses to return (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findByC_E(
		long courseId, long siteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_E(courseId, siteId, start, end);
	}

	/**
	* Finds an ordered range of all the courses where courseId = &#63; and siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @param start the lower bound of the range of courses to return
	* @param end the upper bound of the range of courses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.Course> findByC_E(
		long courseId, long siteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_E(courseId, siteId, start, end, orderByComparator);
	}

	/**
	* Finds the first course in the ordered set where courseId = &#63; and siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course findByC_E_First(
		long courseId, long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence()
				   .findByC_E_First(courseId, siteId, orderByComparator);
	}

	/**
	* Finds the last course in the ordered set where courseId = &#63; and siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course findByC_E_Last(
		long courseId, long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence()
				   .findByC_E_Last(courseId, siteId, orderByComparator);
	}

	/**
	* Finds the courses before and after the current course in the ordered set where courseId = &#63; and siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current course
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next course
	* @throws org.gnenc.internet.mycourses.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.Course[] findByC_E_PrevAndNext(
		long id, long courseId, long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return getPersistence()
				   .findByC_E_PrevAndNext(id, courseId, siteId,
			orderByComparator);
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
	* Removes all the courses where siteId = &#63; from the database.
	*
	* @param siteId the site id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBysiteId(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBysiteId(siteId);
	}

	/**
	* Removes all the courses where courseId = &#63; and siteId = &#63; from the database.
	*
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_E(long courseId, long siteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_E(courseId, siteId);
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
	* Counts all the courses where siteId = &#63;.
	*
	* @param siteId the site id to search with
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBysiteId(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBysiteId(siteId);
	}

	/**
	* Counts all the courses where courseId = &#63; and siteId = &#63;.
	*
	* @param courseId the course id to search with
	* @param siteId the site id to search with
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_E(long courseId, long siteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_E(courseId, siteId);
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