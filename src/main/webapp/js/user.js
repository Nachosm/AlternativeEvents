(function(){
	window.onload = function () {
		AE.Utils.initAjax();
		loadUserDetail();
		console.log("Works User");
	}
	
})();

function loadUserDetail(){
	
	let url = "alternativeevents/api/users/1";
	
	$.getJSON(url)
	.done(function (data){
		displayUserDeatails(data);
	})
	.fail(function (jqXHR, textStatus, errorThrown){
		AE.Utils.defaultErrorHandling(jqXHR);
	})
	.always(function () {
		
	});
}

function displayUserDeatails(data) {
	
	
	$("#about").html(
		 Handlebars.compile($("#user-details").html())({
		   details: data,
		 })
	);
	console.log(data);
}


