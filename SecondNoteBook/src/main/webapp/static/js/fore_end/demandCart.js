$(document).ready(function(){
	doLoadPage();
})
//异步加载页面信息
function doLoadPage(){
	var url = "toGetDemandCartObject.do";
	$.post(url,function(result){
		if(result.state){
			console.log(result.data.lists);
			loadDemandCartPage(result.data.lists);
		}
	})
	
}
//显示页面信息
function loadDemandCartPage(data){
	var tbody = $("#demandBody_id");
	tbody.empty();
	for(var i in data){
		var tr = "<tr>" +
				"<td><input type='hidden' class='demand_Id' value='"+data[i].id+"'/>"+data[i].prodName+"</td>" +
				"<td>"+data[i].minPrice+"</span>-<span>"+data[i].maxPrice+"</td>" +
				"<td>"+(data[i].payType==1?"在线交易":(data[i].payType==2?"线下交易":"物品交换"))+"</td>" +
				"<td>"+data[i].beginTime+"</td>" +
				"<td><a href='javascript:void(0)' onclick='deleteDemand(this)' >删除</a</td>" +
				"</tr>";
		tbody.append(tr);
	}
	
}

//删除需求单
function deleteDemand(btn){
	var id = $(btn).parent().parent().find(".demand_Id").val();
	var url = "toDelDemandCartObject.do";
	var param = {"id":id};
	$.post(url,param,function(result){
		if(result.state){
			alert("删除成功!");
			doLoadPage();
		}else{
			alert(result.message);
		}
	})
}










