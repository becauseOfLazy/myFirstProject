<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$(document).ready(function(){
		noSetOrder();
	})
	//未设置订单页面
	function noSetOrder(){
		var url = "toGetAllNoSetOrderPage.do";
		$("#bodydiv_id").load(url);
	}
	//未付款订单页面
	function noPayOrder(){
		var url = "toGetAllNoPayOrderPage.do";
		$("#bodydiv_id").load(url);
	}
	//已付款订单页面
	function yesPayOrder(){
		var url = "toGetAllYesPayOrderPage.do";
		$("#bodydiv_id").load(url);
	}
	//已撤单订单页面
	function cancelOrder(){
		var url = "toGetAllCancelOrderPage.do";
		$("#bodydiv_id").load(url);
	}
</script>
<div class="panel panel-default">
    <div class="panel-heading">
       <ul class="nav nav-tabs">
		<li id="t1" class=""><a href="javascript:void(0);" onclick="noSetOrder()">未设置</a></li>
		<li id="t2" class=""><a href="javascript:void(0);" onclick="noPayOrder()">未付款</a></li>
	    <li id="t2" class=""><a href="javascript:void(0);" onclick="yesPayOrder()">已付款</a></li>
	    <li id="t2" class=""><a href="javascript:void(0);" onclick="cancelOrder()">已撤单</a></li>
	   </ul>
    </div>
    <div class="panel-body">
	    <!-- 模版数据 -start -->
		<div id="bodydiv_id" style="margin: 0 auto;width:1200px;">
			
		</div>
		
		<!-- 模版数据 -end -->
    </div>
</div>
	

