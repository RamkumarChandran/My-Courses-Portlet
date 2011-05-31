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
 * This class is a wrapper for {@link UserEnrollment}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       UserEnrollment
 * @generated
 */
public class UserEnrollmentWrapper implements UserEnrollment {
	public UserEnrollmentWrapper(UserEnrollment userEnrollment) {
		_userEnrollment = userEnrollment;
	}

	public long getPrimaryKey() {
		return _userEnrollment.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_userEnrollment.setPrimaryKey(pk);
	}

	public long getId() {
		return _userEnrollment.getId();
	}

	public void setId(long Id) {
		_userEnrollment.setId(Id);
	}

	public long getUserId() {
		return _userEnrollment.getUserId();
	}

	public void setUserId(long userId) {
		_userEnrollment.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEnrollment.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_userEnrollment.setUserUuid(userUuid);
	}

	public java.util.Date getLastRefresh() {
		return _userEnrollment.getLastRefresh();
	}

	public void setLastRefresh(java.util.Date lastRefresh) {
		_userEnrollment.setLastRefresh(lastRefresh);
	}

	public UserEnrollment toEscapedModel() {
		return _userEnrollment.toEscapedModel();
	}

	public boolean isNew() {
		return _userEnrollment.isNew();
	}

	public void setNew(boolean n) {
		_userEnrollment.setNew(n);
	}

	public boolean isCachedModel() {
		return _userEnrollment.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userEnrollment.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userEnrollment.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_userEnrollment.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userEnrollment.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userEnrollment.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userEnrollment.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _userEnrollment.clone();
	}

	public int compareTo(UserEnrollment userEnrollment) {
		return _userEnrollment.compareTo(userEnrollment);
	}

	public int hashCode() {
		return _userEnrollment.hashCode();
	}

	public java.lang.String toString() {
		return _userEnrollment.toString();
	}

	public java.lang.String toXmlString() {
		return _userEnrollment.toXmlString();
	}

	public UserEnrollment getWrappedUserEnrollment() {
		return _userEnrollment;
	}

	private UserEnrollment _userEnrollment;
}