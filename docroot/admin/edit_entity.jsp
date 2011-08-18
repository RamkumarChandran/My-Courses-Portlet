<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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