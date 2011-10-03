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

AUI().use('aui-tooltip', function(A) {
	var help = new A.Tooltip({
		trigger: '.help',
		align: { points: [ 'tl', 'bc' ] },
		bodyContent: "<b>Help</b><br /><br />" +
				"All fields are required<br /><br />" +
				"<b>Site URL</b> should point to the LMS address with format: <i>http://some.address.org</i><br /><br />" +
				"<b>Database Server URL</b> should point to the server address of the LMS database with format: <i>database.server.org</i><br /><br />" +
				"<b>Database user</b> must have a minimum of <i>select</i> privileges on the LMS database<br /><br />" +
				"On save, the database connection will be tested.  If the connection fails, you will receive an error.  Fix the database information before saving again.<br /><br />"
	}).render();
});

