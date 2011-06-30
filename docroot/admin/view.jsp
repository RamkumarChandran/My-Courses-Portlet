<%
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
%>
  
<%@include file="/init.jsp" %>

<liferay-ui:success key="entitySaved" message="entity-saved-successfully" />
<liferay-ui:success key="entityDeleted" message="entityDeleted" />
<liferay-ui:success key="entityUpdated" message="entityUpdated" />
<liferay-ui:error key="error-deleting" message="error-deleting" />
<liferay-ui:error key="error-updating" message="error-updating" />

<div id="mycoursesadmin">
	<div>
		<img id='schoolhouse' src='<%=renderRequest.getContextPath() %>/images/schoolhouse-med.png' alt='schoolhouse' />
		<p id="headline_main">Manage Entities</p>
	</div>
	
	<div id="addEntityForm">
			
		<portlet:actionURL name="addEntity" var="addEntityURL" />
	
		<aui:form name="form" action="<%=addEntityURL.toString() %>" method="post">
			<aui:fieldset>
				<table class="form"> 
					<tr><td>
						<aui:input name="entityName" size="60" />
					</td>
					<td>
						<liferay-ui:error
        				key="entity-name-required"
        				message="entity-name-required" />
        			</td></tr>
        			<tr><td>
						<aui:input name="entityUrl" size="60" />
					</td><td>
						<liferay-ui:error
        				key="entity-url-required"
        				message="entity-url-required" />
        			</td></tr>
        			<tr><td>
						<aui:input name="entityDbServer" size="60" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-server-required"
        				message="entity-db-server-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbName" size="60" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-name-required"
        				message="entity-db-name-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbUser" size="60" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-user-required"
        				message="entity-db-user-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbPass" size="60" type="password" />
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
		        
	      </liferay-ui:search-container-row>
	
	      <liferay-ui:search-iterator />
	
	</liferay-ui:search-container>
</div>