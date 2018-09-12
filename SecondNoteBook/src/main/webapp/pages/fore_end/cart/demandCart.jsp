<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="${basePath}/static/bootstrap/css/bootstrap.min.css">  
		<script src="${basePath}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/fore_end/demandCart.js"></script>
<table class="table table-hover">
	<caption>需求单关注列表</caption>
	<thead>
		<tr>
			<th>需求商品名</th>
			<th>期望价格</th>
			<th>交易方式</th>
			<th>发布时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody id="demandBody_id"> 
		
	</tbody>
</table>
<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
