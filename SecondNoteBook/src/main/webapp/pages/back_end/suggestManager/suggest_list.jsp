<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath}/static/js/back_end/suggest_list.js"></script>
<script type="text/javascript" src="${basePath}/static/js/back_end/page.js"></script>

 <!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<ol class="breadcrumb">
				  <li class="active">用户留言管理</li>
				</ol>
			</div>
			<div class="page-stats"></div>
		</div>
		<form method="post"  id="queryFormId">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><select id="searchValidId" class="form-control">
							<option value="-1">全部</option>
							<option value="1">已读</option>
							<option value="0">未读</option>
					</select></li>
					<li><select id="searchTimeId" class="form-control">
							<option value="-1">全部</option>
							<option value="1">今天</option>
							<option value="2">昨天</option>
							<option value="3">最近一周</option>
							<option value="4">最近一月</option>
					</select>
					</li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
						   <th>选择</th>
							<th>用户Id</th>
							<th>内容</th>
							<th>时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<!-- ajax异步获得,并将数据填充到tbody中 -->
					<tbody id="tbodyId">
					     
					</tbody>
				</table>
          <%@include file="../page.jsp" %>
			</div>
		</form>
	</div>  