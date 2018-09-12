$(document).ready(function(){
	doGetOderList();
})
//加载订单列表信息
function doGetOderList(){
	var url = "toGetOrderlist.do";
	$.post(url,function(result){
		if(result.state){
			listOrderListpage(result.data);
		}else{
			$("#index").load("toNoInfo.do");	
		}
	});
}
//确认订单
function doConfimOrder(btn){
	var orderId = $(btn).parent().data("orderId");
	var url = "doConfimOrder.do";
	var param ={"orderId":orderId};
	$.post(url,param,function(result){
		if(result.state){
			doGetOderList();
		}
	})
}
//显示订单页面
function listOrderListpage(datas){
	var tbody = $("#bodydiv_id");
	tbody.empty();
	var sumMoney = 0;
	for(var i in datas){
		var allPrice = 0;
		var orderId;
		var createdTime;
		var address ;
		var ttable = $("<table width='1200' border='0' cellpadding='0'" +
		"cellspacing='1' style='background:#d8d8d8;color:#333333'>" +
		"</table>");
		var tr1 = "<tr>" +
					"<th width='276' height='30' align='center' valign='middle' bgcolor='#f3f3f3'>商品图片</th>" +
					"<th width='247' align='center' valign='middle' bgcolor='#f3f3f3'>商品名称</th>" +
					"<th width='231' align='center' valign='middle' bgcolor='#f3f3f3'>商品单价</th>" +
					"<th width='214' align='center' valign='middle' bgcolor='#f3f3f3'>购买数量</th>" +
					"<th width='232' align='center' valign='middle' bgcolor='#f3f3f3'>总价</th>" +
				"</tr>";
		ttable.append(tr1);
		for(var j in datas[i]){
			orderId = datas[i][j].orderId;
			createdTime = datas[i][j].createdTime;
			address = datas[i][j].address;
			price = Number(datas[i][j].prodPrice);

			var trs = "<tr>" +
						"<td align='center' valign='middle' bgcolor='#FFFFFF'>" +
						"<img src='"+datas[i][j].imgUrl+"' width='90' height='105'>" +
						"</td>" +
						"<td align='center' valign='middle' bgcolor='#FFFFFF'>"+datas[i][j].prodName+"</td>" +
						"<td align='center' valign='middle' bgcolor='#FFFFFF'>"+datas[i][j].prodPrice+"</td>" +
						"<td align='center' valign='middle' bgcolor='#FFFFFF'>1</td>" +
						"<td align='center' valign='middle' bgcolor='#FFFFFF'>"+price+"</td>" +
					"</tr>";
			ttable.append(trs);
			allPrice += price;
		}
		var tdl = "<input class='orderId' type='hidden' value='"+orderId+"' />" +
				"<dl class='Order_information'>" +
					"<dt><h3>订单信息</h3></dt>" +
					"<dd style='line-height: 26px;'>" +
					"订单编号："+orderId+"<br />" +
					"下单时间："+createdTime+"<br /> " +
					"订单金额："+allPrice+"<br /> " +
					"支付状态：" +
					"<font color='red'>未支付</font>&nbsp;&nbsp;|&nbsp;" +
					"<font color='blue'>已支付</font>&nbsp;" +
					"<a href=''>" +
					"<img src='' width='69' height='19'/>" +
					"</a>&nbsp;<a href=''><img src='' width='69' height='19'>" +
					"</a><br /> " +
					"所属用户：xxx<br/> " +
					"收货地址："+address+"<br/> " +
					"支付方式：在线支付" +
					"</dd>" +
					"</dl>";
		
		tbody.append(tdl);
		tbody.append(ttable);
		var tprice = $("<div class='Order_price'>总金额："+allPrice+"&nbsp;&nbsp;" +
					"<button type='button' class='btn btn-default bt-ok' onclick='doConfimOrder(this)' >确认收货</button>" +
				"</div>");
		tprice.data("orderId",orderId);
		tbody.append(tprice);
		
	}
	
	
}