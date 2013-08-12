<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="s-header container">
	<a class="s-title brand" href="#">Solute</a>
	<ul class="nav pull-right">
		<li class="s-form">
			<input class="s-email" type="email" placeholder="이메일 계정을 입력하세요." />
			<input class="s-passwd" type="password" placeholder="비밀번호를 입력하세요." />
			<button class="s-submit btn btn-submit" type="submit">Sign in</button>
		</li>
		<li class="s-help">
			<button class="btn btn-info">?</button>
		</li>
		<li class="s-together">
			<a href="#">함께하기</a>
		</li>
       	<li id="s-donate" class="s-donate">
       		<a href="#/upload">문제기부하기</a>
       	</li>
	</ul>
</div>