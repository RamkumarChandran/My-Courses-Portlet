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
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.gnenc.internet.mycourses.model.Host;
import org.gnenc.internet.mycourses.model.HostModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the Host service. Represents a row in the &quot;MC_Host&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gnenc.internet.mycourses.model.HostModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HostImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a host model instance should use the {@link org.gnenc.internet.mycourses.model.Host} interface instead.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see HostImpl
 * @see org.gnenc.internet.mycourses.model.Host
 * @see org.gnenc.internet.mycourses.model.HostModel
 * @generated
 */
public class HostModelImpl extends BaseModelImpl<Host> implements HostModel {
	public static final String TABLE_NAME = "MC_Host";
	public static final Object[][] TABLE_COLUMNS = {
			{ "hostId", new Integer(Types.BIGINT) },
			{ "siteId", new Integer(Types.BIGINT) },
			{ "remoteSiteId", new Integer(Types.BIGINT) },
			{ "peerId", new Integer(Types.BIGINT) }
		};
	public static final String TABLE_SQL_CREATE = "create table MC_Host (hostId LONG not null primary key,siteId LONG,remoteSiteId LONG,peerId LONG)";
	public static final String TABLE_SQL_DROP = "drop table MC_Host";
	public static final String ORDER_BY_JPQL = " ORDER BY host.hostId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MC_Host.hostId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gnenc.internet.mycourses.model.Host"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gnenc.internet.mycourses.model.Host"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gnenc.internet.mycourses.model.Host"));

	public HostModelImpl() {
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
			return (Host)this;
		}
		else {
			return (Host)Proxy.newProxyInstance(Host.class.getClassLoader(),
				new Class[] { Host.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					Host.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		HostImpl hostImpl = new HostImpl();

		hostImpl.setHostId(getHostId());

		hostImpl.setSiteId(getSiteId());

		hostImpl.setRemoteSiteId(getRemoteSiteId());

		hostImpl.setPeerId(getPeerId());

		return hostImpl;
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

		Host host = null;

		try {
			host = (Host)obj;
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
	private transient ExpandoBridge _expandoBridge;
}