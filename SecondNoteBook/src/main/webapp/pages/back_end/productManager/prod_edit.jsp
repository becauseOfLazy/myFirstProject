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
<script type="text/javascript" src="${basePath}/static/js/back_end/prod_edit.js"></script>

<form  class="form-horizontal" role="form" id="editFormId">
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >商品名称:</label> 
	    <div class="col-sm-10">
			<input type="text" readonly="readonly" class="form-control required" name="name" id="nameId" >
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">商主编号:</label> 
		<div class="col-sm-10">
		<input type="text" readonly="readonly" class="form-control required" name="userId" id="userId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">上架时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker " name="code" id="beginDateId">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">下架时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker "  name="code" id="endDateId">
		</div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="valid" checked value="1">等待上架</label>
            <label class="radio-inline"><input  type="radio" name="valid" value="2">已上架</label>
            <label class="radio-inline"><input  type="radio" name="valid" value="3">暂停上架</label>
            <label class="radio-inline"><input  type="radio" name="valid" value="4">已下架</label>
          </div>
    </div>
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="note" id="noteId"></textarea>
		</div> 
	</div>
</form>
