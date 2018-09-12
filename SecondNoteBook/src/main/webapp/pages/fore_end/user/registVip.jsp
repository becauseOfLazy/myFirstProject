<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="${basePath}/static/js/fore_end/registVip.js"></script>

<div class="panel panel-success" style="width:700px;margin:auto;">
    <div class="panel-heading">
        <h3 class="panel-title">
           注册会员
        </h3>
    </div>
    <div class="panel-body">
   <form class="form-horizontal" role="form">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">真实姓名</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="name" name="name"
				   placeholder="请输入名字">
		</div>
	</div>
	<div class="form-group">
		<label for="age" class="col-sm-2 control-label">年龄</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="age" name="age"
				   placeholder="请输入年龄">
		</div>
	</div>
	<div class="form-group">
		<label for="sex" class="col-sm-2 control-label">性别</label>
		<div class="col-sm-10">
			<input type="radio" id="sex_id" checked="checked"  id="sex" name="sex" >男</input>
			<input type="radio" id="sex_id"  id="sex" name="sex" >女</input>
		</div>
	</div>
	<div class="form-group">
	<label for="education" class="col-sm-2 control-label">学历</label>
	<div class="col-sm-10">
	    <select class="form-control" id = "education_id" name="education" style="width:200px;">
	      <option value="-1">选择</option>
	      <option value="0">小学</option>
	      <option value="1">中学</option>
	      <option value="2">高中</option>
	      <option value="3">专科</option>
	      <option value="4">本科</option>
	      <option value="5">硕士</option>
	      <option value="6">博士以上</option>
	    </select>
	</div>
    </div>
	<div class="form-group">
		<label for="idCard" class="col-sm-2 control-label">身份证号</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="idCard" name="idCard"
				   placeholder="请输入...">
		</div>
	</div>
	<div class="form-group">
		<label for="phoneNumber" class="col-sm-2 control-label">手机号</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
				   placeholder="请输入...">&nbsp;
		</div>
	</div>
	
    <div class="form-group">
	 <label for="phoneNumberCode" class="col-sm-2 control-label">验证码</label>
		<div class="col-sm-10">
		
				<input type="text" id="code_val_id"  placeholder="请输入验证码" style="width:200px;"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="code_id" class="btn btn-default" value="获取短信验证码" onclick="doGetCode()" style="width:150px;"/>
			
		</div> 
			<div id="code_message"></div>
		
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-success" onclick="doSubmitApplyVip()">注册会员</button>
		</div>
	</div>
</form>
    </div>
</div>