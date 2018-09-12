<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(document).ready(function(){
		doLoadPageObject();
		$("#myModal").on("click",".btn-primary",doUpdateDemandInfo);
		$("#myModal")
		   .on("hidden.bs.modal",function(){
			   $("#myModal").off("click",".btn-primary");
			   $("#myModal").removeData("id");
		   });
	})
	//加载当前页面数据信息
	function doLoadPageObject(){
		var url = "dogetDemandObject.do";
		var demandId =$("#myModal").data("demandId");
		//console.log("demandId="+demandId);
		var param = {"demandId":demandId};
		$.post(url,param,function(result){
			if(result.state){
				showDemandInfo(result.data);
			}
		})
	}
	function showDemandInfo(data){
		$("#prodTypeId").val(data.prodType);
		$("#prodNameId").val(data.prodName);
		$("#minPriceId").val(data.minPrice);
		$("#maxPriceId").val(data.maxPrice);
		$("#phoneNumberId").val(data.phoneNumber);
		$("#noteId").val(data.note);
		$("#payTypeId input[name='buyType']").each(function(){
			if($(this).val()==data.payType){
				$(this).prop("checked",true);
			}
		});
		if(data.payType==3){
			$("#exhangeProdId").data("exchangeProdId",data.exchangeId);
			$("#exhangeProdId").append("<a href='javascript:void(0)' onclick='doGetExchangeProdInfo(this)'>详情</a>");
		}else{
			$("#exhangeProdId").append("<span>无</span>");
		}
	}
	//修改需求单信息
	function doUpdateDemandInfo(){
		var demandId =$("#myModal").data("demandId");
		var prodType = $("#prodTypeId").val();
		var prodName = $("#prodNameId").val();
		var minPrice = $("#minPriceId").val();
		var maxPrice = $("#maxPriceId").val();
		var phoneNumber = $("#phoneNumberId").val();
		var note = $("#noteId").val();
		var payType =  $("#payTypeId input[name='payType']:checked").val();

		var url = "toUpdateDemandInfo.do";
		var param = {"id":demandId,
				"prodType":prodType,
				"prodName":prodName,
				"minPrice":minPrice,
				"maxPrice":maxPrice,
				"phoneNumber":phoneNumber,
				"note":note,
				"payType":payType};
		$.post(url,param,function(result){
			if(result.state){
				alert("保存成功！");
				$("#myModal").modal("hide");
				doListMyDemandPage();
			}
		})
	}
	//查看交换的商品信息
	function doGetExchangeProdInfo(btn){
		
	}
</script>
<form action="toSubmitDemand.do" method="post" class="form-horizontal" role="form" style="width:400px;margin:auto;">
  <div class="form-group">
    <label for="prodName" class="col-sm-2 control-label">品牌</label>
    <div class="col-sm-10">
      <input type="text" id="prodTypeId" class="form-control" name="prodType" placeholder="请输入品牌">
    </div>
  </div>
  <div class="form-group">
    <label for="prodTitle" class="col-sm-2 control-label">名称</label>
    <div class="col-sm-10">
      <input type="text" id="prodNameId" class="form-control" name="prodName" placeholder="请输入名称">
    </div>
  </div>
  <div class="form-group">
    <label for="prodPrice" class="col-sm-2 control-label">价格</label>
    <div class="col-sm-10">
      <input id="minPriceId" style="width:50px;" class="search_minprice" type="text" name="minprice"/> - 
      <input id="maxPriceId" style="width:50px;" class="search_maxprice" type="text" name="maxprice"/>
    </div>
  </div>
    <div class="form-group">
    <label for="phoneNumber" class="col-sm-2 control-label">电话</label>
    <div class="col-sm-10">
      <input  type="text" id="phoneNumberId" class="form-control" name="phoneNumber" placeholder="请输联系电话" >
    </div>
  </div>
  <div class="form-group">
         <label class="col-md-2 control-label"> 方式: </label>
         <div id="payTypeId" class="col-md-10">
            <label class="radio-inline"><input  type="radio" name="payType" checked value="1" >在线交易</label>
            <label class="radio-inline"><input  type="radio" name="payType" value="2">线下交易</label>
			<label class="radio-inline"><input  type="radio" name="payType" value="3">物品交换</label>
          </div>
    </div>
     <div class="form-group">
    <label for="exchangeProd" class="col-sm-2 control-label">交换</label>
    <div class="col-sm-10" id="exhangeProdId">
      
    </div>
  </div>
    <div class="form-group">
    <label for="name">备注</label>
    <textarea id="noteId" class="form-control" rows="3" name="noteText"></textarea>
  </div>
  
</form>