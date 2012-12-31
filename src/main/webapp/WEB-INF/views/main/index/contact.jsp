<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
<!--
.searchTxt {
	height:1.5em; 
	border:3px solid blue; 
	border-radius:5px;
}

.searchTxt:hover {
	background: #ff6;
	border-color: red;
}
-->
</style>

<script type="text/javascript">
$(function() {
	$.ajax({
		type: "post",
		url: "${webappRoot}/main/index/ns",
		success: function(cnts) {
			for(var key in cnts) {
				$("#"+key).text(cnts[key]);
			}
		}
	});
	
	$("input.searchTxt[type='text']").keyup(function(e) {
		if(e.keyCode == 13) {
			/* 검색 시작 */
			window.location.href = "${webappRoot}/main/result?searchParam="+$(this).val();
		}
	});
});
</script>

<div align="center">
	<div style="width:60%;">
		<input class="searchTxt" style="width:100%;" type="text" value="" />
		<br />
		<table style="width:100%;">
			<tr>
				<td align="center">
					<font color="blue">언어(<font id='language'></font>)</font>
				</td>
				<td align="center">
					<font color="blue">외국어(<font id='english'></font>)</font>
				</td>
				<td align="center">
					<font color="blue">수리(<font id='math'></font>)</font>
				</td>
				<td align="center">
					<font color="blue">과탐(<font id='science'></font>)</font>
				</td>
				<td align="center">
					<font color="blue">사탐(<font id='society'></font>)</font>
				</td>
			</tr>
		</table>
	</div>
</div>