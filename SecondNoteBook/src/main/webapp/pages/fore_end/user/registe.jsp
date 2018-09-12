<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>欢迎注册</title>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="${basePath}/static/css/regist.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/default/easyui.css">
	    <link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/icon.css">
	    <link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/demo/demo.css">
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.min.js"></script>
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${basePath}/static/js/fore_end/registe.js"></script>
	</head>
	<body>
		<form id="registe-form" method="POST">
			<h1>欢迎注册二手笔记本交易系统</h1>
			<table>
				<tr>
					<td class="tds">用户名：</td>
					<td>
						<input type="text" id="usernameId" placeholder="请输入您的用户名" name="userName"/>
					</td>
				</tr>
				<tr>
					<td class="tds">密码：</td>
					<td>
						<input type="password" placeholder="请输入您的密码" id="passwordId" name="password"/>
					</td>
				</tr>
				<tr>
					<td class="tds">确认密码：</td>
					<td>
						<input type="password" placeholder="请输入您的确认密码" id="confirmpwdId" name="password2"/>
					</td>
				</tr>
				
				<tr>
					<td class="tds">昵称：</td>
					<td>
						<input type="text" id="nicknameId" placeholder="请输入您的昵称" name="nickName"/>
					</td>
				</tr>
				<tr>
					<td class="tds">邮箱：</td>
					<td>
						<input type="text" id="emailId" placeholder="请输入您的邮箱" name="email"/>
					</td>
				</tr>
				
				<tr>
					<td class="tds">验证码：</td>
					<td>
						<input type="text" id="vcodeId" placeholder="请输入验证码" />
						<span id="code" ></span> 
					</td>
				</tr>
				<tr>
					<td class="sub_td" colspan="2" class="tds">
						<input type="submit" value="注册用户"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
