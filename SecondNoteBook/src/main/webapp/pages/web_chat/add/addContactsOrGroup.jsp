<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <script type="text/javascript" src="${basePath}/static/js/web_chat/addContactsOrGroup.js"></script>
 <div class="panel panel-default" style="width:800px;">
				<div class="panel-heading">
					<h3 class="panel-title">添加联系人/群</h3>
				</div>
				
				<div class="panel-body" style="width:800px;height:550px;position:relative;">
					<div class="col-lg-6">
						<div class="input-group" style="position:absolute;left:200px;top:30px;">
							<input type="text" class="form-control" id="searchName" placeholder="请输入联系人名或群名..." >
							<span class="input-group-btn">
								<button class="btn btn-default" onclick="doSearchContracts()" type="button">搜索人</button>&nbsp;&nbsp;
								<button class="btn btn-default" onclick="doSearchGroups()" type="button">搜索群</button>
							</span>
						</div><!-- /input-group -->
					</div><!-- /.col-lg-6 -->
					<div  style="position:absolute;width:780px;top:100px;border:1px solid #999;"></div>
					<div id="contactsBodyId" style="position:absolute;top:150px;">
						
					</div>
				</div>
			</div>