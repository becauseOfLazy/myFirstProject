<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
$(document).ready(function(){
	//默认商品购物车页面
	prodCart();
})
function prodCart(){
	$("#t1").className="active";
	$("#t2").className="";
	var url = "toGetProdCartPage.do";
	$(".panel-body").load(url);
}
function demandCart(){
	$("#t2").className="active";
	$("#t1").className="";
	var url = "toGetDemandCartPage.do";
	$(".panel-body").load(url);
}
</script>
<div class="panel panel-default">
    <div class="panel-heading">
        <ul class="nav nav-tabs">
	<li id="t1" class=""><a href="javascript:void(0);" onclick="prodCart()">商品关注列表</a></li>
	<li id="t2" class=""><a href="javascript:void(0);" onclick="demandCart()">需求关注列表</a></li>
	</ul>
    </div>
    <div class="panel-body">
	
	</div>
	
</div>
