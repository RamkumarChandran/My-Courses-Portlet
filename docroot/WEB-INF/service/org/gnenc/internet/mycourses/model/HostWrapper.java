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
 * This class is a wrapper for {@link Host}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       Host
 * @generated
 */
public class HostWrapper implements Host {
	public HostWrapper(Host host) {
		_host = host;
	}

	public long getPrimaryKey() {
		return _host.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_host.setPrimaryKey(pk);
	}

	public long getHostId() {
		return _host.getHostId();
	}

	public void setHostId(long hostId) {
		_host.setHostId(hostId);
	}

	public long getEntityId() {
		return _host.getEntityId();
	}

	public void setEntityId(long entityId) {
		_host.setEntityId(entityId);
	}

	public long getRemoteEntityId() {
		return _host.getRemoteEntityId();
	}

	public void setRemoteEntityId(long remoteEntityId) {
		_host.setRemoteEntityId(remoteEntityId);
	}

	public long getPeerId() {
		return _host.getPeerId();
	}

	public void setPeerId(long peerId) {
		_host.setPeerId(peerId);
	}

	public org.gnenc.internet.mycourses.model.Host toEscapedModel() {
		return _host.toEscapedModel();
	}

	public boolean isNew() {
		return _host.isNew();
	}

	public void setNew(boolean n) {
		_host.setNew(n);
	}

	public boolean isCachedModel() {
		return _host.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_host.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _host.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_host.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _host.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _host.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_host.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _host.clone();
	}

	public int compareTo(org.gnenc.internet.mycourses.model.Host host) {
		return _host.compareTo(host);
	}

	public int hashCode() {
		return _host.hashCode();
	}

	public java.lang.String toString() {
		return _host.toString();
	}

	public java.lang.String toXmlString() {
		return _host.toXmlString();
	}

	public Host getWrappedHost() {
		return _host;
	}

	private Host _host;
}