$(document).ready(function(){
	doLoadPageObject();
	$("#modal-dialog").on("click",".btn-primary",function(){
		console.log("hidden");
		$("#modal-dialog").modal("hidden");
	});
	$("#modal-dialog")
	   .on("hidden.bs.modal",function(){
		   $("#modal-dialog").off("click",".btn-primary");
		   $("#modal-dialog").removeData("id");
	   });
})
//加载页面对象
function doLoadPageObject(){
	var id = $("#modal-dialog").data("id");
	var url = "toGetUserObjectInfo.do";
	var param = {"id":id};
	$.post(url,param,function(result){
		if(result.state){
			doListPageObject(result.data);
		}
	});
}
//显示当前用户信息
function doListPageObject(data){
	$("#userNameId").val(data.userName);
	$("#roleNameId").val(data.roleName==1?"超级管理员":data.roleName==2?"普通会员":"普通用户");
	$("#nickNameId").val(data.nickName);
	$("#emailId").val(data.email);
	$("#editTypeForm input[name='status']")
	.each(function(){
		if($(this).val()==data.status){
			$(this).prop("checked",true);
		}
	});
}




