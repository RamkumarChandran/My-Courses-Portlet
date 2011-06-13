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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import org.gnenc.internet.mycourses.model.UserEnrollment;

import java.util.List;

/**
 * The persistence utility for the user enrollment service. This utility wraps {@link UserEnrollmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see UserEnrollmentPersistence
 * @see UserEnrollmentPersistenceImpl
 * @generated
 */
public class UserEnrollmentUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserEnrollment userEnrollment) {
		getPersistence().clearCache(userEnrollment);
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
	public static List<UserEnrollment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserEnrollment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserEnrollment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static UserEnrollment remove(UserEnrollment userEnrollment)
		throws SystemException {
		return getPersistence().remove(userEnrollment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UserEnrollment update(UserEnrollment userEnrollment,
		boolean merge) throws SystemException {
		return getPersistence().update(userEnrollment, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UserEnrollment update(UserEnrollment userEnrollment,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userEnrollment, merge, serviceContext);
	}

	/**
	* Caches the user enrollment in the entity cache if it is enabled.
	*
	* @param userEnrollment the user enrollment to cache
	*/
	public static void cacheResult(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment) {
		getPersistence().cacheResult(userEnrollment);
	}

	/**
	* Caches the user enrollments in the entity cache if it is enabled.
	*
	* @param userEnrollments the user enrollments to cache
	*/
	public static void cacheResult(
		java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> userEnrollments) {
		getPersistence().cacheResult(userEnrollments);
	}

	/**
	* Creates a new user enrollment with the primary key. Does not add the user enrollment to the database.
	*
	* @param id the primary key for the new user enrollment
	* @return the new user enrollment
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the user enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user enrollment to remove
	* @return the user enrollment that was removed
	* @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence().remove(id);
	}

	public static org.gnenc.internet.mycourses.model.UserEnrollment updateImpl(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userEnrollment, merge);
	}

	/**
	* Finds the user enrollment with the primary key or throws a {@link org.gnenc.internet.mycourses.NoSuchUserEnrollmentException} if it could not be found.
	*
	* @param id the primary key of the user enrollment to find
	* @return the user enrollment
	* @throws org.gnenc.internet.mycourses.NoSuchUserEnrollmentException if a user enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Finds the user enrollment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the user enrollment to find
	* @return the user enrollment, or <code>null</code> if a user enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Finds all the user enrollments where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the matching user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment[] findByUserId_PrevAndNext(
		long id, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence()
				   .findByUserId_PrevAndNext(id, userId, orderByComparator);
	}

	/**
	* Finds all the user enrollments where courseId = &#63;.
	*
	* @param courseId the course id to search with
	* @return the matching user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByCourseId(
		long courseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(courseId, start, end);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByCourseId(
		long courseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseId(courseId, start, end, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment findByCourseId_First(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence().findByCourseId_First(courseId, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment findByCourseId_Last(
		long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence().findByCourseId_Last(courseId, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment[] findByCourseId_PrevAndNext(
		long id, long courseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence()
				   .findByCourseId_PrevAndNext(id, courseId, orderByComparator);
	}

	/**
	* Finds all the user enrollments where lastRefresh = &#63;.
	*
	* @param lastRefresh the last refresh to search with
	* @return the matching user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByLastRefresh(
		java.util.Date lastRefresh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastRefresh(lastRefresh);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByLastRefresh(
		java.util.Date lastRefresh, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLastRefresh(lastRefresh, start, end);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findByLastRefresh(
		java.util.Date lastRefresh, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLastRefresh(lastRefresh, start, end, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment findByLastRefresh_First(
		java.util.Date lastRefresh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence()
				   .findByLastRefresh_First(lastRefresh, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment findByLastRefresh_Last(
		java.util.Date lastRefresh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence()
				   .findByLastRefresh_Last(lastRefresh, orderByComparator);
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
	public static org.gnenc.internet.mycourses.model.UserEnrollment[] findByLastRefresh_PrevAndNext(
		long id, java.util.Date lastRefresh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.gnenc.internet.mycourses.NoSuchUserEnrollmentException {
		return getPersistence()
				   .findByLastRefresh_PrevAndNext(id, lastRefresh,
			orderByComparator);
	}

	/**
	* Finds all the user enrollments.
	*
	* @return the user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user enrollments where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the user enrollments where courseId = &#63; from the database.
	*
	* @param courseId the course id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseId(courseId);
	}

	/**
	* Removes all the user enrollments where lastRefresh = &#63; from the database.
	*
	* @param lastRefresh the last refresh to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLastRefresh(java.util.Date lastRefresh)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLastRefresh(lastRefresh);
	}

	/**
	* Removes all the user enrollments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the user enrollments where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Counts all the user enrollments where courseId = &#63;.
	*
	* @param courseId the course id to search with
	* @return the number of matching user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(courseId);
	}

	/**
	* Counts all the user enrollments where lastRefresh = &#63;.
	*
	* @param lastRefresh the last refresh to search with
	* @return the number of matching user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLastRefresh(java.util.Date lastRefresh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLastRefresh(lastRefresh);
	}

	/**
	* Counts all the user enrollments.
	*
	* @return the number of user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserEnrollmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserEnrollmentPersistence)PortletBeanLocatorUtil.locate(org.gnenc.internet.mycourses.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					UserEnrollmentPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(UserEnrollmentPersistence persistence) {
		_persistence = persistence;
	}

	private static UserEnrollmentPersistence _persistence;
}