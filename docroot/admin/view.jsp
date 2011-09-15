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
<%--<jsp:useBean id="addEntity" type="org.gnenc.internet.mycourses.model.Entity" scope="request" /> --%>

<%
Entity addEntity = (Entity)request.getAttribute("addEntity");
if (addEntity == null) {
	addEntity = new EntityImpl();

}
%>

<liferay-ui:success key="entitySaved" message="entity-saved-successfully" />
<liferay-ui:success key="entityDeleted" message="entityDeleted" />
<liferay-ui:success key="entityUpdated" message="entityUpdated" />
<liferay-ui:error key="error-deleting" message="error-deleting" />
<liferay-ui:error key="error-updating" message="error-updating" />
<liferay-ui:error key="error-db-connect" message="error-db-connect" />


<div id="mycoursesadmin">
	<div>
		<img id='schoolhouse' src='<%=renderRequest.getContextPath() %>/images/schoolhouse-med.png' alt='schoolhouse' />
		<p id="headline_main">Manage School Entity Connections</p>
		<span id="tip">
			<aui:a href="javascript:void();" cssClass="help aui-icon aui-icon-help" />
		</span>
	</div>

	<div id="addEntityForm">

		<portlet:actionURL name="addEntity" var="addEntityURL" />

		<aui:form name="form" action="<%=addEntityURL.toString() %>" method="post">
			<aui:fieldset>
				<table class="form">
					<tr><td>
						<aui:input name="entityName" size="60"
							value="<%=addEntity.getEntityName() %>" />
					</td>
					<td>
						<liferay-ui:error
        				key="entity-name-required"
        				message="entity-name-required" />
        			</td></tr>
        			<tr><td>
						<aui:input name="entityUrl" size="60"
							value="<%=addEntity.getUrl() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-url-required"
        				message="entity-url-required" />
        				<liferay-ui:error
        				key="entity-invalid-url"
        				message="entity-invalid-url" />
        			</td></tr>
        			<tr><td>
						<aui:input name="entityEmailDomain" size="60"
							value="<%=addEntity.getEmailDomains() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-email-domain-required"
        				message="entity-email-domain-required" />
        				<liferay-ui:error
        				key="entity-invalid-email-domain"
        				message="entity-invalid-email-domain" />
        			</td></tr>
        			<tr><td>
						<aui:input name="entityDbServer" size="60"
							value="<%=addEntity.getDbServer() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-server-required"
        				message="entity-db-server-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbName" size="60"
							value="<%=addEntity.getDbName() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-name-required"
        				message="entity-db-name-required"  />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbUser" size="60"
							value="<%=addEntity.getDbUser() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-user-required"
        				message="entity-db-user-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbPass" size="60" type="password"
							value="<%=addEntity.getDbPass() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-pass-required"
        				message="entity-db-pass-required" />
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
		    List<Entity> tempResults = MyCoursesAdminPortlet.getEntities(renderRequest);

		    results = ListUtil.subList(tempResults, searchContainer.getStart(), searchContainer.getEnd());
		    total = tempResults.size();

		    pageContext.setAttribute("results", results);
		    pageContext.setAttribute("total", total);
	    %>
    	</liferay-ui:search-container-results>

    	<liferay-ui:search-container-row
    		className="org.gnenc.internet.mycourses.model.Entity"
    		keyProperty="entityId"
    		modelVar="entity">

		    <liferay-ui:search-container-column-text
		        name="entity-name"
		        property="entityName"
		        />

		    <liferay-ui:search-container-column-text
		        name="entity-url"
		        property="url"
		        />

		    <liferay-ui:search-container-column-text
		        name="entity-db-server"
		        property="dbServer"
		        />

		    <liferay-ui:search-container-column-text
		        name="entity-db-name"
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