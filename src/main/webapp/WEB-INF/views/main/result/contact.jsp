<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
li {
	color:blue;
}

.problem {
	width: 100px;
	height: 100px;
	background-color: blue;
	background-image: none;
	float: left;
	margin-top: 10px;
	margin-left: 10px;
}
</style>

<script type="text/javascript">
function search(searchParam) {
	$.ajax({
		url: "${webappRoot}/main/result/search",
		type: "post",
		dataType: "json",
		data: {
			searchParam: searchParam
		},
		error: function() {
			msgbox("error!!", "검색값이 잘못되었습니다.");
		}, 
		success: function(data) {
			
		}
	});
}

$(function() {
	var searchParam = "${param.searchParam}"
	if(searchParam.length != "") {
		/* 검색 값... */
		search(searchParam);
	}
	
	$("#logo #searchBtn").unbind('click').click(function() {
		search($("#logo #searchTxt").val());
	});
	
	$("#searchCategory").buttonset();
	$("#orderCategory").buttonset();
	
	$("#totalSelect").button({
		icons: { primary: "ui-icon-circle-check"}
	});
	$("#selectCart").button({
		icons: {primary: "ui-icon-cart"}
	});
});
</script>

<div align="center">
	<table cellspacing="0" style="width:100%; padding: 0px; margin: 0px; outline-width: 0px;">
		<tr>
			<td colspan="4" align="center" width="100%" valign="top">
				<p>
					<div id="searchCategory" style="margin-left: 55%;">
						<input type="radio" id="total" name="searchCategory" checked="checked" /><label for="total">전체</label>
						<input type="radio" id="resolve" name="searchCategory" /><label for="resolve">해결</label>
						<input type="radio" id="unresolve" name="searchCategory" /><label for="unresolve">미해결</label>
					</div>
				</p>
			</td>
		</tr>
		<tr>
			<td valign="top" width="24%" style="margin:0px; border-right-style: dashed;" class="ui-widget-content ui-corner-tl ui-corner-bl">
				<h3 style="margin:1px;" class="ui-widget-header ui-corner-tl ui-corner-tr">&nbsp;</h3>
				<ul>
					<li>행렬의 기초</li>
					<li>행렬의 곱셈</li>
					<li>행렬 ㅅㅂ</li>
					<li>케일리-헤밀턴</li>
				</ul>
			</td>
			<td width="50%" valign="top" style="border-left:none;" class="ui-widget-content ui-corner-tr ui-corner-br">
				<div align="left">
					<table style="width:100%;">
						<tr>
							<td>
								<div id="orderCategory">
									<input type="radio" id="lookup" name="orderCategory" checked="checked" /><label for="lookup">조회 순</label>
									<input type="radio" id="output" name="orderCategory" /><label for="output">출력 순</label>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<button id="totalSelect">모두 선택</button>
								<button id="selectCart">선택 담기</button>
							</td>
						</tr>
						<tr>
							<td>
								<div> 
									<div class="ui-widget-content ui-corner-all problem"></div>
									<div class="ui-widget-content ui-corner-all problem"></div>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</td>
			<td>
			</td>
			<td>
			</td>
		</tr>
	</table>
</div>