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

package org.gnenc.internet.mycourses.service;

/**
 * <p>
 * This class is a wrapper for {@link CourseLocalService}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       CourseLocalService
 * @generated
 */
public class CourseLocalServiceWrapper implements CourseLocalService {
	public CourseLocalServiceWrapper(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	/**
	* Adds the course to the database. Also notifies the appropriate model listeners.
	*
	* @param course the course to add
	* @return the course that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Course addCourse(
		org.gnenc.internet.mycourses.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.addCourse(course);
	}

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param id the primary key for the new course
	* @return the new course
	*/
	public org.gnenc.internet.mycourses.model.Course createCourse(long id) {
		return _courseLocalService.createCourse(id);
	}

	/**
	* Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the course to delete
	* @throws PortalException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCourse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_courseLocalService.deleteCourse(id);
	}

	/**
	* Deletes the course from the database. Also notifies the appropriate model listeners.
	*
	* @param course the course to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCourse(org.gnenc.internet.mycourses.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseLocalService.deleteCourse(course);
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
		return _courseLocalService.dynamicQuery(dynamicQuery);
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
		return _courseLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _courseLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _courseLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the course with the primary key.
	*
	* @param id the primary key of the course to get
	* @return the course
	* @throws PortalException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Course getCourse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCourse(id);
	}

	/**
	* Gets a range of all the courses.
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
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCourses(start, end);
	}

	/**
	* Gets the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	public int getCoursesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.getCoursesCount();
	}

	/**
	* Updates the course in the database. Also notifies the appropriate model listeners.
	*
	* @param course the course to update
	* @return the course that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Course updateCourse(
		org.gnenc.internet.mycourses.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.updateCourse(course);
	}

	/**
	* Updates the course in the database. Also notifies the appropriate model listeners.
	*
	* @param course the course to update
	* @param merge whether to merge the course with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the course that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Course updateCourse(
		org.gnenc.internet.mycourses.model.Course course, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLocalService.updateCourse(course, merge);
	}

	public org.gnenc.internet.mycourses.model.Course getCourseByEntity(
		long courseId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException {
		return _courseLocalService.getCourseByEntity(courseId, entityId);
	}

	public CourseLocalService getWrappedCourseLocalService() {
		return _courseLocalService;
	}

	private CourseLocalService _courseLocalService;
}