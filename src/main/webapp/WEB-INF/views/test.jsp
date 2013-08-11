<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Solute Test Page</title>
<link rel="stylesheet" href="${webappRoot}/resources/styles/<spring:theme code="css"/>" type="text/css" />
<script src="${webappRoot}/resources/js/libs/lodash.js"></script>
<script src="${webappRoot}/resources/js/libs/jquery.js"></script>
<script src="${webappRoot}/resources/js/libs/bootstrap.js"></script>
<script src="${webappRoot}/resources/js/libs/backbone.js"></script>
<style>
	html, body {
		height: 100%;
	}
</style>
<script>
function handleDrop(e) {
	console.debug(e);
	
	for (var i = 0; i < e.dataTransfer.files.length; ++i) {
		var file = e.dataTransfer.files[i];
	}
	
	console.debug(file);
	
	e.stopPropagation();
	e.preventDefault();
	
	return false;
}

$(function() {
	var els = document.querySelectorAll("#problem");
	[].forEach.call(els, function(el) {
		console.debug(el);
		el.addEventListener("drop", handleDrop, false);
		el.addEventListener("dragover", function(e) {
			console.debug("test");
			e.dataTransfer.dropEffect = 'copy';
			
			e.preventDefault();
		}, false);
	});
});
	
</script>
</head> 
<body>
	<div class="container-fluid" style="height: 100%;">
		<div class="row-fluid" style="height: 80%;">
			<div id="problem" class="span9" style="height: 100%;" draggable="true"> 
			</div>
			<div id="solution" class="span3" style="height: 100%;">
				<img src="${webappRoot}/resources/images/book.gif" />
			</div>
		</div> 
		<div class="row-fluid">
			<div class="span9">
			</div>
			<div class="span3">
				<form class="form-inline">
					<input type="text" placeholder="Type keyword" />
					<button type="submit" class="btn">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>