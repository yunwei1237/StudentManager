$(function() {

	$("#page").appendPagination({
		"pageIndex":1,
		pages:5,
		len:5,
		action:function(pageIndex){
			alert(pageIndex);
		}
	});
	
	$("#page").appendPagination({
		"pageIndex":3,
		pages:5,
		len:5,
		action:function(pageIndex){
			alert(pageIndex);
		}
	});
});


