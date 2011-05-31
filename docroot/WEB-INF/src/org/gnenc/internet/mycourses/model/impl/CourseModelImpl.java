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

package org.gnenc.internet.mycourses.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.gnenc.internet.mycourses.model.Course;
import org.gnenc.internet.mycourses.model.CourseModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the Course service. Represents a row in the &quot;MC_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gnenc.internet.mycourses.model.CourseModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a course model instance should use the {@link org.gnenc.internet.mycourses.model.Course} interface instead.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see CourseImpl
 * @see org.gnenc.internet.mycourses.model.Course
 * @see org.gnenc.internet.mycourses.model.CourseModel
 * @generated
 */
public class CourseModelImpl extends BaseModelImpl<Course>
	implements CourseModel {
	public static final String TABLE_NAME = "MC_Course";
	public static final Object[][] TABLE_COLUMNS = {
			{ "courseId", new Integer(Types.BIGINT) },
			{ "name", new Integer(Types.VARCHAR) },
			{ "lastRefresh", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table MC_Course (courseId LONG not null primary key,name VARCHAR(75) null,lastRefresh LONG)";
	public static final String TABLE_SQL_DROP = "drop table MC_Course";
	public static final String ORDER_BY_JPQL = " ORDER BY course.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MC_Course.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gnenc.internet.mycourses.model.Course"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gnenc.internet.mycourses.model.Course"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gnenc.internet.mycourses.model.Course"));

	public CourseModelImpl() {
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
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
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
			return (Course)this;
		}
		else {
			return (Course)Proxy.newProxyInstance(Course.class.getClassLoader(),
				new Class[] { Course.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					Course.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setCourseId(getCourseId());

		courseImpl.setName(getName());

		courseImpl.setLastRefresh(getLastRefresh());

		return courseImpl;
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

		Course course = null;

		try {
			course = (Course)obj;
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
	private transient ExpandoBridge _expandoBridge;
}