$(document).ready(function(){
	doGetMyProdListPage();
	$("#t_bodyId").on("click",".btModel",doProdInfo);
	$('#identifier').on('hide.bs.modal', function () {
		$("#myModal").off("click",".btn-primary");
		$("#myModal").removeData("id");
	});
})
//查看商品详情
function doProdInfo(){
	var id = $(this).parent().parent().find(".prodId").val();
	$("#myModal").data("id",id);
	$(".modal-title").html("商品详情");
	$("#myModal").modal("show");
	$("#myModal").on("show.bs.modal",doGetProdInfo());
}

//加载商品信息
function doGetProdInfo(){
	var url = "toLoadEditMyProdPage.do";
	$(".modal-body").load(url);
}
//加载我的商品页面
function doGetMyProdListPage(){
	var url = "doGetMyProdObject.do";
	$.post(url,function(result){
		if(result.state){
			doSetMyProdPage(result.data);
		}
	})
}
//显示商品信息
function doSetMyProdPage(data){
	var tbody = $("#t_bodyId");
	tbody.empty();
	for(var i in data){
		var tr = "<tr>" +
					"<td>" +
					"<input type='hidden' class='prodId' value='"+data[i].id+"'>"+
					"<img src='"+data[i].imgUrl+"' width='90' height='90' class='prodimg' />" +
					"</td>" +
					"<td>"+data[i].prodName+"</td>"+
					"<td>"+data[i].prodPrice+"</td>"+
					"<td>"+(data[i].buyType==1?"在线竞拍":(data[i].buyType==2?"线下交易":"物品转换"))+"</td>"+
					"<td>"+(data[i].valid?"已上架":"已下架")+"</td>"+
					"<td>" +
					"<a class='btModel'  href='javascript:void(0)' >详情</a></td>"+
					
				"</tr>";
		tbody.append(tr);
	}
	
}