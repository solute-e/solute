<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 13. 1. 31
  Time: 오후 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>Solute Test Page</title>
    <script data-main="${webappRoot}/resources/js/config.js" src="${webappRoot}/resources/js/libs/require.js"></script>
</head>
<body>
<script>
    require(["jquery", "underscore", "backbone"], function ($, _, Backbone) {
        var model = new Backbone.Model.extend({
            initialize: function () {
                alert('aaa');
            }
        });
    });
</script>
</body>
</html>