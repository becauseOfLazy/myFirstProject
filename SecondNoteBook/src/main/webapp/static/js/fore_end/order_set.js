$(document).ready(function(){
	doSetOrderMessage();
	$("#oder_add_form").on("click",".add_order_but",add_order_but)
	.on("click",".cancel_order_but",cancel_order_but);
	$("#textarea").validatebox({
		 required: true,   
         missingMessage: '必须填写地址' 
	});
	
})
//异步获取要提交的订单信息
function doSetOrderMessage(){
	var url = "toGetSetOrderObject.do";
	$.post(url,function(result){
		if(result.state){
			$("#order_body").data("orderId",result.data.order.orderId);
			dolistOrderAddPage(result.data.lists);
		}
	});
}
//加载需要提交的订单
function dolistOrderAddPage(data){
	var t_body = $("#order_body");
	t_body.empty();
	var tr = "<tr>" +
				"<th width='276'>商品图片</th>" +
				"<th width='247'>商品名称</th>" +
				"<th width='231'>商品单价</th>" +
				"<th width='214'>购买数量</th>" +
				"<th width='232'>总价</th>" +
			"</tr>";
	t_body.append(tr);
	var sumPrice = 0;
	for(var i in data){
		var allPrice = Number(data[i].prodPrice);
		var trs = "<tr>" +
				"<td><img width='90' height='105' src='"+data[i].imgUrl+"'></td>" +
				"<td>"+data[i].prodName+"</td>" +
				"<td>"+data[i].prodPrice+"</td>" +
				"<td>1</td>" +
				"<td>"+allPrice+"</td>" +
				"</tr>";
		t_body.append(trs);
		sumPrice +=allPrice;
	}
	$('.Order_price').text('总价：'+sumPrice+'元');
}
//提交订单
function add_order_but(){
	var address = $("#textarea").val();
	if(address==''){
		alert("请填写地址");
		return;
	}
	var url = "toUpdateOrderStatus.do";
	var param = {"address":address,
			"orderId":$("#order_body").data("orderId")}
	$.post(url,param,function(result){
		if(result.state){
			alert("提价订单成功");
			$("#index").load("toOrderListPage.do?t="+Math.random(1000));
		}
	});
}
//取消订单
function cancel_order_but(){
	var url = "toCancelOrderObject.do";
	var param = {"orderId":$("#order_body").data("orderId")}
	$.post(url,param,function(result){
		if(result.state){
			alert("订单取消成功");
			$("#index").load("toCartPage.do?t="+Math.random(1000));
		}else{
			alert(result.message);
		}
	});
}




