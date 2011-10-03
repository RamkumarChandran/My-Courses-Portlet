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
 * This class is a wrapper for {@link Site}.
 * </p>
 *
 * @author    Drew Blessing/Stephen Hunter
 * @see       Site
 * @generated
 */
public class SiteWrapper implements Site {
	public SiteWrapper(Site site) {
		_site = site;
	}

	public long getPrimaryKey() {
		return _site.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_site.setPrimaryKey(pk);
	}

	public long getSiteId() {
		return _site.getSiteId();
	}

	public void setSiteId(long siteId) {
		_site.setSiteId(siteId);
	}

	public java.lang.String getSiteName() {
		return _site.getSiteName();
	}

	public void setSiteName(java.lang.String siteName) {
		_site.setSiteName(siteName);
	}

	public java.lang.String getUrl() {
		return _site.getUrl();
	}

	public void setUrl(java.lang.String url) {
		_site.setUrl(url);
	}

	public java.lang.String getEmailDomain() {
		return _site.getEmailDomain();
	}

	public void setEmailDomain(java.lang.String emailDomain) {
		_site.setEmailDomain(emailDomain);
	}

	public java.lang.String getDbServer() {
		return _site.getDbServer();
	}

	public void setDbServer(java.lang.String dbServer) {
		_site.setDbServer(dbServer);
	}

	public java.lang.String getDbName() {
		return _site.getDbName();
	}

	public void setDbName(java.lang.String dbName) {
		_site.setDbName(dbName);
	}

	public java.lang.String getDbUser() {
		return _site.getDbUser();
	}

	public void setDbUser(java.lang.String dbUser) {
		_site.setDbUser(dbUser);
	}

	public java.lang.String getDbPass() {
		return _site.getDbPass();
	}

	public void setDbPass(java.lang.String dbPass) {
		_site.setDbPass(dbPass);
	}

	public long getCompanyId() {
		return _site.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_site.setCompanyId(companyId);
	}

	public Site toEscapedModel() {
		return _site.toEscapedModel();
	}

	public boolean isNew() {
		return _site.isNew();
	}

	public void setNew(boolean n) {
		_site.setNew(n);
	}

	public boolean isCachedModel() {
		return _site.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_site.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _site.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_site.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _site.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _site.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_site.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _site.clone();
	}

	public int compareTo(Site site) {
		return _site.compareTo(site);
	}

	public int hashCode() {
		return _site.hashCode();
	}

	public java.lang.String toString() {
		return _site.toString();
	}

	public java.lang.String toXmlString() {
		return _site.toXmlString();
	}

	public Site getWrappedSite() {
		return _site;
	}

	private Site _site;
}