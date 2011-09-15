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
List<Entity> entities = EntityLocalServiceUtil.getEntities(QueryUtil.ALL_POS,QueryUtil.ALL_POS);;
%>

<portlet:renderURL var="cancelURL"><portlet:param name="jspPage" value="/view.jsp" /></portlet:renderURL>

<portlet:actionURL name="changeEntity" var="changeEntityURL" />

<div id="mycourses">
	<div>
		<img id='schoolhouse' src='<%=renderRequest.getContextPath() %>/images/schoolhouse-sm.png' alt='schoolhouse' />

		<p id="headline_main">Change School</p>
	</div>

<aui:form name="form" action="<%=changeEntityURL.toString() %>" method="post">
	<aui:fieldset>
		<aui:select name="entityId" label="Choose a School">
			<%
			for (Entity entity : entities) {
				%>
				<aui:option value="<%=entity.getEntityId() %>">
					<%=entity.getEntityName() %>
				</aui:option>
				<%
			}
			%>
		</aui:select>

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
</div>