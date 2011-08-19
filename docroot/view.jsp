<%/**
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
 */%>
<%@include file="/init.jsp" %>

<%
	/** Retrieve all user enrollments, regardless of entity */

List<Course> courses = MyCoursesPortlet.getAllEnrollments(renderRequest);

Boolean isDefaultUser = (Boolean)request.getAttribute("isDefaultUser");
Entity entity = (Entity)request.getAttribute("entity");

%>

<div id="mycourses">
	<div>
		<img id='schoolhouse' src='<%=renderRequest.getContextPath() %>/images/schoolhouse-sm.png' alt='schoolhouse' />

		<p id="headline_main">My Courses</p>
		<span id="tip">
			<aui:a href="javascript:void();" cssClass="help aui-icon aui-icon-help" />
		</span>
	</div>
	
	<%
	if (isDefaultUser) {
	%>
	<!-- Not logged in -->
		<table>
			<tr>
				<td>
					<span class="entity_name">Sorry!</span>
				</td>
				<td>
					Please login to view course enrollments
				</td>
			</tr>
		</table>
	<%
	
	} else if ((!isDefaultUser) && (courses == null)) {
	%>
		<!-- Logged in, but cannot determine affiliation -->
		<table>
			<tr>
			<td>
				<span class="entity_name">Sorry!</span>
			</td>
			<td>
				Could not determine your school affiliation
			</td>
			</tr>
		</table>
	<%
	
	} else {
	%>
		<!-- Logged in and affiliation determined OR preferred entity chosen-->
	 	<table>
			<tr>
			<td>
				<span class="entity_name"><%=entity.getEntityName().toString() %></span>
			</td>
			<td>
				<span id="entity_link_tooltip" title="Go to <b><%=entity.getEntityName().toString() %></b> online learning <br />home page in a new window">
					<aui:a class="entity_link" href="<%=entity.getUrl().toString() %>" target="_blank" cssClass="aui-icon aui-icon-home" />
				</span>
			</td>
			</tr>
		</table>
	<%
	
		if (!courses.isEmpty()) {
			int i = 0;
			
			for (Course course : courses)
			{
				if (course.getEntityId() == entity.getEntityId()) {
			%>
					<a href='<%=entity.getUrl().toString() %>/course/view.php?id=<%=course.getCourseId() %>' target='_blank' class='courseName'><%=course.getName().toString() %></a>
			<%
				i++;
			
				}
			
			}
			
			if (i == 0) {
				%>
				<span>You are not enrolled in any classes at <%=entity.getEntityName() %></span>
				<%
			
			}
		
		} else {
			%>
			<span>You are not enrolled in any classes at <%=entity.getEntityName() %></span>
			<%
			
		}
	
	} 	
	
	if (!isDefaultUser) {
	%>
		<!-- Logged in;  Display Change School option -->
		<div id="changeEntityForm">
			<portlet:renderURL var="changeEntityURL"><portlet:param name="jspPage" value="/change_entity.jsp" /></portlet:renderURL>
			<table>
			<tr><td>
				<aui:button-row>
					<aui:button 
						type="button" 
						value="Change School" 
						onClick="<%=changeEntityURL %>"
					/>
					
				</aui:button-row>
			</td><td>
				<aui:a href="javascript:void();" cssClass="change-entity-help aui-icon aui-icon-help" />
			</td></tr>
			</table>
		</div>
	<%
	
	}
 	%>
	
</div>