<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html lang="${lang}">
<head>
<meta charset="utf-8" />
<title>Solute</title>
</head>
<tiles:insertAttribute name="body" />
<body>
<header class="s_front s_header">
	<tiles:insertAttribute name="header" />
</header>
<div class="s_front s_body">
</div>
<footer class="s_front s_footer">
    <tiles:insertAttribute name="footer" />
</footer>
</body>
</html>