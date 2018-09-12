$(document).ready(function(){
	getLoadProdInfoPage();
	$("#right_bottom")
	.on("click",".add_cart_but",form_Submit);
})
//加载商品信息页面
function getLoadProdInfoPage(){
	var url = "toGetProdInfo.do";
	var param = {"prodId":$("#index").data("prodId")};
	$.post(url,param,function(result){
		if(result.state){
			doLoadProdInfoPage(result.data);
		}
	});
}
//显示商品信息
function doLoadProdInfoPage(data){
	//console.log(data);
	var prodInfo = data.product;
	var prodImg = data.imgs;
	var left_top = $("#left_top");
	left_top.empty();
	var img = "<img src='"+prodImg.img_0+"'>";
	left_top.append(img);
	var left_bottom = $("#left_bottom");
	left_bottom.empty();
	var imgs = "<img id='lf_img' src='/SecondNoteBook/static/img/prodInfo/lf.jpg'/>" +
	"<img id='mid_img' src='"+prodImg.img_0+"' width='60px' height='60px'/>" +
	"<img id='rt_img' src='/SecondNoteBook/static/img/prodInfo/rt.jpg'/>";
	
	left_bottom.append(imgs);
	$("#prod_name").text(prodInfo.prodName);
	$("#prod_desc").text(prodInfo.title);
	$(".price_red").text(prodInfo.prodPrice);
	$(".contact_Name").text(prodInfo.contactName);
	$(".phone_Number").text(prodInfo.phoneNumber);
	$(".city_Name").text(prodInfo.city);
}

//添加商品于购物车
function form_Submit(){
	var url = "toAddProdToCart.do";
	var param = {"prodId":$("#index").data("prodId")};
	$.post(url,param,function(result){
		if(result.state){
			alert("加入购物车成功");
		}else{
			alert(result.message);
			setTimeout(window.location.href="toLogin.do",3000);
		}
	});
}







