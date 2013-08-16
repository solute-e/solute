<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Solute Problem Uploader</title>
<link rel="stylesheet" href="${webappRoot}/resources/styles/<spring:theme code="css"/>" type="text/css" />
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/lodash.js/1.3.1/lodash.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.0.0/backbone-min.js"></script>
<style>
	html, body {
		height: 100%;
	}
</style>
</head> 
<body>
	<script>
		$(function() {
			$("#uploader.problem").bind("drop", function (e) {
				var $problem = $("#problem");
				e.stopPropagation();
				e.preventDefault();
				
				console.debug(e);
				
				for (var i = 0; i < e.originalEvent.dataTransfer.files.length; ++i) {
					var file = e.originalEvent.dataTransfer.files[i],
							fileUrl = URL.createObjectURL(file);
					console.debug(fileUrl);
					
					$problem.append($("<img></img>").attr('src', fileUrl));
				}
			}).bind("dragover", function (e) {
				e.stopPropagation();
				e.preventDefault();
			}).bind("dragenter", function (e) {
				e.stopPropagation();
				e.preventDefault();
			});
		});
		
	</script>
    <div class="modal-body">
        <div class="container-fluid" style="width: 800px; height: 600px;">
            <div class="row-fluid">
                <div id="uploader.problem" class="span9">
                </div>
                <div id="uploader.solution" class="span3">

                </div>
            </div>
            <div class="row-fluid">
                <div class="span9"></div>
                <div class="span3">
                    <form class="form-inline">
                        <input type="text" placeholder="Type keyword" />
                        <button type="submit" class="btn">Add</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>