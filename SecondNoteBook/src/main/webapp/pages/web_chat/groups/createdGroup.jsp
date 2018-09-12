<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
//创建联系群
function doCreatedGroup(){
	var url = "toSubmitGroupInfo.do";
	var groupname = $("#groupname").val();
	var localname = $("#localname").val();
	var maxNumber = $("#groupsMaxNumber option:selected").text();
	var verifyType = $("#verifyType input[checked='checked']").val();
	var note = $("#note").val();
	var param = {"groupName":groupname,
			"groupLocal":localname,
			"maxNumber":maxNumber,
			"verifyType":verifyType,
			"note":note};
	console.log(param);
	$.post(url,param,function(result){
		console.log(result);
		if(result.state){
			alert("创建成功！")
		}else{
			alert(result.message);
		}
	})
}

</script>
<div class="panel panel-default" style="width:800px;height:600px;">
				<div class="panel-heading">
					<h3 class="panel-title">创建联系群</h3>
				</div>
				
				<div class="panel-body" id="group_body">
					<form class="form-horizontal" role="form">
					  <div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">群名：</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control" id="groupname" placeholder="请输入群名">
						</div>
					  </div>
					  <div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">群地点：</label>
						<div class="col-sm-10">
						  <input type="text" class="form-control" id="localname" placeholder="请输入群地点">
						</div>
					  </div>
					<div class="form-group">
						<label for="groupsMaxNumber" class="col-sm-2 control-label">群人数：</label>
						<div class="col-sm-10">
							<select class="form-control" id="groupsMaxNumber" name="groupsMaxNumber">
							  <option>10</option>
							  <option>50</option>
							  <option>100</option>
							  <option>500</option>
							  <option>1000</option>
							</select>
						</div>
					</div>
					 <div class="form-group">
						<label for="checkType" class="col-sm-2 control-label">加群验证：</label>
						<div class="col-sm-10" id="verifyType">
						  <input type="radio" checked="checked"  value="1" name="checkType">允许任何人</input>
						  <input type="radio"  value="2" name="checkType">需要验证</input>
						  <input type="radio"  value="3" name="checkType">不允许任何人</input>
						</div>
					  </div>
					   <div class="form-group">
					    <label for="note" class="col-sm-2 control-label">群简介</label>
					    <div class="col-sm-10">
					    	<textarea class="form-control" id="note" rows="3"></textarea>
					  	</div>
					  </div>
					  <div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
						  <button type="button" class="btn btn-default" onclick="doCreatedGroup()" style="float:right;">创建</button>
						</div>
					  </div>
					</form>
				</div>
			</div>