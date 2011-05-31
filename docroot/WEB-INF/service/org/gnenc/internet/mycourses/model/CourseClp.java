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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Drew Blessing/Stephen Hunter
 */
public class CourseClp extends BaseModelImpl<Course> implements Course {
	public CourseClp() {
	}

	public long getPrimaryKey() {
		return _courseId;
	}

	public void setPrimaryKey(long pk) {
		setCourseId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_courseId);
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getLastRefresh() {
		return _lastRefresh;
	}

	public void setLastRefresh(long lastRefresh) {
		_lastRefresh = lastRefresh;
	}

	public Course toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Course)Proxy.newProxyInstance(Course.class.getClassLoader(),
				new Class[] { Course.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		CourseClp clone = new CourseClp();

		clone.setCourseId(getCourseId());
		clone.setName(getName());
		clone.setLastRefresh(getLastRefresh());

		return clone;
	}

	public int compareTo(Course course) {
		int value = 0;

		value = getName().toLowerCase().compareTo(course.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CourseClp course = null;

		try {
			course = (CourseClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = course.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{courseId=");
		sb.append(getCourseId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", lastRefresh=");
		sb.append(getLastRefresh());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.gnenc.internet.mycourses.model.Course");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastRefresh</column-name><column-value><![CDATA[");
		sb.append(getLastRefresh());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _courseId;
	private String _name;
	private long _lastRefresh;
}