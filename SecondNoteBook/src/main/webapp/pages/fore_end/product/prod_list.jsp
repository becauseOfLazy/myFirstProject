<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${basePath}/static/css/prodList.css" rel="stylesheet" type="text/css">
<script src="${basePath}/static/js/fore_end/prod_list.js"></script>
<script type="text/javascript">

</script>
<div id="content">
<div id="search_div">
<span class="label label-danger">热门选择</span>
			<table id="select-tableId" class="table">
			  <tbody>
			    <tr>
			      <td>品牌</td>
			      <td><a href="javascript:void(0);" onclick="selectType(this)" >联想</a></td>
				  <td><a href="javascript:void(0);" onclick="selectType(this)">华硕</a></td>
				  <td><a href="javascript:void(0);" onclick="selectType(this)">苹果</a></td>
				  <td><a href="javascript:void(0);" onclick="selectType(this)">戴尔</a></td>
				  <td><a href="javascript:void(0);" onclick="selectType(this)">神舟</a></td>
			    </tr>
			    <tr>
			      <td>价格</td>
			      <td><a href="javascript:void(0);" onclick="selectPrice(this)" >0-1500</a></td>
				  <td><a href="javascript:void(0);" onclick="selectPrice(this)" >1500-3000</a></td>
				  <td><a href="javascript:void(0);" onclick="selectPrice(this)" >3000-4500</a></td>
				  <td><a href="javascript:void(0);" onclick="selectPrice(this)" >4500-6000</a></td>
				  <td><a href="javascript:void(0);" onclick="selectPrice(this)" >6000以后</a></td>
			    </tr>
				<tr>
			      <td>交易类型</td>
			      <td><a href="javascript:void(0);" onclick="selectBuyType(this)" >在线交易</a></td>
				  <td><a href="javascript:void(0);" onclick="selectBuyType(this)" >线下交易</a></td>
				  <td><a href="javascript:void(0);" onclick="selectBuyType(this)" >物品交换</a></td>
				  <td></td>
				   <td></td>
			    </tr>
			  </tbody>
			</table>
<span class="label label-default">自定义选择</span>
			<form id="search_form" method="post" action="#">
			<span>交易类型:</span>
			<select name="buyType" type="select" id="id_buyType" autocomplete="off">
							<option value="">请选择</option>
							<option value="1">在线交易</option>
							<option value="2">线下交易</option>
							<option value="3">物品交换</option>
						
						</select>
			
				<span class="input_span">商品名称：<input class="search_type" type="text" name="category"/></span>
				<span class="input_span">商品价格区间：<input class="search_minprice" type="text" name="minprice"/> - <input class="search_maxprice" type="text" name="maxprice"/></span>
				
				<input class="search_btn" type="button" value="查 询">
			</form>
</div>
		<table id="prod_content">
		
		</table>
	</div>

<div class="pager" id="Jpager">
	<a class="page-prev null" href="javascript:void(0)" >上一页</a>

	<span class="page-current">1</span>

	<a class="page-next" href="javascript:void(0)" >下一页</a>
	
	<em>共 <i class="page-Counter">36</i> 页，到第 <input type="text" value="" name="page" id="page-transform-number"> 页</em>
    <a id="page-confirm" class="page-jump"  href="javascript:void(0)" >确定</a>
</div>
<style>
.pager {
    color: #999;
    float: left;
    border: 1px solid #D4D4D4;
    padding: 8px;
}.pager .null {
    border: 1px solid #e5e5e5;
    color: #bbb;
}
.pager a, .pager span {
    margin-right: 2px;
    height: 28px;
    line-height: 28px;
    padding: 0 12px;
    border: 1px solid #e5e5e5;
    display: inline-block;
    _display: inline;
    _zoom: 1;
    text-align: center;
    color: #999;
}

</style>
