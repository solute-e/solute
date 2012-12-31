<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<tiles:insertAttribute name="commons" />
	<tiles:insertAttribute name="script" />
</head>
<body>
	<div align="center"
		class="sso">
		<table class="main_table" style="width:100%; height:100%;">
			<tr>
				<td colspan="2" align="center" height="45%">
					<div style="font-size:50px;">
						<tiles:insertAttribute name="logo" />
					</div>
				</td>
			</tr>
			<tr>
			</tr>
			<tr >
				<td width="45%" align="center" height="55%">
					<tiles:insertAttribute name="subLogo" />
				</td>
				<td width="55%" align="center">
					<tiles:insertAttribute name="contact" />
				</td>
			</tr>
		</table>  
	</div>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>