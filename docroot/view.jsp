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
	/** Retrieve all user enrollments, regardless of site */

List<Course> courses = MyCoursesPortlet.getAllEnrollments(renderRequest);

Boolean isDefaultUser = (Boolean)request.getAttribute("isDefaultUser");
Site site = (Site)request.getAttribute("site");

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
					<span class="site_name">Sorry!</span>
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
				<span class="site_name">Sorry!</span>
			</td>
			<td>
				Could not determine your school affiliation
			</td>
			</tr>
		</table>
	<%

	} else {
	%>
		<!-- Logged in and affiliation determined OR preferred site chosen-->
	 	<table>
			<tr>
			<td>
				<span class="site_name"><%=site.getSiteName().toString() %></span>
			</td>
			<td>
				<span id="site_link_tooltip" title="Go to <b><%=site.getSiteName().toString() %></b> online learning <br />home page in a new window">
					<aui:a class="site_link" href="<%=site.getUrl().toString() %>" target="_blank" cssClass="aui-icon aui-icon-home" />
				</span>
			</td>
			</tr>
		</table>
	<%

		if (!courses.isEmpty()) {
			int i = 0;

			for (Course course : courses)
			{
				if (course.getSiteId() == site.getSiteId()) {
			%>
					<a href='<%=site.getUrl().toString() %>/course/view.php?id=<%=course.getCourseId() %>' target='_blank' class='courseName'><%=course.getName().toString() %></a>
			<%
				i++;

				}

			}

			if (i == 0) {
				%>
				<span>You are not enrolled in any classes at <%=site.getSiteName() %></span>
				<%

			}

		} else {
			%>
			<span>You are not enrolled in any classes at <%=site.getSiteName() %></span>
			<%

		}

	}

	if (!isDefaultUser) {
	%>
		<!-- Logged in;  Display Change Site option -->
		<div id="changeSiteForm">
			<portlet:renderURL var="changeSiteURL"><portlet:param name="jspPage" value="/change_site.jsp" /></portlet:renderURL>
			<table>
			<tr><td>
				<aui:button-row>
					<aui:button
						type="button"
						value="Change Site"
						onClick="<%=changeSiteURL %>"
					/>

				</aui:button-row>
			</td><td>
				<aui:a href="javascript:void();" cssClass="change-site-help aui-icon aui-icon-help" />
			</td></tr>
			</table>
		</div>
	<%

	}
 	%>

</div>