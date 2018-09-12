$(document).ready(function(){
	toLoadReviewUserInfo();
	$("#formHead").on("click",".btn-search",doSearchReviewUser);
})
//查询审核用户信息
function doSearchReviewUser(){
	var userName = $("#searchNameId").val();
	var valid = $("#searchValidId option:selected").val();
	var url = "doSearchReviewUserObject.do";
	var param = {"userName":userName,"valid":valid};
	$.post(url,param,function(result){
		if(result.state){
			listReviewUserPage(result.data);
		}else{
			alert(result.message);
		}
	});
}
//加载用户审核页面的信息
function toLoadReviewUserObject(){
	var url = "toLoadReviewUserObject.do";
	var pageCurrent = $("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent = 1;
	}
	var param = {"pageCurrent":pageCurrent};
	$("#pageId").data("pageCurrent",pageCurrent);
	$.post(url,param,function(result){
		if(result.state){
			console.log(result.data);
			listReviewUserPage(result.data);
		}
	})
}
//加载审核信息
function listReviewUserPage(data){
	var tbody = $("#tbody_id");
	tbody.empty();
	for(var i in data){
		var tr = "<tr>" +
				"<td><input type='hidden' class='reviewId' value='"+data[i].id+"' />" +
				data[i].userName +
				"</td>" +
				"<td>"+data[i].nickName+"</td>" +
				"<td>"+data[i].currentRoleName+"</td>" +
				"<td>"+data[i].applyRoleName+"</td>" +
				"<td>"+data[i].createdTime+"</td>" +
				"<td>"+(data[i].state==1?"已通过":"未通过")+"</td>" +
				"<td>" +
				"<a href='javascript:void(0)' onclick='doApproveUser(this)' >批准</a>" +
				"</td>" +
				"</tr>";
		tbody.append(tr);
	}
}
//批准操作
function doApproveUser(btn){
	var reviewId = $(btn).parent().parent().find(".reviewId").val();
	console.log("reviewId="+reviewId);
	var url = "toApproveUserReview.do";
	var param = {"id":reviewId};
	$.psot(url,param,function(result){
		if(result.state){
			alert("批准成功!");
		}else{
			alert(result.message);
		}
		
	});
}





