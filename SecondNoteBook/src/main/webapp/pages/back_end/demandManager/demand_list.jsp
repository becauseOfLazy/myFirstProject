<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath}/static/js/back_end/demand.js"></script>
<script type="text/javascript" src="${basePath}/static/js/back_end/page.js"></script>
 <!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<ol class="breadcrumb">
				  <li class="active">需求单管理</li>
				</ol>
			</div>
			<div class="page-stats"></div>
		</div>
		<form method="post"  id="queryFormId">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><input type="text" id="searchNameId" class="form-control"placeholder="需求单名称"></li>
					<li><select id="searchValidId" class="form-control">
							<option value="-1">全部</option>
							<option value="1">上架</option>
							<option value="0">下架</option>
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
						   <th>选择</th>
							<th>需求单名称</th>
							<th>发布时间</th>
							<th>交易方式</th>
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