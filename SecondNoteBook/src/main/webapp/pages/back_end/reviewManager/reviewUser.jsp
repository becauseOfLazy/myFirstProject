<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<ol class="breadcrumb">
				  <li class="active">会员审核管理</li>
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
							<option value="-1">状态</option>
							<option value="1">已通过</option>
							<option value="0">未通过</option>
					</select></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
					<tr>
						<th>申请用户名</th>
						<th>用户昵称</th>
						<th>当前角色名</th>
						<th>申请角色名</th>
						<th>请求时间</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody id="tbody_id">
						
					</tbody>
				</table>
			</div>
		</form>
	</div>
<script type="text/javascript" src="${basePath}/static/js/back_end/reviewUser.js"></script>