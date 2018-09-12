<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath}/static/js/back_end/user_list.js"></script>
<script type="text/javascript" src="${basePath}/static/js/back_end/page.js"></script>
<!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<ol class="breadcrumb">
				  <li class="active">用户信息管理</li>
				</ol>
			</div>
		</div>
		<form method="post" id="formHead">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
				<li><input type="text" id="searchNameId" class="form-control" placeholder="用户名称" ></li>
					<li><select id="searchValidId" class="form-control">
							<option value="-1">角色等级</option>
							<option value="3">普通用户</option>
							<option value="2">会员</option>
							<option value="1">管理员</option>
					</select></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
					
				</ul>
			  </div>
			</div>
			</form>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
					<tr>
						<th>用户名</th>
						<th>用户昵称</th>
						<th>邮箱</th>
						<th>注册时间</th>
						<th>当前状态</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody id="tbodys_id">
						
					</tbody>
				</table>
				<%@include file="../page.jsp" %>
			</div>
		
	</div>
