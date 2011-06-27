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

import org.gnenc.internet.mycourses.NoSuchCourseException;
import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.impl.CourseImpl;
import org.gnenc.internet.mycourses.service.base.CourseLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.gnenc.internet.mycourses.service.CourseLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link org.gnenc.internet.mycourses.service.CourseLocalServiceUtil} to access the course local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see org.gnenc.internet.mycourses.service.base.CourseLocalServiceBaseImpl
 * @see org.gnenc.internet.mycourses.service.CourseLocalServiceUtil
 */
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {
	
	public Course getCourseByEntity(long courseId, long entityId) throws NoSuchCourseException, SystemException {

		List<Course> course = coursePersistence.findByC_E(courseId, entityId);
		
		Course c = new CourseImpl();
		
		if (course.size() == 1) {
			c.setId(course.get(0).getId());
			c.setCourseId(course.get(0).getCourseId());
			c.setName(course.get(0).getName());
			c.setEntityId(course.get(0).getEntityId());
		} else if (course.size() == 0) {
			c = null;
		}
		//if (course.getEntityId() != entityId) {
		//	course = null;
		//}
		return c;
	}
}