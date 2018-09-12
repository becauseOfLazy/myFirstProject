$(document).ready(function(){
	doGetObjects();
	$("#formHead").on("click",".btn-search",doSearchUser);
})
//查询用户对象
function doSearchUser(){
	var searchName = $("#searchNameId").val();
	var roleId = $("#searchValidId option:selected").val();
	var url = "toSearchUserObject.do";
	var param = {"searchName":searchName,"roleId":roleId};
	$.post(url,param,function(result){
		if(result.state){
			
			loadUserListObject(result.data);
		}
	})
	
}
//加载用户信息
function doGetObjects(){
	var url = "doLoadUserObject.do";
	var pageCurrent = $('#pageId').data("pageCurrent");
	if(!pageCurrent){
		pageCurrent = 1;
	}
	var param = {"pageCurrent":pageCurrent};
	$.post(url,param,function(result){
		if(result.state){
			var pageObject = result.data.page;
			var lists = result.data.lists;
			//设置分页
			setPagination(pageObject);
			//加载显示内容
			loadUserListObject(lists);
		}
	})
}
//显示用户列表信息
function loadUserListObject(data){
	var tbody = $("#tbodys_id");
	tbody.empty();
	
	for(var index in data){
		var tr = $("<tr></tr>");
		tr.data("id",data[index].id);
		var td = "<td>"+data[index].userName+"</td>" +
				"<td>"+data[index].nickName+"</td>" +
				"<td>"+data[index].email+"</td>" +
				"<td>"+data[index].createdTime+"</td>" +
				"<td>"+(data[index].status==1?"已上线":(data[index].status==2?"已离线":"已冻结"))+"</td>" +
				"<td><button type='button' class='btn btn-default' onclick='doGetUserObjectInfoPage(this)'>详情</button></td>";
		
		tr.append(td);
		tbody.append(tr);
	}
	
}
//获取用户详情
function doGetUserObjectInfoPage(btn){
	var id = $(btn).parent().parent().find(".user_id").val();
	$("#modal-dialog").data("id",id);
	$(".modal-title").html("用户详情");
	$(".bt-concle").text("取消");
	$(".bt-ok").text("确认");
	$("#modal-dialog").modal("show");
	$("#modal-dialog").on("show.bs.modal",doGetUserInfo());
}
//获取用户信息
function doGetUserInfo(){
	var url = "toGetUserInfoPage.do";
	$(".modal-body").load(url);
}







