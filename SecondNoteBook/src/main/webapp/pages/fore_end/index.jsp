<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<!-- Css -->
		<link href="${basePath}/static/css/index.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/static/css/head.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/static/css/main.css" rel="stylesheet" type="text/css">
		<link href="${basePath}/static/css/orderList.css" rel="stylesheet" type="text/css">
		<!-- Jquery -->
		<script src="${basePath}/static/jquery/jquery-3.2.1.min.js"></script>
		<!-- bootsrap -->
		<link rel="stylesheet" href="${basePath}/static/bootstrap/css/bootstrap.min.css">  
		<script src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
		<!-- EasyUI -->
		<link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/default/easyui.css">
	    <link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/icon.css">
	    <link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/demo/demo.css">
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.min.js"></script>
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
		
		<title>欢迎光临二手笔记本交易系统</title>
	</head>
	<body>
		<%@include file="head.jsp" %>
		<div id="index">
			<%@include file="main.jsp" %>
		</div>
		<%@include file="foot.jsp" %>
		<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					模态框（Modal）标题
				</h4>
			</div>
			<div class="modal-body">

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
	</body>
</html>
