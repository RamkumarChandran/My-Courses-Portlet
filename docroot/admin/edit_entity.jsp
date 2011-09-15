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
<%--<jsp:useBean id="entity" type="org.gnenc.internet.mycourses.model.Entity" scope="request" /> --%>

<%
Entity entity = (Entity)request.getAttribute("entity");
%>

<liferay-ui:error key="error-db-connect" message="error-db-connect" />

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/admin/view.jsp" /></portlet:renderURL>

<portlet:actionURL name="updateEntity" var="updateEntityURL" />

<h2>Edit Entity</h2>

<aui:form name="form" action="<%=updateEntityURL.toString() %>" method="post">
			<aui:fieldset>
				<aui:input name="resourcePrimKey" value="<%=entity.getEntityId() %>" type="hidden" />
				<table class="form">
					<tr><td>
						<aui:input name="entityName" size="60"
							value="<%=entity.getEntityName() %>" />
					</td>
					<td>
						<liferay-ui:error
        				key="entity-name-required"
        				message="entity-name-required" />
        			</td></tr>
        			<tr><td>
						<aui:input name="entityUrl" size="60"
							value="<%=entity.getUrl() %>" />
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
							value="<%=entity.getEmailDomains() %>" />
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
							value="<%=entity.getDbServer() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-server-required"
        				message="entity-db-server-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbName" size="60"
							value="<%=entity.getDbName() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-name-required"
        				message="entity-db-name-required"  />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbUser" size="60"
							value="<%=entity.getDbUser() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-user-required"
        				message="entity-db-user-required" />
					</td></tr>
        			<tr><td>
						<aui:input name="entityDbPass" size="60" type="password"
							value="<%=entity.getDbPass() %>" />
					</td><td>
						<liferay-ui:error
        				key="entity-db-pass-required"
        				message="entity-db-pass-required" />
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