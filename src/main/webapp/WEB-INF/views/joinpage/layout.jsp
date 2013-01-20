<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html lang="${lang}">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <title><spring:message code="project.name.firstlarge" /></title>
    <tiles:insertAttribute name="commons" />
</head>
<body>
<div class="s-joinpage">
    <div class="s-joinpage-wrap">
        <header class="s-joinpage-header">
            <tiles:insertAttribute name="header" />
        </header>
        <div class="s-joinpage-body">
            <tiles:insertAttribute name="body" />
        </div>
        <footer class="s-joinpage-footer">
            <tiles:insertAttribute name="footer" />
        </footer>
    </div>
</div>
</body>
</html>