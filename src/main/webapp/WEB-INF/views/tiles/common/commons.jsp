<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>

<link rel="stylesheet" href="${webappRoot}/resources/styles/<spring:theme code="css"/>" type="text/css" />
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/lodash.js/1.3.1/lodash.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.0.0/backbone.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${webappRoot}/resources/js/solute.js"></script>
<script type="text/javascript" src="${webappRoot}/resources/js/routes.js"></script>
<style type="text/css">
    #uploadView {
        width: 800px;
        margin-left: -400px;
    }
</style>
<script type="text/javascript">
(function (Backbone) {
	Backbone.history.start();
}(Backbone));
</script>

<div id="uploadView" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="uploadViewLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="uploadViewLabel">Uploader</h3>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="row-fluid">
				<div id="uploader.problem" class="span9" draggable="true">

				</div>
				<div id="uploader.solution" class="span3">

				</div>
			</div>
			<div class="row-fluid">
				<div class="span9"></div>
				<div class="span3">
					<form class="form-inline">
						<input type="text" placeholder="Type keyword" />
						<button type="submit" class="btn">Add</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
	</div>
</div>