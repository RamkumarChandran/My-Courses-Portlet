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

<% 
long entityId = MyCoursePortlet.getUserHomeSchool(renderRequest);
String entityUrl = EntityLocalServiceUtil.getEntityUrl(entityId);
String entityName = EntityLocalServiceUtil.getEntityName(entityId);
List<Course> courses = MyCoursePortlet.getAllEnrollments(renderRequest);
%>

<div id="mycourses">
	<p id="headline_main">My Courses</p>
	
	<span id="tip">Click course name to go to class</span>
	
	<p class="headline_entity"><%=entityName %></p> 
	<%
	if (courses.isEmpty()) {
		%>
		<span>You are not enrolled in any classes at <%=entityName %></span>
		<%
	}
	for (Course course : courses) 
	{
	%>
		<a href='<%=entityUrl%>/course/view.php?id=<%=course.getCourseId()%>' target='_blank' class='courseName'><%=course.getName().toString()%></a>
	<% 
	} 
	%>
</div>