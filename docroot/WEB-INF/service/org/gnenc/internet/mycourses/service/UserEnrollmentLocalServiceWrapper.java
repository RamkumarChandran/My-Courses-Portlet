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
 * This class is a wrapper for {@link UserEnrollmentLocalService}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       UserEnrollmentLocalService
 * @generated
 */
public class UserEnrollmentLocalServiceWrapper
	implements UserEnrollmentLocalService {
	public UserEnrollmentLocalServiceWrapper(
		UserEnrollmentLocalService userEnrollmentLocalService) {
		_userEnrollmentLocalService = userEnrollmentLocalService;
	}

	/**
	* Adds the user enrollment to the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to add
	* @return the user enrollment that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.UserEnrollment addUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEnrollmentLocalService.addUserEnrollment(userEnrollment);
	}

	/**
	* Creates a new user enrollment with the primary key. Does not add the user enrollment to the database.
	*
	* @param id the primary key for the new user enrollment
	* @return the new user enrollment
	*/
	public org.gnenc.internet.mycourses.model.UserEnrollment createUserEnrollment(
		long id) {
		return _userEnrollmentLocalService.createUserEnrollment(id);
	}

	/**
	* Deletes the user enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user enrollment to delete
	* @throws PortalException if a user enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserEnrollment(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userEnrollmentLocalService.deleteUserEnrollment(id);
	}

	/**
	* Deletes the user enrollment from the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userEnrollmentLocalService.deleteUserEnrollment(userEnrollment);
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
		return _userEnrollmentLocalService.dynamicQuery(dynamicQuery);
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
		return _userEnrollmentLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _userEnrollmentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _userEnrollmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the user enrollment with the primary key.
	*
	* @param id the primary key of the user enrollment to get
	* @return the user enrollment
	* @throws PortalException if a user enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.UserEnrollment getUserEnrollment(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userEnrollmentLocalService.getUserEnrollment(id);
	}

	/**
	* Gets a range of all the user enrollments.
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
	public java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> getUserEnrollments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEnrollmentLocalService.getUserEnrollments(start, end);
	}

	/**
	* Gets the number of user enrollments.
	*
	* @return the number of user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public int getUserEnrollmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEnrollmentLocalService.getUserEnrollmentsCount();
	}

	/**
	* Updates the user enrollment in the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to update
	* @return the user enrollment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.UserEnrollment updateUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEnrollmentLocalService.updateUserEnrollment(userEnrollment);
	}

	/**
	* Updates the user enrollment in the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to update
	* @param merge whether to merge the user enrollment with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user enrollment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.gnenc.internet.mycourses.model.UserEnrollment updateUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEnrollmentLocalService.updateUserEnrollment(userEnrollment,
			merge);
	}

	public java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> getUserEnrollmentsByUserId(
		long userId) {
		return _userEnrollmentLocalService.getUserEnrollmentsByUserId(userId);
	}

	public UserEnrollmentLocalService getWrappedUserEnrollmentLocalService() {
		return _userEnrollmentLocalService;
	}

	private UserEnrollmentLocalService _userEnrollmentLocalService;
}