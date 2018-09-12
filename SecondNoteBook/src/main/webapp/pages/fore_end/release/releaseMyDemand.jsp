<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
function submitData(){
	var url = "toSubmitDemand.do";
	var prodType = $("#prodTypeId").val();
	var prodName = $("#prodNameId").val();
	var minPrice = $("#minPriceId").val();
	var maxPrice = $("#maxPriceId").val();
	var buyType = $("#buyTypeId input[type='radio']:checked").val();
	var phoneNumber = $("#phoneNumberId").val();
	var note = $("#noteId").val();
	var param = {"prodType":prodType,"prodName":prodName,
			"minPrice":minPrice,"maxPrice":maxPrice,
			"buyType":buyType,"phoneNumber":phoneNumber,
			"note":note};
	$.post(url,param,function(result){
		alert(result.message);
		var url = "toGetReleaseDemandPage.do";
		$(".panel-body").load(url);
	})
}
</script>
 <form  method="post" class="form-horizontal" role="form" style="width:600px;margin:auto;">
  <div class="form-group">
    <label for="prodName" class="col-sm-2 control-label">品牌</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prodTypeId" name="prodType" placeholder="请输入品牌">
    </div>
  </div>
  <div class="form-group">
    <label for="prodTitle" class="col-sm-2 control-label">名称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prodNameId" name="prodName" placeholder="请输入名称">
    </div>
  </div>
  <div class="form-group">
    <label for="prodPrice" class="col-sm-2 control-label">价格区间</label>
    <div class="col-sm-10">
      <input class="search_minprice" id="minPriceId" type="text" name="minprice"/> - <input class="search_maxprice" id="maxPriceId" type="text" name="maxprice"/>
    </div>
  </div>
    <div class="form-group">
    <label for="phoneNumber"  class="col-sm-2 control-label">联系电话</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="phoneNumberId" name="phoneNumber" placeholder="请输联系电话" >
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
    
   <div class="form-group">
    <label for="name">备注</label>
    <textarea class="form-control" id="noteId" rows="3" name="noteText"></textarea>
  </div>
   <button type="button"  class="btn btn-danger" style="float:right;" onclick="submitData()">发布</button>
</form>