$(document).ready(function(){
	loadOrderObjectInfo();
	$("#modal-dialog").on("click",".ok",doSaveOrUpdateOrder);
	   $("#modal-dialog").on("hidden.bs.modal",function(){
		   $("#modal-dialog").off("click",".ok");
		   $("#modal-dialog").removeData("orderId");
	   });
})
//加载订单对象详情
function loadOrderObjectInfo(){
	var orderId = $("#modal-dialog").data("orderId");
	var url = "toLoadOrderObjectInfo.do";
	var param ={"orderId":orderId};

	$.post(url,param,function(result){
		if(result.state){
			doShowOrderObjectInfo(result.data);
		}
	})
}
//显示页面数据
function doShowOrderObjectInfo(data){
	$("#orderId").val(data.orderId);
	$("#addressId").val(data.address);
	$("#cancelTimeId").val(data.cancelTime);
	$("#editFormId input[name='buyType']")
	.each(function(){
		if($(this).val()==data.buyType){
			$(this).prop("checked",true);
		}
	});
	$("#editFormId input[name='status']")
	.each(function(){
		if($(this).val()==data.status){
			$(this).prop("checked",true);
		}
	});
	$("#noteId").val(data.note);
}
//保存修改订单
function doSaveOrUpdateOrder(){
	var url = "toUpdateOrderObject.do";
	var param = {"orderId":$("#orderId").val(),
			"address":$("#addressId").val(),
			"cancelTime":$("#cancelTimeId").val(),
			"buyType":$("input[name='buyType']:checked").val(),
			"status":$("input[name='status']:checked").val(),
			"note":$("#noteId").val()};
	console.log(param);
	$.post(url,param,function(result){
		if(result.state){
			//隐藏模态框
			$("#modal-dialog").modal("hide");
			//重新查询数据
			doGetObjects();
		}
	})
}












