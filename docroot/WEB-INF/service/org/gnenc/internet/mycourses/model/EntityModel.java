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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Entity service. Represents a row in the &quot;MC_Entity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.gnenc.internet.mycourses.model.impl.EntityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.gnenc.internet.mycourses.model.impl.EntityImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a entity model instance should use the {@link Entity} interface instead.
 * </p>
 *
 * @author Drew Blessing/Stephen Hunter
 * @see Entity
 * @see org.gnenc.internet.mycourses.model.impl.EntityImpl
 * @see org.gnenc.internet.mycourses.model.impl.EntityModelImpl
 * @generated
 */
public interface EntityModel extends BaseModel<Entity> {
	/**
	 * Gets the primary key of this entity.
	 *
	 * @return the primary key of this entity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this entity
	 *
	 * @param pk the primary key of this entity
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the entity id of this entity.
	 *
	 * @return the entity id of this entity
	 */
	public long getEntityId();

	/**
	 * Sets the entity id of this entity.
	 *
	 * @param entityId the entity id of this entity
	 */
	public void setEntityId(long entityId);

	/**
	 * Gets the entity name of this entity.
	 *
	 * @return the entity name of this entity
	 */
	@AutoEscape
	public String getEntityName();

	/**
	 * Sets the entity name of this entity.
	 *
	 * @param entityName the entity name of this entity
	 */
	public void setEntityName(String entityName);

	/**
	 * Gets the url of this entity.
	 *
	 * @return the url of this entity
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this entity.
	 *
	 * @param url the url of this entity
	 */
	public void setUrl(String url);

	/**
	 * Gets the email domains of this entity.
	 *
	 * @return the email domains of this entity
	 */
	@AutoEscape
	public String getEmailDomains();

	/**
	 * Sets the email domains of this entity.
	 *
	 * @param emailDomains the email domains of this entity
	 */
	public void setEmailDomains(String emailDomains);

	/**
	 * Gets the db name of this entity.
	 *
	 * @return the db name of this entity
	 */
	@AutoEscape
	public String getDbName();

	/**
	 * Sets the db name of this entity.
	 *
	 * @param dbName the db name of this entity
	 */
	public void setDbName(String dbName);

	/**
	 * Gets a copy of this entity as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Entity toEscapedModel();

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

	public int compareTo(Entity entity);

	public int hashCode();

	public String toString();

	public String toXmlString();
}