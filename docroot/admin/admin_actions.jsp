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

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Site site = (Site)row.getObject();
//long groupId = themeDisplay.getLayout().getGroupId();
String name = Site.class.getName();
String primKey = String.valueOf(site.getPrimaryKey());
%>


<liferay-ui:icon-menu>

  <%--<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.UPDATE) %>"> --%>
    <portlet:actionURL name="editSite" var="editURL">
      <portlet:param name="resourcePrimKey" value="<%=primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
  <%--</c:if> --%>

  <%--<c:if test="<%= permissionChecker.hasPermission(groupId, name, primKey, ActionKeys.DELETE) %>"> --%>
    <portlet:actionURL name="deleteSite" var="deleteURL">
      <portlet:param name="resourcePrimKey" value="<%= primKey %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
  <%--</c:if> --%>

</liferay-ui:icon-menu>