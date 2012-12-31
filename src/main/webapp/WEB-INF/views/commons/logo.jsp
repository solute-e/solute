<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
$(function() {
	$("#searchBtn").button().click(function() {
		location.href = "${webappRoot}/main/result?searchParam="+$("#searchTxt").val();
	});
});
</script>

<div id="logo" align="center" style="border:none; border-bottom: 1px solid blue;">
	<table>
		<tr>
			<td align="right" style="vertical-align: middle; " >
				<font size="5em">Solute</font>
			</td>
			<td align="left" style="vertical-align: middle;">
				<div style="margin-top: 5px;">
					<input id="searchTxt" name="searchTxt" type="text" size="100" value="${param.searchParam}" />
					<button id="searchBtn">검색</button>
				</div>
			</td>
		</tr>
	</table>
	
</div>