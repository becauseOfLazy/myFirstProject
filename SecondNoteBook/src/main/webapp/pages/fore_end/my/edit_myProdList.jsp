<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
$(document).ready(function(){
	$("#myModal").on("click",".btn-primary",doUpdateProdInfo);
	 $("#myModal")
	   .on("hidden.bs.modal",function(){
		   $("#myModal").off("click",".btn-primary");
		   $("#myModal").removeData("id");
	   });
	doLoadProdInfoPage();
})
//加载商品数据
function doLoadProdInfoPage(){
	var url = "doGetProdInfo.do";
	var id = $("#myModal").data("id");
	var param = {"id":id};
	$.post(url,param,function(result){
		if(result.state){
			doListProdInfo(result.data);
		}
	})
}
//显示商品信息
function doListProdInfo(data){
	$("#prodName").val(data.prodName);
	$("#prodTitle").val(data.title);
	$("#prodPrice").val(data.prodPrice);
	$("#contactName").val(data.contactName);
	$("#phoneNumber").val(data.phoneNumber);
	$("#validId input[name='valid']").each(function(){
		if($(this).val()==data.valid){
			$(this).prop("checked",true);
		}
	});
	$("#buyTypeId input[name='buyType']").each(function(){
		if($(this).val()==data.buyType){
			$(this).prop("checked",true);
		}
	});
}
//修改提交商品的信息
function doUpdateProdInfo(){
	var url = "toUpdateProd.do";
	var param = {"id":$("#myModal").data("id"),
		"prodName":$("#prodName").val(),
		"title": $("#prodTitle").val(),
		"prodPrice":$("#prodPrice").val(),
		"contactName":$("#contactName").val(),
		"phoneNumber":$("#phoneNumber").val(),
		"valid":$("input[name='valid']:checked").val(),
		"buyType":$("input[name='buyType']:checked").val()};
	console.log(param);
	$.post(url,param,function(result){
		if(result.state){
			$("#myModal").modal("hide");
			doGetMyProdListPage();
		}
	})
}
</script>
<form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="prodName" class="col-sm-2 control-label">商品名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prodName" placeholder="请输入商品名">
    </div>
  </div>
  <div class="form-group">
    <label for="prodTitle" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prodTitle" placeholder="请输标题">
    </div>
  </div>
  <div class="form-group">
    <label for="prodPrice" class="col-sm-2 control-label">价格</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prodPrice" placeholder="请输价格">
    </div>
  </div>
  <div class="form-group">
    <label for="contactName" class="col-sm-2 control-label">联系人</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="contactName" placeholder="请输联系人名" >
    </div>
  </div>
    <div class="form-group">
    <label for="phoneNumber" class="col-sm-2 control-label">联系电话</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="phoneNumber" placeholder="请输联系电话" >
    </div>
  </div>
 <div class="form-group">
         <label class="col-md-2 control-label"> 状态: </label>
         <div id="validId" class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="valid" checked value="1" >已上架</label>
            <label class="radio-inline"><input  type="radio" name="valid" value="0">已下架</label>
          </div>
    </div>
  <div class="form-group">
         <label class="col-md-2 control-label"> 交易方式: </label>
         <div id="buyTypeId" class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="buyType" checked value="1" >在线交易</label>
            <label class="radio-inline"><input  type="radio" name="buyType" value="2">线下交易</label>
			<label class="radio-inline"><input  type="radio" name="buyType" value="3">物品交换</label>
          </div>
    </div>
</form>