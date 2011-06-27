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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the user enrollment local service. This utility wraps {@link org.gnenc.internet.mycourses.service.impl.UserEnrollmentLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link org.gnenc.internet.mycourses.service.impl.UserEnrollmentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see UserEnrollmentLocalService
 * @see org.gnenc.internet.mycourses.service.base.UserEnrollmentLocalServiceBaseImpl
 * @see org.gnenc.internet.mycourses.service.impl.UserEnrollmentLocalServiceImpl
 * @generated
 */
public class UserEnrollmentLocalServiceUtil {
	/**
	* Adds the user enrollment to the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to add
	* @return the user enrollment that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment addUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserEnrollment(userEnrollment);
	}

	/**
	* Creates a new user enrollment with the primary key. Does not add the user enrollment to the database.
	*
	* @param id the primary key for the new user enrollment
	* @return the new user enrollment
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment createUserEnrollment(
		long id) {
		return getService().createUserEnrollment(id);
	}

	/**
	* Deletes the user enrollment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the user enrollment to delete
	* @throws PortalException if a user enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserEnrollment(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserEnrollment(id);
	}

	/**
	* Deletes the user enrollment from the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserEnrollment(userEnrollment);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the user enrollment with the primary key.
	*
	* @param id the primary key of the user enrollment to get
	* @return the user enrollment
	* @throws PortalException if a user enrollment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment getUserEnrollment(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEnrollment(id);
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
	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> getUserEnrollments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEnrollments(start, end);
	}

	/**
	* Gets the number of user enrollments.
	*
	* @return the number of user enrollments
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserEnrollmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEnrollmentsCount();
	}

	/**
	* Updates the user enrollment in the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to update
	* @return the user enrollment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment updateUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserEnrollment(userEnrollment);
	}

	/**
	* Updates the user enrollment in the database. Also notifies the appropriate model listeners.
	*
	* @param userEnrollment the user enrollment to update
	* @param merge whether to merge the user enrollment with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user enrollment that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.gnenc.internet.mycourses.model.UserEnrollment updateUserEnrollment(
		org.gnenc.internet.mycourses.model.UserEnrollment userEnrollment,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserEnrollment(userEnrollment, merge);
	}

	public static java.util.List<org.gnenc.internet.mycourses.model.UserEnrollment> getUserEnrollmentsByUserId(
		long userId) {
		return getService().getUserEnrollmentsByUserId(userId);
	}

	public static org.gnenc.internet.mycourses.model.UserEnrollment getByUid_CourseId(
		long userId, long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByUid_CourseId(userId, courseId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserEnrollmentLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					UserEnrollmentLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new UserEnrollmentLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(UserEnrollmentLocalService service) {
		_service = service;
	}

	private static UserEnrollmentLocalService _service;
}