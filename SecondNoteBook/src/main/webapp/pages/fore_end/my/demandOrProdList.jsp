<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
$(document).ready(function(){
	releaseProd();
})
//发布的商品页面
function releaseProd(){
	$("#t1").className="active";
	$("#t2").className="";
	var url = "toGetProdPage.do";
	$(".panel-body").load(url);
}
//发布的需求单页面
function releaseDemand(){
	$("#t2").className="active";
	$("#t1").className="";
	var url = "toGetDemandPage.do";
	$(".panel-body").load(url);
}
</script>
<div class="panel panel-default">
    <div class="panel-heading">
        <ul class="nav nav-tabs">
	<li id="t1" class=""><a href="javascript:void(0);" onclick="releaseProd()">商品列表</a></li>
	<li id="t2" class=""><a href="javascript:void(0);" onclick="releaseDemand()">需求列表</a></li>
	</ul>
    </div>
    <div class="panel-body">
	
	</div>
	
</div>
