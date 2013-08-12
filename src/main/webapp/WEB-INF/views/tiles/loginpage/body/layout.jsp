<%--
  Created by IntelliJ IDEA.
  User: JCooky
  Date: 13. 1. 14
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="s-wrap">
    <div class="s-content">
        <tiles:insertAttribute name="title" />
        <div class="s-contents-container">
            <div class="s-left">
                <tiles:insertAttribute name="left" />
            </div>
            <div class="s-right">
                <tiles:insertAttribute name="right" />
            </div>
        </div>
    </div>
</div>
