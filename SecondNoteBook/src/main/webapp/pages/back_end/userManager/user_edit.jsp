<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
   <div class="container" style="width:600px;" >
	<!-- 页面导航 -->
	 <div class="row col-md-12">
	  <form class="form-horizontal" id="editTypeForm">
	            <div class="form-group">
					<div class="col-sm-2 control-label">用户名称：</div>
					<div class="col-sm-10">
						<input type="text" id="userNameId"  placeholder="用户名称" class="form-control dynamicClear required">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2 control-label">当前角色：</div>
					<div class="col-sm-10">
						<input type="text"  id="roleNameId" readonly="readonly" placeholder="选择角色"
							class="form-control required dynamicClear load-product-type" style="cursor: pointer;">
					</div>
				</div>
				<div class="form-group">
		            <label for="noteId" class="col-sm-2 control-label">昵称:</label>
		            <div class="col-sm-10">
		            	<input type="text" id="nickNameId" placeholder="昵称" class="form-control required dynamicClear" name="nickName"/>
		           </div> 
		          
	            </div>
	            <div class="form-group">
		         <label class="col-md-2 control-label"> 用户状态: </label>
			         <div class="col-md-10">
			            <label class="radio-inline"><input  type="radio" name="status" checked value="1">上线</label>
			            <label class="radio-inline"><input  type="radio" name="status" value="2">下线</label>
			            <label class="radio-inline"><input  type="radio" name="status" value="3">冻结</label>
			          </div>
			    </div>
	            <div class="form-group">
		            <label for="noteId" class="col-sm-2 control-label">邮箱:</label>
		            <div class="col-sm-10">
		            	<input type="text" id="emailId" placeholder="邮箱" class="form-control required dynamicClear" name="email"/>
		           </div> 
		          
	            </div>
				
			</form>
		</div>
    </div>

<script type="text/javascript" src="${basePath}/static/js/back_end/user_edit.js"></script>




