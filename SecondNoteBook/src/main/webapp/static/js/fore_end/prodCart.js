$(document).ready(function(){
	doGetCartList();
	$("#wrap").on("click",".allC",checkAll)
	.on("click","#goto_order",submitCart)
	.on("click",".delProd",delProd)
	.on("click",".getProd",getProd)
	.on("click","#del_a",delProdBySelect)
})

//全选商品
function checkAll(){
	if(this.checked){
		$("#wrap :checkbox").prop("checked",true);
		
	}else{
		$("#wrap :checkbox").prop("checked",false);
		
	}
}
//查看商品详情
function getProd(){
	var prodId = $(this).parent().parent().find(".prodId").val();
	$("#index").data("prodId",prodId);
	var url = "toProdInfoPage.do";
	$("#index").load(url);
}
//删除选中商品
function delProd(){
	if(!$(this).parent().parent().find(".allCp").prop("checked")){
		alert("请先勾选商品，再删除！");
		return;
	}
	var url = "toDelProdBySelect.do";
	var prodId = $(this).parent().parent().find(".prodId").val();
	var param = {"prodId":prodId};
	$.post(url,param,function(result){
		if(result.state){
			alert("删除成功");
			doGetCartList();
		}else{
			alert(result.message);
		}
	})
}
//删除所选择的商品
function delProdBySelect(){
	var prodIds = "";
	$('.prods input[name="checkP"]:checked').each(function(){
		if($(this).prop("checked")){
			if(prodIds==""){
				prodIds += $(this).parent().parent().find(".prodId").val();
			}else{
				prodIds += ","+$(this).parent().parent().find(".prodId").val();
			}	
		}
	});
	if(prodIds==""){
		alert('你还没有选择任何内容！');
		return;
	}
	console.log(prodIds);
	var url = "toDelProdBySelect.do";
	var param = {"prodIds":prodIds}
	$.post(url,param,function(result){
		if(result.state){
			alert("删除所选商品成功");
			doGetCartList();
		}else{
			alert(result.message);
		}
	})
}
//提交选中商品
function submitCart(){
	var prodIds = "";
	$('.prods input[name="checkP"]:checked').each(function(){
		if($(this).prop("checked")){
			if(prodIds==""){
				prodIds += $(this).parent().parent().find(".prodId").val();
			}else{
				prodIds += ","+$(this).parent().parent().find(".prodId").val();
			}	
		}
	});
	if(prodIds==""){
		alert('你还没有选择任何内容！');
		return;
	}
	var url = "toSubmitCartProd.do";
	var param = {"prodIds":prodIds};
	console.log(param)
	$.post(url,param,function(result){
		if(result.state){
			alert("提交商品成功");
			$("#index").load("toOrderSetPage.do");
		}
	});
}
//异步加载商品
function doGetCartList(){
	var url = "toGetCartList.do";
	$.post(url,function(result){
		if(result.state){
			doListProd(result.data);
		}else{
			$("#index").load("toNoInfo.do");
		}
	});
	
}
//列出所有购物车的物品
function doListProd(data){
	var tdiv = $("#wrap");
	tdiv.empty();
	
	var ttitle = "<ul id='title'>" +
					"<li>" +
					"<input class='allC' name='allC' type='checkbox' value=''/>" +
					"<span id='title_checkall_text'>全选</span>" +
					"</li>" +
					"<li class='li_prod'>商品</li>" +
					"<li>单价</li>" +
					"<li>联系人</li>" +
					"<li>联系电话</li>" +
					"<li>操作</li>" +
					"</ul>";
	tdiv.append(ttitle);
	var tbody = $("<div id='prodInfo'></div>");
	var allMoney = 0;
	for(var i in data){
		var tli = "<ul class='prods'>" +
		"<li><input type='checkbox' class='allCp' name='checkP'/></li>" +
		"<li class='li_prod'>" +
			"<input type='hidden' id='prodId' class='prodId' name='prodId' value='"+data[i].id+"'>" +
			"<img src='"+data[i].imgUrl+"' width='90' height='90' class='prodimg' />"+
			"<span class='prodname'>"+data[i].prodName+"</span>" +
		"</li>" +
		"<li class='li_price'>"+data[i].prodPrice+"</li>" +
		"<li class='li_contact'>"+data[i].contactName+"</li>" +
		"<li class='li_phone'>"+data[i].phoneNumber+"</li>" +
		"<li>" +
		"<a class='getProd' href='javascript:void(0)'>详情</a>" +
		"&nbsp;&nbsp;" +
		"<a class='delProd' href='javascript:void(0)'>删除</a></li>" +
		"</ul>";
		tbody.append(tli);
		allMoney = allMoney + Number(data[i].prodPrice);
	}
	tdiv.append(tbody);
	var ttotal = "<div id='total'>" +
			"<div id='total_1'>" +
			"<input type='checkbox' class='allC' name='allC' /> " +
			"<span>全选</span>" +
			"<a id='del_a' href='javascript:void(0)'>删除选中的商品</a>" +
			"<div id='div_sum'>" +
			"<span id='span_1'>总价：</span>" +
			"<span>￥</span>" +
			"<span id='span_2' class='total_sum_price'>"+allMoney+"</span>" +
			"</div>" +
			"</div>" +
			"<div id='total_2'>	" +
			"<a id='goto_order' href='javascript:void(0)' >去结算</a>" +
			"</div>" +
			"</div>";
	tdiv.append(ttotal);
}




