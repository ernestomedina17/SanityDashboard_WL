function getMappings() {
	$("#template").empty();
	$("#template").load("/listMappings", function(responseTxt, statusTxt, xhr) {
		if (statusTxt == "success") {
			console.log("External content loaded successfully!");
		}
		if (statusTxt == "error") {
			console.error("Error: " + xhr.status + ": " + xhr.statusText);
		}
	});

}