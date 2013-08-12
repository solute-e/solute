solute.router = (function(Backbone) {
	var SoluteRouter = Backbone.Router.extend({
		routes: {
			"upload": "upload"
		}
	});
	
	return new SoluteRouter;
}(Backbone));

solute.router.on("route:upload", function() {
	alert('hi');
});
