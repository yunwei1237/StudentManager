$(function(){
	bindClickToTr();
});
///绑定tr的点击事件
function bindClickToTr(){
	$("#personals tbody tr").click(function(){
		var id = $(this).children("td:eq(0)").html();
		alert(id);
	});
}