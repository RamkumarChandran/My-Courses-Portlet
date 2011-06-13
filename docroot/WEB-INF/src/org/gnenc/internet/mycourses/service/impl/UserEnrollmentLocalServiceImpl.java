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

package org.gnenc.internet.mycourses.service.impl;

import java.util.List;

import org.gnenc.internet.mycourses.model.UserEnrollment;
import org.gnenc.internet.mycourses.service.base.UserEnrollmentLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the user enrollment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gnenc.internet.mycourses.service.UserEnrollmentLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil} to access the user enrollment local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see org.gnenc.internet.mycourses.service.base.UserEnrollmentLocalServiceBaseImpl
 * @see org.gnenc.internet.mycourses.service.UserEnrollmentLocalServiceUtil
 */
public class UserEnrollmentLocalServiceImpl
	extends UserEnrollmentLocalServiceBaseImpl {
	
	public List<UserEnrollment> getUserEnrollmentsByUserId(long userId) {
		List<UserEnrollment> enrollments = null;
		
		try {
			enrollments = userEnrollmentPersistence.findByUserId(userId);
		} catch (SystemException e) {
			e.printStackTrace();
			enrollments = null;
		}
		
		return enrollments;
	}
}