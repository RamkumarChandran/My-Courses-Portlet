/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
public class EntityClp extends BaseModelImpl<Entity> implements Entity {
	public EntityClp() {
	}

	public long getPrimaryKey() {
		return _entityId;
	}

	public void setPrimaryKey(long pk) {
		setEntityId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entityId);
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public String getEntityName() {
		return _entityName;
	}

	public void setEntityName(String entityName) {
		_entityName = entityName;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getEmailDomains() {
		return _emailDomains;
	}

	public void setEmailDomains(String emailDomains) {
		_emailDomains = emailDomains;
	}

	public String getDbName() {
		return _dbName;
	}

	public void setDbName(String dbName) {
		_dbName = dbName;
	}

	public Entity toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Entity)Proxy.newProxyInstance(Entity.class.getClassLoader(),
				new Class[] { Entity.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		EntityClp clone = new EntityClp();

		clone.setEntityId(getEntityId());
		clone.setEntityName(getEntityName());
		clone.setUrl(getUrl());
		clone.setEmailDomains(getEmailDomains());
		clone.setDbName(getDbName());

		return clone;
	}

	public int compareTo(Entity entity) {
		int value = 0;

		value = getEntityName().toLowerCase()
					.compareTo(entity.getEntityName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		EntityClp entity = null;

		try {
			entity = (EntityClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = entity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{entityId=");
		sb.append(getEntityId());
		sb.append(", entityName=");
		sb.append(getEntityName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", emailDomains=");
		sb.append(getEmailDomains());
		sb.append(", dbName=");
		sb.append(getDbName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.gnenc.internet.mycourses.model.Entity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityName</column-name><column-value><![CDATA[");
		sb.append(getEntityName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailDomains</column-name><column-value><![CDATA[");
		sb.append(getEmailDomains());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dbName</column-name><column-value><![CDATA[");
		sb.append(getDbName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entityId;
	private String _entityName;
	private String _url;
	private String _emailDomains;
	private String _dbName;
}