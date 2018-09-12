<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="${basePath}/static/bootstrap/css/bootstrap.min.css">  
		<script src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/fore_end/myDemand.js"></script>
<div class="panel panel-info">
    <div class="panel-heading">
        <h3 class="panel-title">我的需求单</h3>
    </div>
    <div class="panel-body">
       <div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>品牌</th>
				<th>名称</th>
				<th>价格区间</th>
				<th>交易方式</th>
				<th>联系方式</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="t_bodyId">
			
		</tbody>
	</table>
	</div> 
    </div>
</div>

