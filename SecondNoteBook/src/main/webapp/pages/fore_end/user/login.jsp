<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${basePath}/static/css/login.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/default/easyui.css">
	    <link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/icon.css">
	    <link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/demo/demo.css">
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.min.js"></script>
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${basePath}/static/js/fore_end/login.js"></script>
		<title>欢迎您登陆</title>
	</head>
	<body>
		<h1>欢迎登陆</h1>
		<form id="login-form" method="POST">
			<table>
				<tr>
					<td class="tdx">用户名：</td>
					<td><input type="text" id="usernameId" placeholder="请输入您的用户名" name="userName" /></td>
				</tr>
				<tr>
					<td class="tdx">密&nbsp;&nbsp; 码：</td>
					<td><input type="password" id="passwordId" placeholder="请输入您的密码" name="password" ></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="remname" value="true"/>记住用户名
						<input type="checkbox" name="autologin" value="true"/>30天内自动登陆
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input class="button_login" type="submit" value="登录"/>
					</td>
				</tr>
			</table>
		</form>		
	</body>
</html>
