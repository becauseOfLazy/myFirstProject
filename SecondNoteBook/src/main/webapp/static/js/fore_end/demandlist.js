$(document).ready(function(){
	doLoadDemandPage();
})
//加载需求单列表
function doLoadDemandPage(){
	var pageCurrent = $("#page-Id").data("pageCurrent");
	if(pageCurrent==null){
		pageCurrent = 1;
		$("#page-Id").data("pageCurrent",1);
	}
	var url = "toLoadDemandPageObject.do";
	var param = {"pageCurrent":pageCurrent};
	$.post(url,param,function(result){
		if(result.state){
			console.log(result.data.pageCount);
			console.log(result.data.lists);
			$("#page-Id").data("pageCount",result.data.pageCount);
			toListDemandPage(result.data.lists);
			toUpdatePageObject();
		}
	});
	
}
//显示需求单数据
function toListDemandPage(data){
	var tbody = $("#demand_id");
	tbody.empty();
	for(var i in data){
		var tr = "<tr><td><input type='hidden' class='demandIdClss' value='"+data[i].id+"' />"+data[i].prodName+"</td>" +
				"<td>"+data[i].minPrice+"</span>-<span>"+data[i].maxPrice+"</td>" +
				"<td>"+data[i].beginTime+"</td>" +
				"<td>"+(data[i].payType==1?"在线交易":(data[i].payType==2?"线下交易":"物品交换"))+"</td>" +
				"<td>"+data[i].phoneNumber+"</td>" +
				"<td><button type='button' class='btn btn-link' onclick='addDemandToCart(this)'>添加关注</button></td>" +			
				"</tr>";
		tbody.append(tr);
	}
}
//修改分页数据
function toUpdatePageObject(){
	var pageCount = $("#page-Id").data("pageCount");
	pageCount = Number(pageCount);
	var pageCurrent = $("#page-Id").data("pageCurrent");
	pageCurrent = Number(pageCurrent);
	var tpage = $("#page-Id");
	tpage.empty();
	tpage.append("<li><a href='#'>&laquo;</a></li>");
	for(var i=1;i<=pageCount;i++){
		var li;
		if(pageCurrent == i){
			li = "<li class='active'><a href='#'>"+i+"</a></li>"
		}
		li = "<li><a href='#'>"+i+"</li>";
		tpage.append(li);
	}
	tpage.append("<li><a href='#'>&raquo;</a></li>");
}
//添加需求单到购物车中
function addDemandToCart(btn){
	var id = $(btn).parent().parent().find(".demandIdClss").val();
	console.log(id);
	var url = "toAddDemandToCart.do";
	var param = {"id":id};
	$.post(url,param,function(result){
		console.log(result);
		if(result.state){
			alert("添加成功")
		}else{
			alert(result.message);
		}
	})
}
//获取日期
function onSelect1(date){
	var beginDate = date.getFullYear()+'/'+(date.getMonth()+1)+'/'+date.getDate();
	$("#search_form").data("beginDate",beginDate);
}
function onSelect2(date){
	var endDate = date.getFullYear()+'/'+(date.getMonth()+1)+'/'+date.getDate();
	$("#search_form").data("endDate",endDate);
}
//需求单查询
function doSearchDemand(){
	var beginDate = $("#search_form").data("beginDate");
	var endDate = $("#search_form").data("endDate");
	var buyType = $("#id_buyType option:selected").val();
	var searchName = $(".search_name").val();
	var url = "toSearchDemandObject.do";
	var param = {"buyType":buyType,"searchName":searchName,
			"beginDate":beginDate,"endDate":endDate};
	$("#page-Id").data("pageCurrent",1);
	console.log(param);
	$.post(url,param,function(result){
		console.log(result.message);
		if(result.state){
			console.log(result.data.pageCount);
			console.log(result.data.lists);
			$("#page-Id").data("pageCount",result.data.pageCount);
			toListDemandPage(result.data.lists);
			toUpdatePageObject();
		}
	})
}














