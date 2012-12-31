<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<tiles:insertAttribute name="commons" />
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<div align="center" style="width:100%;">
		<table style="width:100%;">
			<tr>
				<td>
					<tiles:insertAttribute name="subHeader" />
				</td>
			</tr>
			<tr>
				<td>
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
		</table>
	</div>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>