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
    <script src="${webappRoot}/resources/js/libs/require.js"></script>
    <script src="${webappRoot}/resources/js/config.js"></script>
</head>
<body>
<script>
   require(["jquery", "underscore", "backbone"], function ($, _, Backbone) {
       console.debug(Backbone);
       var MyModel = Backbone.Model.extend({
           urlRoot:"/mtest",
           defaults: {
               id: "",
               msg: ""
           }
       });

       var mmodel = new MyModel({id: "1"});
       mmodel.fetch({
           success: function (mmodel) {
               alert(mmodel.toJSON());
           }
       });
   });
</script>
</body>
</html>