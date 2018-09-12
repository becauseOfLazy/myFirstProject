<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript">
//初始化datepicker对象
$('.datepicker').datepicker({
    format: 'yyyy-mm-dd 00:00:00',
    autoclose: true//选中自动关闭
})
</script>
<script type="text/javascript" src="${basePath}/static/js/back_end/order_edit.js"></script>

<form  class="form-horizontal" role="form" id="editFormId">
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >订单编号:</label> 
	    <div class="col-sm-10">
			<input type="text" readonly="readonly" class="form-control required" name="order" id="orderId" >
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">收货地址:</label> 
		<div class="col-sm-10">
		<input type="text" readonly="readonly" class="form-control required" name="address" id="addressId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">撤销时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker " name="cancelTime" id="cancelTimeId">
		</div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 交易方式: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="buyType" checked value="1">在线交易</label>
            <label class="radio-inline"><input  type="radio" name="buyType" value="2">线下交易</label>
          	<label class="radio-inline"><input  type="radio" name="buyType" value="3">物品交换</label>
          </div>
    </div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="status" checked value="1">已付款</label>
            <label class="radio-inline"><input  type="radio" name="status" value="2">未付款</label>
            <label class="radio-inline"><input  type="radio" name="status" value="3">已失效</label>
            <label class="radio-inline"><input  type="radio" name="status" value="4">未设置</label>
            <label class="radio-inline"><input  type="radio" name="status" value="5">待签收</label>
            <label class="radio-inline"><input  type="radio" name="status" value="6">已签收</label>
          </div>
    </div>
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>
</form>
