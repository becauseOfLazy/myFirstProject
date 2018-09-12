$(document).ready(function(){
	doGetprodList();
	$("#prod_content").on("click",".click_img",doProdInfo)
	.on("click",".addCart",addCart);
	$("#search_form").on("click",".search_btn",doSearchProdByBtn);
	$("#Jpager").on("click",".page-prev",doJpagerPrev)
	.on("click",".page-next",doJpagerNext)
	.on("click",".page-jump",doSubmitJpager)
	
})
//跳转前一页
function doJpagerPrev(){
	var pageCurrent = $(".page-current").text();
	//console.log("pageCurrent="+pageCurrent);
	if(pageCurrent>1){
		pageCurrent--;
		$(".page-current").text(pageCurrent);
		doGetprodList();
	}
}
//跳转后一页
function doJpagerNext(){
	var pageCurrent = $(".page-current").text();
	var pageCount = $(".page-Counter").text();
	//console.log("pageCurrent="+pageCurrent);
	if(pageCurrent<pageCount){
		pageCurrent++;
		$(".page-current").text(pageCurrent);
		doGetprodList();
	}
}
//跳转指定页
function doSubmitJpager(){
	var pointPage = $("#page-transform-number").val();
	var pageCount = $(".page-Counter").text();
	if(pointPage>=1 && pointPage<=pageCount){
		$(".page-current").text(pointPage);
		doGetprodList();
	}
}
//根据条件查询商品
function doSearchProdByBtn(){
	var buyType = $("#id_buyType option:selected").val();
	var prodType = $(".search_type").val(); 
	var minprice = $(".search_minprice").val();
	var maxprice = $(".search_maxprice").val();
	var param = {"buyType":buyType,"prodType":prodType,
			"minPrice":minprice,"maxPrice":maxprice};
	console.log(param);
	var url = "toSearchProdByHot.do";
	$.post(url,param,function(result){
		if(result.state){
			var pageCount = result.data.pageCount;
			$(".page-Counter").text(pageCount);
			$("#index").data("pageCount",result.data.pageCount);
			doListProdPage(result.data.lists);
		}
	})
}
//获取商品信息
function doGetprodList(){
	var searchName = $("#index").data("keyName");
	if(searchName){
		var url = "toSearchProdlistByKey.do";
		$("#index").data("keyName",null);
	}else{
		var url = "togetProdList.do";
	}
	var pageCurrent = $(".page-current").text();
	if(!pageCurrent){
		pageCurrent = 1;
	}
	var param = {"searchName":searchName};
	param.pageCurrent = pageCurrent;
	$.post(url,param,function(result){
		console.log(result);
		if(result.state){
			var page = result.data.page;
			$(".page-Counter").text(page.pageCount);
			$("#index").data("pageCount",page.pageCount);
			doListProdPage(result.data.lists);
		}
	});
}
//加载商品信息
function doListProdPage(data){
	var tbody = $("#prod_content");
	//console.log(data)
	//清空
	tbody.empty();
	//遍历填充商品信息
	for(var i in data){
		var tr = $("<tr class='prod_div'></tr>");
		var tds = 
				"<div class='click_img'>" +
					"<input type='hidden' class='prod_id' value='"+data[i].id+"'/>" +
					"<img class='prod_img' src='"+data[i].imgUrl+"'>" +
				"</div>" +
				"<div id='prod_name_div'>'"+data[i].prodName+"'</div>" +
				"<div id='prod_price_div'>￥"+Number(data[i].prodPrice)+"元</div>" +
				"<div>" +
					"<div id='gotocart_div'>" +
						"<a class='addCart' href='javascript:void(0)'>加入购物车</a>" +
					"</div>" +
					"<div id='say_div' class='atten_div'>" +data[i].attenNum+"人关注" +
					"</div>" +
				"</div>";
		tr.append(tds);
		tbody.append(tr);
	}
}
//添加商品于购物车
function addCart(){
	var url = "toAddProdToCart.do";
	var param = {"prodId":$(this).parent().parent().parent().find(".prod_id").val()}
	$.post(url,param,function(result){
		if(result.state){
			alert("加入购物车成功");
		}else{
			alert(result.message);
			setTimeout(window.location.href="toLogin.do",3000);
		}
	});
}
//点击查看商品详情
function doProdInfo(){
	var prodId = $(this).find(".prod_id").val();
	$("#index").data("prodId",prodId);
	var url = "toProdInfoPage.do";
	$("#index").load(url);
}
//选择商品类型
function selectType(btn){
	$(btn).parent().parent().find(".active").removeClass("active");
	$(btn).addClass("active");
	$("#select-tableId").data("prodType",$(btn).text());
	doSearchProd();
}
//选择商品价格
function selectPrice(btn){
	$(btn).parent().parent().find(".active").removeClass("active");
	$(btn).addClass("active");
	$("#select-tableId").data("prodPrice",$(btn).text());
	doSearchProd();
}
//选择商品交易类型
function selectBuyType(btn){
	$(btn).parent().parent().find(".active").removeClass("active");
	$(btn).addClass("active");
	$("#select-tableId").data("buyType",$(btn).text());
	doSearchProd();
}
//查询商品通过热门词
function doSearchProd(){
	var prodType = $("#select-tableId").data("prodType");
	var prodPrice = $("#select-tableId").data("prodPrice");
	var buyType = $("#select-tableId").data("buyType");
	console.log(prodType+","+prodPrice+","+buyType);
	var minPrice;
	var maxPrice;
	if(prodType==null){
		prodType="";
	}
	if(prodPrice!=null && prodPrice!=""){
		var strArr = prodPrice.split("-");
		 minPrice = strArr[0];
		 maxPrice = strArr[1];
	}else{
		minPrice="0";
		maxPrice="0";
	}
	var buyTypeId;
	if(buyType=="在线交易"){
		buyTypeId = 1;
	}else if(buyType=="线下交易"){
		buyTypeId = 2;
	}else if(buyType=="物品交换"){
		buyTypeId = 3;
	}else{
		buyTypeId = 0;
	}
	var param = {"prodType":prodType,"minPrice":minPrice,"maxPrice":maxPrice,"buyType":buyTypeId};
	//console.log(param);
	var url = "toSearchProdByHot.do";
	$.post(url , param , function(result){
		if(result.state){
			var pageCount = result.data.pageCount;
			$(".page-Counter").text(pageCount);
			$("#index").data("pageCount",result.data.pageCount);
			doListProdPage(result.data.lists);
		}
	});
}


