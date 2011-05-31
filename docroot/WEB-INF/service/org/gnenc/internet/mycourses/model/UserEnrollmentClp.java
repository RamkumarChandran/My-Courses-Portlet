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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Drew Blessing/Stephen Hunter
 */
public class UserEnrollmentClp extends BaseModelImpl<UserEnrollment>
	implements UserEnrollment {
	public UserEnrollmentClp() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getCourseId() {
		return _courseId;
	}

	public void setCourseId(long courseId) {
		_courseId = courseId;
	}

	public Date getLastRefresh() {
		return _lastRefresh;
	}

	public void setLastRefresh(Date lastRefresh) {
		_lastRefresh = lastRefresh;
	}

	public UserEnrollment toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (UserEnrollment)Proxy.newProxyInstance(UserEnrollment.class.getClassLoader(),
				new Class[] { UserEnrollment.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		UserEnrollmentClp clone = new UserEnrollmentClp();

		clone.setId(getId());
		clone.setUserId(getUserId());
		clone.setCourseId(getCourseId());
		clone.setLastRefresh(getLastRefresh());

		return clone;
	}

	public int compareTo(UserEnrollment userEnrollment) {
		int value = 0;

		if (getUserId() < userEnrollment.getUserId()) {
			value = -1;
		}
		else if (getUserId() > userEnrollment.getUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserEnrollmentClp userEnrollment = null;

		try {
			userEnrollment = (UserEnrollmentClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = userEnrollment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", courseId=");
		sb.append(getCourseId());
		sb.append(", lastRefresh=");
		sb.append(getLastRefresh());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.gnenc.internet.mycourses.model.UserEnrollment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseId</column-name><column-value><![CDATA[");
		sb.append(getCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastRefresh</column-name><column-value><![CDATA[");
		sb.append(getLastRefresh());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _userId;
	private String _userUuid;
	private long _courseId;
	private Date _lastRefresh;
}