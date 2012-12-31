function msgbox(title, message) {
	var msgs = message.split("\n");
	
	var $dialog = $("<div></div>").dialog({
		modal: true,
		title: title,
		buttons: {
			"OK" : function() {
				$(this).dialog('close');
			}
		},
		resizable: false
	});
	
	for(var i in msgs) {
		var msg = msgs[i];
		$dialog.append($("<p></p>").text(msg));
	}
}
