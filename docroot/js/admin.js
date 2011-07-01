AUI().use('aui-tooltip', function(A) {
	var help = new A.Tooltip({
		trigger: '.help',
		align: { points: [ 'tl', 'bc' ] },
		bodyContent: "<b>Help</b><br /><br />" +
				"All fields are required<br /><br />" +
				"<b>Entity URL</b> should point to the LMS address with format: <i>http://some.address.org</i><br /><br />" +
				"<b>Database Server URL</b> should point to the server address of the LMS database with format: <i>database.server.org</i><br /><br />" +
				"<b>Database user</b> must have a minimum of <i>select</i> privileges on the LMS database<br /><br />" +
				"On save, the database connection will be tested.  If the connection fails, you will receive an error.  Fix the database information before saving again.<br /><br />"
	}).render();
});

