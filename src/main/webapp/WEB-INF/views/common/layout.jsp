<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html lang="${lang}">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <title><spring:message code="project.name.firstlarge" /></title>
    <tiles:insertAttribute name="commons" />
</head>
<body data-spy="scroll" data-twttr-rendered="true">
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<tiles:insertAttribute name="header" />
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="span8">
		</div>
	</div>
</div>
</body>
</html>