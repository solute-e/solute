<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html lang="${lang}">
<head>
    <meta charset="utf-8" />
    <title><tiles:insertAttribute name="title" /></title>
    <tiles:insertAttribute name="commons" />
</head>
<body>
<div class="s-front">
    <header class="s-front-header">
        <tiles:insertAttribute name="header" />
    </header>
    <div class="s-front-body">
        <tiles:insertAttribute name="body" />
    </div>
    <footer class="s-front-footer">
        <tiles:insertAttribute name="footer" />
    </footer>
</div>
</body>
</html>