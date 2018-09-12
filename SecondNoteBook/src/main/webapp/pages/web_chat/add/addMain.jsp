<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
//添加联系人和群
function addContact(){
	var url = "toLoadAddContractsOrGroupPage.do";
	$("#messageBody_id").load(url);
}
//创建联系群
function createdGroup(){
	var url = "toLoadCreatedGroupPage.do";
	$("#messageBody_id").load(url);
}
//验证联系人或群
function checkedContactsOrGroup(){
	var url = "toLoadContactGroupPage.do";
	$("#messageBody_id").load(url);
}
</script>


<div class="center_div">
	<button type="button" class="btn btn-default btn-lg " onclick="addContact()">添加联系人/群</button>
	<button type="button" class="btn btn-default btn-lg " onclick="createdGroup()">创  建 联 系 群 </button>
	<button type="button" class="btn btn-default btn-lg " onclick="checkedContactsOrGroup()">验证联系人/群 </button>
</div>