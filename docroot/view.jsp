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

/** Retrieve information about user's main entity, or "home school" */

long homeEntityId = MyCoursesPortlet.getUserHomeSchool(renderRequest);
String homeEntityUrl = EntityLocalServiceUtil.getEntityUrl(homeEntityId);
String homeEntityName = EntityLocalServiceUtil.getEntityName(homeEntityId);
%>

<div id="mycourses">
	<div>
		<img id='schoolhouse' src='<%=renderRequest.getContextPath() %>/images/schoolhouse-sm.png' alt='schoolhouse' />

		<p id="headline_main">My Courses</p>
		<span id="tip">
			<aui:a href="javascript:void();" cssClass="help aui-icon aui-icon-help" />
		</span>
	</div>
	
	<!-- Display home school enrollments -->
 
	<table>
		<tr>
		<td>
			<span class="entity_name"><%=homeEntityName %></span>
		</td>
		<td>
			<span id="entity_link_tooltip" title="Go to <b><%=homeEntityName %></b> online learning <br />home page in a new window">
				<aui:a class="entity_link" href="<%=homeEntityUrl%>" target="_blank" cssClass="aui-icon aui-icon-home" />
			</span>
		</td>
		</tr>
	</table>
	<%
	if (courses.isEmpty()) {
		%>
		<span>You are not enrolled in any classes at <%=homeEntityName %></span>
		<%
	}
	for (Course course : courses)
	{
		if (course.getEntityId() == homeEntityId) {
	%>
			<a href='<%=homeEntityUrl%>/course/view.php?id=<%=course.getCourseId() %>' target='_blank' class='courseName'><%=course.getName().toString() %></a>
	<%
		}
	}
	%>

	<!-- Check for and display any remote enrollments -->

	<%
	PortletPreferences prefs = renderRequest.getPreferences();

	List<String> remoteEntityIds = Arrays.asList(prefs.getValues("remoteEntities", new String[] {"-1"}));

	//List<String> remoteEntityIds = new ArrayList<String>();
	while (!remoteEntityIds.get(0).equals("-1")) {
		for (String entityId : remoteEntityIds) {
			Entity entity = EntityLocalServiceUtil.getEntity(Long.valueOf(entityId));
			List<Host> host = HostLocalServiceUtil.findByLR(homeEntityId, entity.getEntityId());
			long peerId = host.get(0).getPeerId();

			%>
			<liferay-ui:icon cssClass="aui-icon aui-icon-circle-minus"></liferay-ui:icon>
			<p class="headline_entity"><%=entity.getEntityName().toString() %></p>
			<%
			if (courses.isEmpty()) {
				%>
				<span>You are not enrolled in any classes at <%=entity.getEntityName().toString() %></span>
				<%
			}
			for (Course course : courses)
			{
				if (course.getEntityId() == entity.getEntityId()) {
			%>
					<a href='<%=homeEntityUrl %>/auth/mnet/jump.php?hostid=<%=peerId %>&wantsurl=/course/view.php?id=<%=course.getCourseId() %>' target='_blank' class='courseName'><%=course.getName().toString() %></a>
			<%
				}
			}
		}
	}
	%>
</div>