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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the UserEnrollment service. Represents a row in the &quot;MC_UserEnrollment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gnenc.internet.mycourses.model.impl.UserEnrollmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a user enrollment model instance should use the {@link UserEnrollment} interface instead.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see UserEnrollment
 * @see org.gnenc.internet.mycourses.model.impl.UserEnrollmentImpl
 * @see org.gnenc.internet.mycourses.model.impl.UserEnrollmentModelImpl
 * @generated
 */
public interface UserEnrollmentModel extends BaseModel<UserEnrollment> {
	/**
	 * Gets the primary key of this user enrollment.
	 *
	 * @return the primary key of this user enrollment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user enrollment
	 *
	 * @param pk the primary key of this user enrollment
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the id of this user enrollment.
	 *
	 * @return the id of this user enrollment
	 */
	public long getId();

	/**
	 * Sets the id of this user enrollment.
	 *
	 * @param Id the id of this user enrollment
	 */
	public void setId(long Id);

	/**
	 * Gets the user id of this user enrollment.
	 *
	 * @return the user id of this user enrollment
	 */
	public long getUserId();

	/**
	 * Sets the user id of this user enrollment.
	 *
	 * @param userId the user id of this user enrollment
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this user enrollment.
	 *
	 * @return the user uuid of this user enrollment
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this user enrollment.
	 *
	 * @param userUuid the user uuid of this user enrollment
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the last refresh of this user enrollment.
	 *
	 * @return the last refresh of this user enrollment
	 */
	public Date getLastRefresh();

	/**
	 * Sets the last refresh of this user enrollment.
	 *
	 * @param lastRefresh the last refresh of this user enrollment
	 */
	public void setLastRefresh(Date lastRefresh);

	/**
	 * Gets a copy of this user enrollment as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public UserEnrollment toEscapedModel();

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

	public int compareTo(UserEnrollment userEnrollment);

	public int hashCode();

	public String toString();

	public String toXmlString();
}