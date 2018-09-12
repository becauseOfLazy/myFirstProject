<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />

<div id="common_head" style="margin: auto">
	<div id="line1">
		<div id="content">
			<shiro:guest> 
				<a href="${basePath}/fore_end/toLogin.do">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${basePath}/fore_end/toRegiste.do">注册</a>
			</shiro:guest>
			<shiro:user>
				<a href="${basePath}/fore_end/toSetUser.do">${nickName }</a> &nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="${basePath}/fore_end/logout">退出</a>
			</shiro:user>
			<div style="float: right;">
			<a href="${basePath}/web_chat/toWebChatPages.do">进入聊天室</a>
		</div>
		</div>
		
	</div>
	
	<div id="line2">
		<img id="logo" width="224" height="34" src="${basePath}/static/img/head/logo.png"/>
		<input type="text" id="keyName_Id" placeholder="请输入商品名称..." name="searchName" />
		<button type="button" class="btn btn-default" onclick="doSearch(this)">搜索</button>
		
		<img id="erwm" width="76" height="76" src="${basePath}/static/img/head/vx.png"/>
	</div>
	<div id="line3">
		<div id="content">
			<ul>
				<li><a id="load-main-id">首页</a></li>
				<li><a id="load-product-id">商品列表</a></li>
				<li><a id="load-demand-id">需求单列表</a></li>
				<li><a id="load-cart-id">我的关注</a></li>
				<li><a id="load-order-id">我的订单</a></li>
				<li><a id="load-myProduct-id">我的发布</a></li>
				<li><a id="load-shelve-id">发布</a></li>
				<li><a id="load-regVip-id">注册会员</a></li>
				<li><a id="load-board-id">留言板</a></li>
				<li><a id="load-back-end-id">后台登录</a></li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
//查询商品
function doSearch(btn){
	
	var keyName = $("#keyName_Id").val();
	if(keyName=="" || keyName==null){
		alert("请输入信息");
		return;
	}
	
	$("#index").data("keyName",keyName);
	var url="toProdlistPage.do?t="+Math.random(1000);
	$("#index").load(url);
}
//加载主页信息
$('#load-main-id').click(function(){
	var url="toMain.do?t="+Math.random(1000);
	$("#index").load(url);
})
//加载商品列表信息
$('#load-product-id').click(function(){
	var url="toProdlistPage.do?t="+Math.random(1000);
	$("#index").load(url);
})
//加载需求单列表信息
$('#load-demand-id').click(function(){
	var url="toDemandlistPage.do?t="+Math.random(1000);
	$("#index").load(url);
})
//加载购物车信息
$('#load-cart-id').click(function(){
	var url="toCartPage.do?t="+Math.random(1000);
	$("#index").load(url,function(result){
		var res = JSON.parse(result); 
		if(res.state==0){
			alert(res.message);
			setTimeout(window.location.href="${basePath}/fore_end/toLogin.do",3000);
		}
	});
})
//加载订单列表信息
$('#load-order-id').click(function(){
	var url="toOrderListPage.do?t="+Math.random(1000);
	$("#index").load(url,function(result){
		var res = JSON.parse(result); 
		if(res.state==0){
			alert(res.message);
			setTimeout(window.location.href="${basePath}/fore_end/toLogin.do",3000);
		}
	});
})
//加载我的发布
$('#load-myProduct-id').click(function(){
	var url="toMyProdListPage.do?t="+Math.random(1000);
	$("#index").load(url,function(result){
		var res = JSON.parse(result); 
		if(res.state==0){
			alert(res.message);
			setTimeout(window.location.href="${basePath}/fore_end/toLogin.do",3000);
		}
	});
})
$('#load-shelve-id').click(function(){
	var url="toShelve_Prod.do?t="+Math.random(1000);
	$("#index").load(url,function(result){
		var res = JSON.parse(result); 
		if(res.state==0){
			alert(res.message);
			setTimeout(window.location.href="${basePath}/fore_end/toLogin.do",3000);
		}
	});
})
$('#load-regVip-id').click(function(){
	var url="toRegistVip.do?t="+Math.random(1000);
	$("#index").load(url,function(result){
		var res = JSON.parse(result); 
		if(res.state==0){
			alert(res.message);
			setTimeout(window.location.href="${basePath}/fore_end/toLogin.do",3000);
		}
	});
})
$('#load-board-id').click(function(){
	var url="toMessageBorad.do?t="+Math.random(1000);
	$("#index").load(url,function(result){
		var res = JSON.parse(result); 
		if(res.state==0){
			alert(res.message);
			setTimeout(window.location.href="${basePath}/fore_end/toLogin.do",3000);
		}
	});
})
$('#load-back-end-id').click(function(){
	var url="toBackEndIndex.do?t="+Math.random(1000);
	$.post(url,function(res){
		if(res.state==0){
			alert(res.message);
		}else{
			window.location.href="${basePath}/back_end/toIndex.do";
		}
	});
})
</script>