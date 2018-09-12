$(document).ready(function(){
   $("#modal-dialog").on("click",".ok",doSaveOrUpdate);
   $("#modal-dialog").on("hidden.bs.modal",function(){
	   $("#modal-dialog").off("click",".ok");
	   $("#modal-dialog").removeData("id");
   });
   //获取模态框上绑定的值
   var id=$("#modal-dialog").data("id");
   if(id)doFindObjectById(id);
});
/*根据id执行查询操作*/
function doFindObjectById(id){
	var url="doFindObjectById.do";
	var params={"id":id};
	$.post(url,params,function(result){
		if(result.state==1){
		  doInitFormData(result.data);//{"name":"","code":"",...}
		}else if(result.state==0){
		  alert(result.message);
		}
	});
}
/*修改初始化表单数据*/
function doInitFormData(data){
	$("#nameId").val(data.prodName);
	$("#userId").val(data.uId);
	$("#beginDateId").val(data.beginDate);
	$("#endDateId").val(data.endDate);
	$("#editFormId input[name='valid']")
	.each(function(){
		if($(this).val()==data.status){
			$(this).prop("checked",true);
		}
	});
	$("#noteId").val(data.note);
}
/*添加或修改数据*/
function doSaveOrUpdate(){
	var params=getEditFormData();
	console.log(params);
	var url="doUpdateObject.do";
	$.post(url,params,function(result){
		if(result.state==1){
			//隐藏模态框
			$("#modal-dialog").modal("hide");
			//重新查询数据
			doGetObjects();
		}else{
			alert(result.message);
		}
	});
}
/*获取表单数据*/
function getEditFormData(){
	var id=$("#modal-dialog").data("id");
	var params={id:id,
	  prodName:$("#nameId").val(),
	  uId:$("#userId").val(),
	  beginDate:$("#beginDateId").val(),
	  endDate:$("#endDateId").val(),
	  status:$("input[type='radio']:checked").val(),
	  note:$("#noteId").val()
	}//JSON 对象
	return params;
}