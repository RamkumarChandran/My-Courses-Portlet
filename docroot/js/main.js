AUI().use('aui-tooltip', function(A) {
	var help = new A.Tooltip({
		trigger: '.help',
		align: { points: [ 'tl', 'bc' ] },
		bodyContent: "<b>Help</b><br />" +
				"Click on a course name to open the course in a new window<br /><br />" +
				"<span class='aui-icon aui-icon-circle-arrow-r'></span>Click the above icon to open the main online learning page for the school<br /><br />" +
				"<span class='aui-icon aui-icon-circle-minus'></span>Click the above icon to remove the school from your view"
	}).render();
	
	var entity_link_tooltip = new A.Tooltip({
		trigger: '#entity_link_tooltip',
		align: { points: [ 'bl', 'tl' ] },
		title: true
	}).render();
});

