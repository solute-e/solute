<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript">
	$(function() {
		$("#login").button().click(function() {
			window.location = "${webappRoot}/login";
		});

		$("#regist").button().click(function() {
			window.location = "${webappRoot}/regist";
		});
	});
</script>

<div>
	<button id='login' style="width:150px; height:150px; font-size:20px;">로그인</button>
	<button id='regist' style="width:150px; height:150px; font-size:20px;">가입하기</button>
</div>