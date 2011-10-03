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
public class HostClp extends BaseModelImpl<Host> implements Host {
	public HostClp() {
	}

	public long getPrimaryKey() {
		return _hostId;
	}

	public void setPrimaryKey(long pk) {
		setHostId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_hostId);
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_siteId = siteId;
	}

	public long getRemoteSiteId() {
		return _remoteSiteId;
	}

	public void setRemoteSiteId(long remoteSiteId) {
		_remoteSiteId = remoteSiteId;
	}

	public long getPeerId() {
		return _peerId;
	}

	public void setPeerId(long peerId) {
		_peerId = peerId;
	}

	public Host toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Host)Proxy.newProxyInstance(Host.class.getClassLoader(),
				new Class[] { Host.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		HostClp clone = new HostClp();

		clone.setHostId(getHostId());
		clone.setSiteId(getSiteId());
		clone.setRemoteSiteId(getRemoteSiteId());
		clone.setPeerId(getPeerId());

		return clone;
	}

	public int compareTo(Host host) {
		int value = 0;

		if (getHostId() < host.getHostId()) {
			value = -1;
		}
		else if (getHostId() > host.getHostId()) {
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

		HostClp host = null;

		try {
			host = (HostClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = host.getPrimaryKey();

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

		sb.append("{hostId=");
		sb.append(getHostId());
		sb.append(", siteId=");
		sb.append(getSiteId());
		sb.append(", remoteSiteId=");
		sb.append(getRemoteSiteId());
		sb.append(", peerId=");
		sb.append(getPeerId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.gnenc.internet.mycourses.model.Host");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteSiteId</column-name><column-value><![CDATA[");
		sb.append(getRemoteSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>peerId</column-name><column-value><![CDATA[");
		sb.append(getPeerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _hostId;
	private long _siteId;
	private long _remoteSiteId;
	private long _peerId;
}