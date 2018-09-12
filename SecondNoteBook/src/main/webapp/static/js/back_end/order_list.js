$(document).ready(function(){
	  doGetObjects();
	 $("#queryFormId").on("click",".btn-search",doQueryObjects);
	 $("#modal-dialog").on("click",".ok",doPrimaryBtn);
	 $("#modal-dialog").on("hidden.bs.modal",function(){
		   $("#modal-dialog").off("click",".btn-primary");
		   $("#modal-dialog").removeData("orderId");
		   doGetObjects();
	   });
});
/**条件查询商品*/
function doQueryObjects(){
	var key = $("#searchNameId").val();
	var status = $("#searchValidId").val();
	
	var url = "doSearchOrderObject.do";
	var param = {"key":key,"status":status};

	$.post(url,param,function(result){
		if(result.state){
			setTableBodyRows(result.data);
		}else{
			alert(result.message);
			doGetObjects();
		}
	})
}
//确认后隐藏
function doPrimaryBtn(){
	$("#modal-dialog").modal("hide");
}
//获取商品的详情
function doGetOrderInfo(btn){
	var orderId = $(btn).parent().parent().data("orderId");
	$("#modal-dialog").data("orderId",orderId);
	$(".modal-title").html("订单"+orderId+"内容");
	$(".ok").text("确认");
	$(".btn-default").text("取消");
	$("#modal-dialog").modal("show");
	$("#myModal").on("show.bs.modal",doListOrderInfo());
}
//模态框显示后执行
function doListOrderInfo(){
	var url = "toGetOrderInfoPage.do";
	$("#modal-dialog .modal-body").load(url);
}

/*获取项目信息*/
function doGetObjects(){
	//获取当前页的页码值,假如没有值,默认值设置为1
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	var param = {"pageCurrent":pageCurrent};
	var url="toGetOrderObjects.do";
	var pageObject = {"pageCurrent":pageCurrent};
	
	//发起异步请求获取服务端数据
	$.post(url,param,function(result){//callback method
		if(result.state){
			var pageObject = result.data.page;
			var lists = result.data.lists;
			//设置分页
			setPagination(pageObject);
			//加载显示内容
			setTableBodyRows(lists);
		}
		
	});
}
/*将数据填充在table对象的body中*/
function setTableBodyRows(data){
	 var tBody=$("#tbodyId");
	 tBody.empty();
	 for(var i in data){
		 var tr=$("<tr></tr>");
		 tr.data("orderId",data[i].orderId);
		 console.log(i);
		 var tds="<td><input type='checkbox' name='checkId' value='"+data[i].orderId+"'></td>"+
		 		 "<td>"+data[i].orderId+"</td>"+
				 "<td>"+data[i].uId+"</td>"+
				 "<td>"+data[i].createdTime+"</td>"+
				 "<td>"+data[i].cancelTime+"</td>"+
		         "<td>"+(data[i].buyType==1?"在线交易":(data[i].buyType==2?"线下交易":"物品交换"))+"</td>"+
		         "<td>"+(data[i].status==1?"已付款" +
		         "":(data[i].status==2?"未付款" +
		         "":(data[i].status==3?"已失效" +
		         "":(data[i].status==4?"未设置" +
		         "":(data[i].status==5?"待签收" +
		         "":"已签收")))))+"</td>"+
		         "<td><button type='button' class='btn btn-default bt-orderInfo' onclick='doGetOrderInfo(this)'>详情</button></td>";
		 tr.append(tds);
		 tBody.append(tr);
	 }
}
