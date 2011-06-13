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

package org.gnenc.internet.mycourses.service;

import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The interface for the course local service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link CourseLocalServiceUtil} to access the course local service. Add custom service methods to {@link org.gnenc.internet.mycourses.service.impl.CourseLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see CourseLocalServiceUtil
 * @see org.gnenc.internet.mycourses.service.base.CourseLocalServiceBaseImpl
 * @see org.gnenc.internet.mycourses.service.impl.CourseLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CourseLocalService {
	/**
	* Adds the course to the database. Also notifies the appropriate model listeners.
	*
	* @param course the course to add
	* @return the course that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Course addCourse(
		org.gnenc.internet.mycourses.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param id the primary key for the new course
	* @return the new course
	*/
	public org.gnenc.internet.mycourses.model.Course createCourse(long id);

	/**
	* Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the course to delete
	* @throws PortalException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCourse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the course from the database. Also notifies the appropriate model listeners.
	*
	* @param course the course to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCourse(org.gnenc.internet.mycourses.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the course with the primary key.
	*
	* @param id the primary key of the course to get
	* @return the course
	* @throws PortalException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gnenc.internet.mycourses.model.Course getCourse(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.gnenc.internet.mycourses.model.Course> getCourses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCoursesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the course in the database. Also notifies the appropriate model listeners.
	*
	* @param course the course to update
	* @return the course that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.Course updateCourse(
		org.gnenc.internet.mycourses.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.gnenc.internet.mycourses.model.Course getCourseByEntity(
		long courseId, long entityId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchCourseException;
}