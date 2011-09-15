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
				"Click on a course name to open the course in a new window<br /><br />" +
				"<span class='aui-icon aui-icon-home'></span>Click the house icon next to a school name to open the main online learning page for the school<br /><br />"
	}).render();
	
	var entity_link_tooltip = new A.Tooltip({
		trigger: '#entity_link_tooltip',
		align: { points: [ 'bl', 'tl' ] },
		title: true
	}).render();
	
	var help = new A.Tooltip({
		trigger: '.change-entity-help',
		align: { points: [ 'tl', 'bc' ] },
		bodyContent: "<b>Change School</b><br /><br />" +
				"Do you see the wrong school listed above?<br /><br />" +
				"Use the Change School feature to select a different school.  From then on you will see course enrollments for the school you chose.<br /><br />"
	}).render();
});

