<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script type="text/javascript">
var savedLogin = false;

$(function() {
	$("#input[name='email']").keyup(function(event) {
		if(event.keyCode == 13)
			$("#input[name='password']").focus();
	});
	
	$("#input[name='password']").keyup(function(event) {
		if(event.keyCode == 13) {
			$("#login").click();
		}
	});
	
	$("#savedLogin").button({
		create: function() {
			$(this).data('toggle', false);
		}
	}).click(function() {
		var $this = $(this);
		var toggled = !$this.data('toggle');
		
		if(toggled == true) {
			/* login save */
			savedLogin = true;
		} else {
			/* login unsave */
			savedLogin = false;
		}
		
		$this.data('toggle', toggled);
	});

	$("#login").button().click(function() {
		var $this = $(this);
		var data = {
				email: $("#email").val(),
				password: $("#password").val(),
				save: savedLogin
			};
		var actions = {
				enable: function() {
					$this.button('option', 'label', $this.data('originalLabel'));
					$this.button('enable');
					console.log('login finished!');
				},
				disable: function() {
					$this.button('disable');
					$this.data('originalLabel', $this.button('option', 'label'));
					$this.button('option', 'label', '처리중...');
					
				}
		};
		$.sso('login', {
			valid: {
				url: "${webappRoot}/login/validation",
				data: data
			},
			submit: {
				url: "${webappRoot}/login/submit",
				data: data
			},
			beforeSend: function() {
				$("font[role='errorField']").text('');
				actions.disable();
				console.log('before send clear');
			},
			validCallback: function(valid) {
				$("#"+valid.field).parent().find("font[role='errorField']").text(valid.message);
				actions.enable();
			},
			success: function() {
				actions.enable();
				window.location.href = "${webappRoot}/main/index";
				//alert('login!!!');
			},
			deny: function() {
				msgbox("Login Denied!!", '이메일주소와 비밀번호가 틀립니다.\n다시 한번 시도해주십시오.');
				actions.enable();
			}
		});
	});
});
</script>

<div>
	<div style="font-size:15px;">로그인</div>
	<br />
	<table style="width:100%;">
		<tr>
			<td align="right">
				이메일 : 
			</td>
			<td align="left">
				<input id="email" name="email" type="text" size="30" value="" /><br />
				<font role='errorField' color="red"></font>
			</td>
		</tr>
		<tr>
			<td align="right">
				비밀번호 : 
			</td>
			<td align="left">
				<input id="password" name="password" type="password" size="30" value="" />
				<br /> 
				<font role='errorField' color="red"></font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<div align="right" style="margin-right:28%;"> 
					<input id="savedLogin" type="checkbox" /><label for="savedLogin">로그인 상태 유지</label>
				</div>
			</td> 
		</tr>
		<tr>
			<td colspan="2" align="right" >
				<button id="login" style="margin-right:28%;">로그인</button>
			</td>
		</tr>
	</table>
</div>