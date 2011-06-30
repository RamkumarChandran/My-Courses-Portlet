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

import org.gnenc.internet.mycourses.model.Entity;
import org.gnenc.internet.mycourses.model.EntityModel;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

/**
 * The base model implementation for the Entity service. Represents a row in the &quot;MC_Entity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.gnenc.internet.mycourses.model.EntityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EntityImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. All methods that expect a entity model instance should use the {@link org.gnenc.internet.mycourses.model.Entity} interface instead.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see EntityImpl
 * @see org.gnenc.internet.mycourses.model.Entity
 * @see org.gnenc.internet.mycourses.model.EntityModel
 * @generated
 */
public class EntityModelImpl extends BaseModelImpl<Entity>
	implements EntityModel {
	public static final String TABLE_NAME = "MC_Entity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "entityId", new Integer(Types.BIGINT) },
			{ "entityName", new Integer(Types.VARCHAR) },
			{ "url", new Integer(Types.VARCHAR) },
			{ "emailDomains", new Integer(Types.VARCHAR) },
			{ "dbServer", new Integer(Types.VARCHAR) },
			{ "dbName", new Integer(Types.VARCHAR) },
			{ "dbUser", new Integer(Types.VARCHAR) },
			{ "dbPass", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table MC_Entity (entityId LONG not null primary key,entityName VARCHAR(75) null,url VARCHAR(75) null,emailDomains VARCHAR(75) null,dbServer VARCHAR(75) null,dbName VARCHAR(75) null,dbUser VARCHAR(75) null,dbPass VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table MC_Entity";
	public static final String ORDER_BY_JPQL = " ORDER BY entity.entityName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MC_Entity.entityName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.gnenc.internet.mycourses.model.Entity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.gnenc.internet.mycourses.model.Entity"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.gnenc.internet.mycourses.model.Entity"));

	public EntityModelImpl() {
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
		if (_entityName == null) {
			return StringPool.BLANK;
		}
		else {
			return _entityName;
		}
	}

	public void setEntityName(String entityName) {
		_entityName = entityName;
	}

	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getEmailDomains() {
		if (_emailDomains == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailDomains;
		}
	}

	public void setEmailDomains(String emailDomains) {
		_emailDomains = emailDomains;
	}

	public String getDbServer() {
		if (_dbServer == null) {
			return StringPool.BLANK;
		}
		else {
			return _dbServer;
		}
	}

	public void setDbServer(String dbServer) {
		_dbServer = dbServer;
	}

	public String getDbName() {
		if (_dbName == null) {
			return StringPool.BLANK;
		}
		else {
			return _dbName;
		}
	}

	public void setDbName(String dbName) {
		_dbName = dbName;
	}

	public String getDbUser() {
		if (_dbUser == null) {
			return StringPool.BLANK;
		}
		else {
			return _dbUser;
		}
	}

	public void setDbUser(String dbUser) {
		_dbUser = dbUser;
	}

	public String getDbPass() {
		if (_dbPass == null) {
			return StringPool.BLANK;
		}
		else {
			return _dbPass;
		}
	}

	public void setDbPass(String dbPass) {
		_dbPass = dbPass;
	}

	public Entity toEscapedModel() {
		if (isEscapedModel()) {
			return (Entity)this;
		}
		else {
			return (Entity)Proxy.newProxyInstance(Entity.class.getClassLoader(),
				new Class[] { Entity.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					Entity.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	public Object clone() {
		EntityImpl entityImpl = new EntityImpl();

		entityImpl.setEntityId(getEntityId());

		entityImpl.setEntityName(getEntityName());

		entityImpl.setUrl(getUrl());

		entityImpl.setEmailDomains(getEmailDomains());

		entityImpl.setDbServer(getDbServer());

		entityImpl.setDbName(getDbName());

		entityImpl.setDbUser(getDbUser());

		entityImpl.setDbPass(getDbPass());

		return entityImpl;
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

		Entity entity = null;

		try {
			entity = (Entity)obj;
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
		StringBundler sb = new StringBundler(17);

		sb.append("{entityId=");
		sb.append(getEntityId());
		sb.append(", entityName=");
		sb.append(getEntityName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", emailDomains=");
		sb.append(getEmailDomains());
		sb.append(", dbServer=");
		sb.append(getDbServer());
		sb.append(", dbName=");
		sb.append(getDbName());
		sb.append(", dbUser=");
		sb.append(getDbUser());
		sb.append(", dbPass=");
		sb.append(getDbPass());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

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
			"<column><column-name>dbServer</column-name><column-value><![CDATA[");
		sb.append(getDbServer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dbName</column-name><column-value><![CDATA[");
		sb.append(getDbName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dbUser</column-name><column-value><![CDATA[");
		sb.append(getDbUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dbPass</column-name><column-value><![CDATA[");
		sb.append(getDbPass());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _entityId;
	private String _entityName;
	private String _url;
	private String _emailDomains;
	private String _dbServer;
	private String _dbName;
	private String _dbUser;
	private String _dbPass;
	private transient ExpandoBridge _expandoBridge;
}