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
public class SiteClp extends BaseModelImpl<Site> implements Site {
	public SiteClp() {
	}

	public long getPrimaryKey() {
		return _siteId;
	}

	public void setPrimaryKey(long pk) {
		setSiteId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_siteId);
	}

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_siteId = siteId;
	}

	public String getSiteName() {
		return _siteName;
	}

	public void setSiteName(String siteName) {
		_siteName = siteName;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getEmailDomain() {
		return _emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		_emailDomain = emailDomain;
	}

	public String getDbServer() {
		return _dbServer;
	}

	public void setDbServer(String dbServer) {
		_dbServer = dbServer;
	}

	public String getDbName() {
		return _dbName;
	}

	public void setDbName(String dbName) {
		_dbName = dbName;
	}

	public String getDbUser() {
		return _dbUser;
	}

	public void setDbUser(String dbUser) {
		_dbUser = dbUser;
	}

	public String getDbPass() {
		return _dbPass;
	}

	public void setDbPass(String dbPass) {
		_dbPass = dbPass;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Site toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Site)Proxy.newProxyInstance(Site.class.getClassLoader(),
				new Class[] { Site.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		SiteClp clone = new SiteClp();

		clone.setSiteId(getSiteId());
		clone.setSiteName(getSiteName());
		clone.setUrl(getUrl());
		clone.setEmailDomain(getEmailDomain());
		clone.setDbServer(getDbServer());
		clone.setDbName(getDbName());
		clone.setDbUser(getDbUser());
		clone.setDbPass(getDbPass());
		clone.setCompanyId(getCompanyId());

		return clone;
	}

	public int compareTo(Site site) {
		int value = 0;

		value = getSiteName().toLowerCase()
					.compareTo(site.getSiteName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SiteClp site = null;

		try {
			site = (SiteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = site.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{siteId=");
		sb.append(getSiteId());
		sb.append(", siteName=");
		sb.append(getSiteName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", emailDomain=");
		sb.append(getEmailDomain());
		sb.append(", dbServer=");
		sb.append(getDbServer());
		sb.append(", dbName=");
		sb.append(getDbName());
		sb.append(", dbUser=");
		sb.append(getDbUser());
		sb.append(", dbPass=");
		sb.append(getDbPass());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.gnenc.internet.mycourses.model.Site");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>siteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteName</column-name><column-value><![CDATA[");
		sb.append(getSiteName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailDomain</column-name><column-value><![CDATA[");
		sb.append(getEmailDomain());
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
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _siteId;
	private String _siteName;
	private String _url;
	private String _emailDomain;
	private String _dbServer;
	private String _dbName;
	private String _dbUser;
	private String _dbPass;
	private long _companyId;
}