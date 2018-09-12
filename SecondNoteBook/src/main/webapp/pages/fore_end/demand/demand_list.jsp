<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- EasyUI -->
<link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${basePath}/static/jquery-easyui-1.5.3/demo/demo.css">
<script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}/static/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="${basePath}/static/js/fore_end/demandlist.js"></script>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">搜索</h3>
    </div>
    <div class="panel-body">
       <form id="search_form" method="post" action="#">
			<span>交易类型:</span>
			<select name="buyType" type="select" id="id_buyType" autocomplete="off">
							<option value="0">请选择</option>
							<option value="1">在线交易</option>
							<option value="2">线下交易</option>
							<option value="3">物品交换</option>
						
						</select>
			
				<span class="input_span">商品名称：<input class="search_name" type="text" name="category"/></span>
				<span class="input_span">日期区间：
				<input class="easyui-datebox" data-options="onSelect:onSelect1"></input> -
				<input class="easyui-datebox" data-options="onSelect:onSelect2"></input></span>
				
				<input class="search_btn"  type="button" value="查 询" onclick="doSearchDemand()">
	    </form>
    </div>
</div>

<table class="table table-hover">
	<caption>需求单列表</caption>
	<thead>
		<tr>
			<th>需求商品名</th>
			<th>期望价格</th>
			<th>发布时间</th>
			<th>交易方式</th>
			<th>联系方式</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody id="demand_id">
	
	</tbody>
</table>
<ul class="pagination" id = "page-Id">
	
</ul>