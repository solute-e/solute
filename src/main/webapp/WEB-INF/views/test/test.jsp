<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
<script src="${webappRoot}/resources/js/jquery-1.7.2.min.js"></script>
<script src="${webappRoot}/resources/js/thrift.js"></script>
<script src="${webappRoot}/resources/js/thrift/gen/EchoService.js"></script>
<script>
	$(function () {
		var transport = new Thrift.Transport("${webappRoot}/thrift/test");
	    var protocol  = new Thrift.Protocol(transport);
	    var client    = new EchoServiceClient(protocol);

		$("#echo_box").text(client.echo("strstr"));
		
	});
</script>
</head>
<body>
	<div id="echo_box" style="font-size: 30px;">
	</div>
</body>
</html>