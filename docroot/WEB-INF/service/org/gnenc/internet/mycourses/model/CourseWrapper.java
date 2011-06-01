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

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       Course
 * @generated
 */
public class CourseWrapper implements Course {
	public CourseWrapper(Course course) {
		_course = course;
	}

	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_course.setPrimaryKey(pk);
	}

	public long getId() {
		return _course.getId();
	}

	public void setId(long id) {
		_course.setId(id);
	}

	public long getCourseId() {
		return _course.getCourseId();
	}

	public void setCourseId(long courseId) {
		_course.setCourseId(courseId);
	}

	public java.lang.String getName() {
		return _course.getName();
	}

	public void setName(java.lang.String name) {
		_course.setName(name);
	}

	public long getEntityId() {
		return _course.getEntityId();
	}

	public void setEntityId(long entityId) {
		_course.setEntityId(entityId);
	}

	public long getLastRefresh() {
		return _course.getLastRefresh();
	}

	public void setLastRefresh(long lastRefresh) {
		_course.setLastRefresh(lastRefresh);
	}

	public org.gnenc.internet.mycourses.model.Course toEscapedModel() {
		return _course.toEscapedModel();
	}

	public boolean isNew() {
		return _course.isNew();
	}

	public void setNew(boolean n) {
		_course.setNew(n);
	}

	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_course.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _course.clone();
	}

	public int compareTo(org.gnenc.internet.mycourses.model.Course course) {
		return _course.compareTo(course);
	}

	public int hashCode() {
		return _course.hashCode();
	}

	public java.lang.String toString() {
		return _course.toString();
	}

	public java.lang.String toXmlString() {
		return _course.toXmlString();
	}

	public Course getWrappedCourse() {
		return _course;
	}

	private Course _course;
}