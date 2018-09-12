<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${basePath}/static/css/prodInfo.css" rel="stylesheet" type="text/css">
<script src="${basePath}/static/js/fore_end/prod_info.js"></script>
<div id="warp">
		<div id="left">
			<div id="left_top">
			</div>
			<div id="left_bottom">
			</div>
		</div>
	<form id="prod-form"  method="post">
		<div id="right">
			<div id="right_top">
				<span id="prod_name"> <br/></span>
				<br>
				<span id="prod_desc"> <br/></span>
			</div>
			<div id="right_middle">
				<span id="right_middle_span">
					交易价格：
				<span class="price_red"></span><br/>
			    	联系人：
			    <span class="contact_Name"></span><br />
			    	联系电话：
			    <span class="phone_Number"></span><br />
			    	交易地点：
			    <span class="city_Name"></span><br />
			    </span>
			</div>
			<div id="right_bottom">
				<input type="hidden" name="pid" value=""/>
				<input class="add_cart_but" type="button" value=""/>	
			</div>
		</div>
	</form>
</div>
