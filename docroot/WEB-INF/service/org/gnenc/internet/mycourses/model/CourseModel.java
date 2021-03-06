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

package org.gnenc.internet.mycourses.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Course service. Represents a row in the &quot;MC_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gnenc.internet.mycourses.model.impl.CourseModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gnenc.internet.mycourses.model.impl.CourseImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a course model instance should use the {@link Course} interface instead.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see Course
 * @see org.gnenc.internet.mycourses.model.impl.CourseImpl
 * @see org.gnenc.internet.mycourses.model.impl.CourseModelImpl
 * @generated
 */
public interface CourseModel extends BaseModel<Course> {
	/**
	 * Gets the primary key of this course.
	 *
	 * @return the primary key of this course
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this course
	 *
	 * @param pk the primary key of this course
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the id of this course.
	 *
	 * @return the id of this course
	 */
	public long getId();

	/**
	 * Sets the id of this course.
	 *
	 * @param id the id of this course
	 */
	public void setId(long id);

	/**
	 * Gets the course id of this course.
	 *
	 * @return the course id of this course
	 */
	public long getCourseId();

	/**
	 * Sets the course id of this course.
	 *
	 * @param courseId the course id of this course
	 */
	public void setCourseId(long courseId);

	/**
	 * Gets the name of this course.
	 *
	 * @return the name of this course
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this course.
	 *
	 * @param name the name of this course
	 */
	public void setName(String name);

	/**
	 * Gets the site id of this course.
	 *
	 * @return the site id of this course
	 */
	public long getSiteId();

	/**
	 * Sets the site id of this course.
	 *
	 * @param siteId the site id of this course
	 */
	public void setSiteId(long siteId);

	/**
	 * Gets a copy of this course as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Course toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Course course);

	public int hashCode();

	public String toString();

	public String toXmlString();
}