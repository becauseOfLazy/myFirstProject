<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<link href="${basePath}/static/css/web_chat/sendMessage.css" rel="stylesheet" type="text/css">
	<!-- Jquery -->
	<script src="${basePath}/static/jquery/jquery-3.2.1.min.js"></script>
	<!-- bootsrap -->
	<link rel="stylesheet" href="${basePath}/static/bootstrap/css/bootstrap.min.css">  
	<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
	<script src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
<style>

</style>
<script type="text/javascript" src="${basePath}/static/js/web_chat/main.js"></script>

<div class="container">
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
			<div style="float: right;padding-right: 90px;">
			<a href="${basePath}/fore_end/toIndex.do">退出聊天室</a>
			</div>
		</div>
		
	</div>
   <div class="jumbotron">
         <h1>欢迎登录web在线多人聊天页面！</h1>
        <p>Welcome to the web online multiplayer chat page!</p>
    </div>
    <div class="row">
        <div class="col-xs-3" id="myScrollspy">
			<div class="panel panel-info box_div" style="width:250px;height:600px;">
				<div class="panel-heading">
					<h3 class="panel-title">聊天面板</h3>
				</div>
				<div class="panel-body" >
					<ul class="nav nav-tabs" style="width:230px;">
						<li id="t1" class=""><a href="javascript:void(0);" onclick="contactsList()">联系人</a></li>
						<li id="t2" class=""><a href="javascript:void(0);" onclick="groupsList()">联系群</a></li>
						<li id="t3" class=""><a href="javascript:void(0);" onclick="addOrCreatedContact()">添加</a></li>
					</ul>
					<div id="bodycontact-id">
						
					</div>
				</div>
				<div class="foot_div">
					<ul class="pager" id="page_id">
					    <li class="previous"><a href="javascript:void(0);" onclick="nextPage()">&larr;上一页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <li class="next"><a href="javascript:void(0);" onclick="previousPage()" >下一页 &rarr;</a></li>
					</ul>
				</div>
				
			</div>
        </div>
		
        <div class="col-xs-9" id="messageBody_id">
            
        </div>
    </div>
</div>