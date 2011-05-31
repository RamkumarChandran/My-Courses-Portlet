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
/** long entityId = MyCoursePortlet.getUserHomeSchool(renderRequest); */
long entityId = 1;
String url = EntityLocalServiceUtil.getEntityUrl(entityId);
List<Course> courses = MyCoursePortlet.getAllEnrollments(renderRequest);
%>

<div id="mycourses">
	<p id="headline_main">My Courses</p>
	<span id="tip">Click course name to go to class</span>
	
	<h2 class="headline_entity"></h2>
	<%
	for (Course course : courses) 
	{
	%>
		<a href='<%=url%>/course/view.php?id=<%=course.getCourseId()%>' target='_blank' class='courseName'><%=course.getName().toString()%></a>
	<% 
	} 
	%>
</div>