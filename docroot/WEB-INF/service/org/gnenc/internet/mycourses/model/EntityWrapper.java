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

/**
 * <p>
 * This class is a wrapper for {@link Entity}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       Entity
 * @generated
 */
public class EntityWrapper implements Entity {
	public EntityWrapper(Entity entity) {
		_entity = entity;
	}

	public long getPrimaryKey() {
		return _entity.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_entity.setPrimaryKey(pk);
	}

	public long getEntityId() {
		return _entity.getEntityId();
	}

	public void setEntityId(long entityId) {
		_entity.setEntityId(entityId);
	}

	public java.lang.String getEntityName() {
		return _entity.getEntityName();
	}

	public void setEntityName(java.lang.String entityName) {
		_entity.setEntityName(entityName);
	}

	public java.lang.String getUrl() {
		return _entity.getUrl();
	}

	public void setUrl(java.lang.String url) {
		_entity.setUrl(url);
	}

	public java.lang.String getEmailDomains() {
		return _entity.getEmailDomains();
	}

	public void setEmailDomains(java.lang.String emailDomains) {
		_entity.setEmailDomains(emailDomains);
	}

	public java.lang.String getDbName() {
		return _entity.getDbName();
	}

	public void setDbName(java.lang.String dbName) {
		_entity.setDbName(dbName);
	}

	public Entity toEscapedModel() {
		return _entity.toEscapedModel();
	}

	public boolean isNew() {
		return _entity.isNew();
	}

	public void setNew(boolean n) {
		_entity.setNew(n);
	}

	public boolean isCachedModel() {
		return _entity.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_entity.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _entity.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_entity.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _entity.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _entity.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_entity.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _entity.clone();
	}

	public int compareTo(Entity entity) {
		return _entity.compareTo(entity);
	}

	public int hashCode() {
		return _entity.hashCode();
	}

	public java.lang.String toString() {
		return _entity.toString();
	}

	public java.lang.String toXmlString() {
		return _entity.toXmlString();
	}

	public Entity getWrappedEntity() {
		return _entity;
	}

	private Entity _entity;
}