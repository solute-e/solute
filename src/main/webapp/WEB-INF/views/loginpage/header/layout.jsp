<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="s-wrap">
    <ul class="s-list">
        <li role="title">
            <spring:message code="project.name.default" />
        </li>
    	<li role="email">
    		<input type="text" class="k-textbox" value="" />
    	</li>
    	<li role="password">
    		<input type="password" class="k-textbox" value="" />
    	</li>
    	<li role="help">
    		<button class="k-button">?</button>
    	</li>
    	<li role="together">함께하기</li>
        <li role="donate">문제기부하기</li>
    </ul>
</div>