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
</head>
<body>
	<div class="container-fluid" style="height: 100%;">
		<div class="row-fluid" style="height: 80%;">
			<div class="span9">
				
			</div>
			<div class="span2">
				
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