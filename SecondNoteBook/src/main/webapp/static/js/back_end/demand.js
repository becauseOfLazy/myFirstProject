$(document).ready(function(){
	doGetObjects();
	$("#queryFormId").on("click",".btn-search",doSearchDemandObject);
})
//查询需求单对象
function doSearchDemandObject(){
	var searchName = $("#searchNameId").val();
	var valid = $("#searchValidId option:selected").val();
	var url = "toSearchDemandObject.do";
	var param = {"searchName":searchName,"valid":valid};
	console.log(param);
	$.post(url,param,function(result){
		if(result.state){
			toListPageObject(result.data);
		}
	})
}
//获取需求单列表页面数据
function doGetObjects(){
	var url = "toLoadDemandListObject.do";
	var pageCurrent = $('#pageId').data("pageCurrent");
	if(!pageCurrent){
		pageCurrent = 1;
	}
	$('#pageId').data("pageCurrent",pageCurrent);
	var param = {"pageCurrent":pageCurrent};
	$.post(url,param,function(result){
		if(result.state){
			var pageObject = result.data.page;
			var lists = result.data.lists;
			//设置分页
			setPagination(pageObject);
			//设置页面内容
			toListPageObject(lists);
		}
	})
}
//加载显示页面数据
function toListPageObject(data){
	var tbody = $("#tbodyId");
	tbody.empty();
	for(var i in data){
		var tr = "<tr>" +
				"<td><input type='checkbox' class='demand_Id' name='demandId' value='"+data[i].id+"'></td>" +
				"<td>"+data[i].prodName+"</td>" +
				"<td>"+data[i].beginTime+"</td>" +
				"<td>"+(data[i].buyType==1?"在线交易":data[i].buyType==2?"线下交易":"物品交换")+"</td>" +
				"<td>"+(data[i].status==1?"已发布":data[i].status==2?"暂停发布":"未发布")+"</td>" +
				"<td>" +
				"<a href='javascript:void(0)' onclick='doDelDemand(this)' >删除</a>" +
				"</td>" +
				"</tr>";
		tbody.append(tr);
	
	}
}

//删除需求单
function doDelDemand(btn){
	var id = $(btn).parent().parent().find(".demand_Id").val();
	var url = "toDelDemandObjectById.do";
	var param = {"id":id};
	console.log(param);
	$.post(url,param,function(result){
		if(result.state){
			alert("删除成功!");
			doGetObjects();
		}else{
			alert(result.message);
		}
	})
}






