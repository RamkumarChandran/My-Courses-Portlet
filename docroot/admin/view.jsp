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

<div id="mycoursesadmin">
	<div>
		<img id='schoolhouse' src='<%=renderRequest.getContextPath() %>/images/schoolhouse-med.png' alt='schoolhouse' />
		<p id="headline_main">Manage Entities</p>
	</div>
	
	<div id="addEntityForm">
		<portlet:actionURL name="addEntity" var="addEntityURL" />
	
		<aui:form name="form" action="<%=addEntityURL.toString() %>" method="post">
			<aui:fieldset>
				<aui:input name="entityName" size="60" />
				<aui:input name="entityUrl" size="60" />
				<aui:input name="entityDbServer" size="60" />
				<aui:input name="entityDbName" size="60" />
				<aui:input name="entityDbUser" size="60" />
				<aui:input name="entityDbPass" size="60" type="password" />
				
				<aui:button-row>
					<aui:button type="submit" />
				</aui:button-row>
			</aui:fieldset>
		</aui:form>
	</div>
	
	<liferay-ui:search-container emptyResultsMessage="there-are-no-entities" delta="5">
    	<liferay-ui:search-container-results>
    	<!-- Insert entities here -->
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