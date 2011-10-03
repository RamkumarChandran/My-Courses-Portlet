<%
/**
 *  Copyright (c) 2010-2011 Educational Service Unit 10. 
*
*  This file is part of the My Courses portlet.
*  
*  My Courses portlet is free software: you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
* 
*  My Courses is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with the My Courses portlet.  If not, see <http://www.gnu.org/licenses/>.
**/
%>

<%@include file="/init.jsp" %>
<%--<jsp:useBean id="site" type="org.gnenc.internet.mycourses.model.Site" scope="request" /> --%>

<%
Site site = (Site)request.getAttribute("site");
%>

<liferay-ui:error key="error-db-connect" message="error-db-connect" />

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/admin/view.jsp" /></portlet:renderURL>

<portlet:actionURL name="updateSite" var="updateSiteURL" />

<h2>Edit Site</h2>

<aui:form name="form" action="<%=updateSiteURL.toString() %>" method="post">
			<aui:fieldset>
				<aui:input name="resourcePrimKey" value="<%=site.getSiteId() %>" type="hidden" />
				<table class="form">
					<tr><td>
						<aui:input name="siteName" size="60"
							value="<%=site.getSiteName() %>" />
					</td>
					<td>
						<liferay-ui:error
        				key="site-name-required"
        				message="site-name-required" />
        			</td></tr>
        			<tr><td>
						<aui:input name="siteUrl" size="60"
							value="<%=site.getUrl() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-url-required"
        				message="site-url-required" />
        				<liferay-ui:error
        				key="site-invalid-url"
        				message="site-invalid-url" />
        			</td></tr>
        			<tr><td>
						<aui:input name="siteEmailDomain" size="60"
							value="<%=site.getEmailDomain() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-email-domain-required"
        				message="site-email-domain-required" />
        				<liferay-ui:error
        				key="site-invalid-email-domain"
        				message="site-invalid-email-domain" />
        			</td></tr>
        			<tr><td>
						<aui:input name="siteDbServer" size="60"
							value="<%=site.getDbServer() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-server-required"
        				message="site-db-server-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="siteDbName" size="60"
							value="<%=site.getDbName() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-name-required"
        				message="site-db-name-required"  />
					</td></tr>
        			<tr><td>
						<aui:input name="siteDbUser" size="60"
							value="<%=site.getDbUser() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-user-required"
        				message="site-db-user-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="siteDbPass" size="60" type="password"
							value="<%=site.getDbPass() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-pass-required"
        				message="site-db-pass-required" />
					</td></tr>
        			<tr><td>
				</table>
				<aui:button-row>
					<aui:button type="submit" />
					<aui:button
      					type="cancel"
        				value="Cancel"
        				onClick="<%=cancelURL %>"
    				/>
				</aui:button-row>
			</aui:fieldset>
		</aui:form>