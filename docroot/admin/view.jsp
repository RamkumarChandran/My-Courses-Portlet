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
<%--<jsp:useBean id="addSite" type="org.gnenc.internet.mycourses.model.Site" scope="request" /> --%>

<%
Site addSite = (Site)request.getAttribute("addSite");
if (addSite == null) {
	addSite = new SiteImpl();

}
%>

<liferay-ui:success key="siteSaved" message="site-saved-successfully" />
<liferay-ui:success key="siteDeleted" message="siteDeleted" />
<liferay-ui:success key="siteUpdated" message="siteUpdated" />
<liferay-ui:error key="error-deleting" message="error-deleting" />
<liferay-ui:error key="error-updating" message="error-updating" />
<liferay-ui:error key="error-db-connect" message="error-db-connect" />


<div id="mycoursesadmin">
	<div>
		<img id='schoolhouse' src='<%=renderRequest.getContextPath() %>/images/schoolhouse-med.png' alt='schoolhouse' />
		<p id="headline_main">Manage Site Connections</p>
		<span id="tip">
			<aui:a href="javascript:void();" cssClass="help aui-icon aui-icon-help" />
		</span>
	</div>

	<div id="addSiteForm">

		<portlet:actionURL name="addSite" var="addSiteURL" />

		<aui:form name="form" action="<%=addSiteURL.toString() %>" method="post">
			<aui:fieldset>
				<table class="form">
					<tr><td>
						<aui:input name="siteName" size="60"
							value="<%=addSite.getSiteName() %>" />
					</td>
					<td>
						<liferay-ui:error
        				key="site-name-required"
        				message="site-name-required" />
        			</td></tr>
        			<tr><td>
						<aui:input name="siteUrl" size="60"
							value="<%=addSite.getUrl() %>" />
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
							value="<%=addSite.getEmailDomain() %>" />
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
							value="<%=addSite.getDbServer() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-server-required"
        				message="site-db-server-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="siteDbName" size="60"
							value="<%=addSite.getDbName() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-name-required"
        				message="site-db-name-required"  />
					</td></tr>
        			<tr><td>
						<aui:input name="siteDbUser" size="60"
							value="<%=addSite.getDbUser() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-user-required"
        				message="site-db-user-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="siteDbPass" size="60" type="password"
							value="<%=addSite.getDbPass() %>" />
					</td><td>
						<liferay-ui:error
        				key="site-db-pass-required"
        				message="site-db-pass-required" />
					</td></tr>
        			<tr><td>
				</table>
				<aui:button-row>
					<aui:button type="submit" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>
	</div>

	<liferay-ui:search-container emptyResultsMessage="there-are-no-entities" delta="5">
    	<liferay-ui:search-container-results>
    	<%
		    List<Site> tempResults = MyCoursesAdminPortlet.getSites(renderRequest);

		    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
		    total = tempResults.size();

		    pageContext.setAttribute("results", results);
		    pageContext.setAttribute("total", total);
	    %>
    	</liferay-ui:search-container-results>

    	<liferay-ui:search-container-row
    		className="org.gnenc.internet.mycourses.model.Site"
    		keyProperty="siteId"
    		modelVar="site">

		    <liferay-ui:search-container-column-text
		        name="site-name"
		        property="siteName"
		        />

		    <liferay-ui:search-container-column-text
		        name="site-url"
		        property="url"
		        />

		    <liferay-ui:search-container-column-text
		        name="site-db-server"
		        property="dbServer"
		        />

		    <liferay-ui:search-container-column-text
		        name="site-db-name"
		        property="dbName"
		        />

			<liferay-ui:search-container-column-jsp
        		path="/admin/admin_actions.jsp"
        		align="right"
	        />

	      </liferay-ui:search-container-row>

	      <liferay-ui:search-iterator />

	</liferay-ui:search-container>
</div>