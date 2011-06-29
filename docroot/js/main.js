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
});

