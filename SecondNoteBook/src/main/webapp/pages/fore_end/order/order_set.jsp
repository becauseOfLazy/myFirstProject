<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${basePath}/static/css/order.css" rel="stylesheet" type="text/css">
<script src="${basePath}/static/js/fore_end/order_set.js"></script>
	<div class="warp">
		<form id="oder_add_form" name="form1" method="post">
			<h3>增加订单</h3>
			<div id="forminfo">
				<span class="lf" style="vertical-align: middle;">收货地址：</span> 
				<label for="textarea"></label>
				<textarea name="receiverinfo" id="textarea" cols="35" rows="3" placeholder="xx省xx市xx路xx号" ></textarea>
				<br> 支付方式：<input name="" type="radio" value="" checked="checked">&nbsp;在线支付
				
			</div>
			<table id="order_body" width="1200" height="80" border="1" cellpadding="0" cellspacing="0" bordercolor="#d8d8d8">
				
			</table>

			<div class="Order_price">总价：2119.0元</div>
			
	
			<div class="add_orderbox">
				<input name="" type="button" value="增加订单" class="add_order_but">
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="" type="button" value="取消订单" class="cancel_order_but">
			</div>
		</form>
	</div>