<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>

<script type="text/javascript">
$(function() {
	$("#regist").button().click(function() {
		var $this = $(this);
		var data = {
				email: $("input[name='email']").val(),
				reEmail: $("input[name='reEmail']").val(),
				password: $("input[name='password']").val(),
				rePassword: $("input[name='rePassword']").val()
			};
		var actions = {
				enable: function() {
					$this.button('option', 'label', $this.data('originalLabel'));
					$this.button('enable');
					console.log('regist finished!');
				},
				disable: function() {
					$this.button('disable');
					$this.data('originalLabel', $this.button('option', 'label'));
					$this.button('option', 'label', '처리중...');
					
				}
		};
		$.sso('regist', {
			valid: {
				url: "${webappRoot}/regist/validation",
				data: data
			},
			submit: {
				url: "${webappRoot}/regist/submit",
				data: {
					email: data.email,
					password: data.password
				}
			},
			beforeSend: function() {
				$("font[role='errorField']").text('');
				actions.disable();
				console.log('before send clear');
			},
			validCallback: function(valid) {
				$("input[name='"+valid.field+"']").parent().find("font[role='errorField']").text(valid.message);
				actions.enable();
			},
			success: function() {
				actions.enable();
				window.location.href = "${webappRoot}/login";
			},
			deny: function() {
				alert('회원가입에 실패하였습니다. 다시 한번 시도해주십시오.\nError 0001');
				actions.enable();
			}
		});
	});
});
</script>

<div>
	<div style="font-size:15px;">가입하기</div>
	<br />
	<table style="width:100%;">
		<tr>
			<td align="right">
				이메일 주소 : 
			</td>
			<td align="left">
				<input name="email" type="text" size="20" value="" /><br />
				<font role='errorField' color="red"></font>
			</td>
		</tr>
		<tr>
			<td align="right">
				이메일 다시 입력 : 
			</td>
			<td align="left">
				<input name="reEmail" type="text" size="20" value="" /><br />
				<font role='errorField' color="red"></font>
			</td>
		</tr>
		<tr>
			<td align="right">
				비밀번호 : 
			</td>
			<td align="left">
				<input name="password" type="password" size="20" value="" />
				<br />
				<font role='errorField' color="red"></font>
			</td>
		</tr>
		<tr>
			<td align="right">
				비밀번호 다시 입력 : 
			</td>
			<td align="left">
				<input name="rePassword" type="password" size="20" value="" /><br />
				<font role='errorField' color="red"></font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right" >
				<button id="regist" style="margin-right:21%;">가입하기</button>
			</td>
		</tr>
	</table>
</div>