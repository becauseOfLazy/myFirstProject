$(document).ready(function(){
	doListMyDemandPage();
})
function doListMyDemandPage(){
	var url = "toGetAllMyDemandObject.do";
	$.post(url,function(result){
		if(result.state){
			listDemandObject(result.data);
		}
	})
}
function listDemandObject(data){
	var tbody = $("#t_bodyId");
	tbody.empty();
	for(var i in data){
		var tr = "<tr>" +
		"<td>" +
		"<input type='hidden' class='demandId' value='"+data[i].id+"'>"+data[i].prodType+
		"</td>" +
		"<td>"+data[i].prodName+"</td>"+
		"<td><span>"+data[i].minPrice+"</span>-<span>"+data[i].maxPrice+"</span></td>"+
		"<td>"+(data[i].payType==1?"在线竞拍":(data[i].payType==2?"线下交易":"物品转换"))+"</td>"+
		"<td>"+data[i].phoneNumber+"</td>"+
		"<td>" +
		"<a href='javascript:void(0)' onclick='doGetDemandInfo(this) '>详情</a>&nbsp;&nbsp;"+
		"<a href='javascript:void(0)' onclick='doDeleteDemand(this) '>删除</a></td>"+
	"</tr>";
		tbody.append(tr);
	}
}
function doGetDemandInfo(btn){
	var demandId = $(btn).parent().parent().find(".demandId").val();
	$("#myModal").data("demandId",demandId);
	//console.log("demandId="+demandId);
	$(".modal-title").html("需求单详情");
	$("#myModal").modal("show");
	$("#myModal").on("show.bs.modal",doLoadEditDemandInfo());
}
function doLoadEditDemandInfo(){
	var url = "toLoadEditDemandPage.do";
	$(".modal-body").load(url);
}
function doDeleteDemand(btn){
	var demandId = $(btn).parent().parent().find(".demandId").val();
	var param = {"demandId":demandId};
	var url = "toDeleteMyDemand.do";
	$.post(url,param,function(result){
		if(result.state){
			alert("删除成功！");
			doListMyDemandPage();
		}else{
			alert(result.message);
		}
	})
}