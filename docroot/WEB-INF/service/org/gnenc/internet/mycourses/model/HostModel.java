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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Host service. Represents a row in the &quot;MC_Host&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gnenc.internet.mycourses.model.impl.HostModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gnenc.internet.mycourses.model.impl.HostImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a host model instance should use the {@link Host} interface instead.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see Host
 * @see org.gnenc.internet.mycourses.model.impl.HostImpl
 * @see org.gnenc.internet.mycourses.model.impl.HostModelImpl
 * @generated
 */
public interface HostModel extends BaseModel<Host> {
	/**
	 * Gets the primary key of this host.
	 *
	 * @return the primary key of this host
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this host
	 *
	 * @param pk the primary key of this host
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the host id of this host.
	 *
	 * @return the host id of this host
	 */
	public long getHostId();

	/**
	 * Sets the host id of this host.
	 *
	 * @param hostId the host id of this host
	 */
	public void setHostId(long hostId);

	/**
	 * Gets the entity id of this host.
	 *
	 * @return the entity id of this host
	 */
	public long getEntityId();

	/**
	 * Sets the entity id of this host.
	 *
	 * @param entityId the entity id of this host
	 */
	public void setEntityId(long entityId);

	/**
	 * Gets the remote entity id of this host.
	 *
	 * @return the remote entity id of this host
	 */
	public long getRemoteEntityId();

	/**
	 * Sets the remote entity id of this host.
	 *
	 * @param remoteEntityId the remote entity id of this host
	 */
	public void setRemoteEntityId(long remoteEntityId);

	/**
	 * Gets the peer id of this host.
	 *
	 * @return the peer id of this host
	 */
	public long getPeerId();

	/**
	 * Sets the peer id of this host.
	 *
	 * @param peerId the peer id of this host
	 */
	public void setPeerId(long peerId);

	/**
	 * Gets a copy of this host as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Host toEscapedModel();

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

	public int compareTo(Host host);

	public int hashCode();

	public String toString();

	public String toXmlString();
}