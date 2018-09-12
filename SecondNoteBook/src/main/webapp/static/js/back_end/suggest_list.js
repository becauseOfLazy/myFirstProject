$(document).ready(function(){
	doGetObjects();
	$("#tbodyId").on("click",".btn-info",doGetAllInfo)
	$("#modal-dialog").on("click",".ok",doPrimaryBtn)
	$("#modal-dialog").on("hidden.bs.modal",function(){
		   $("#modal-dialog").off("click",".btn-primary");
		   $("#modal-dialog").removeData("id");
		   doGetObjects();
	   });
	
	$("#queryFormId").on("click",".btn-search",doSearchSuggest);
})
//条件查询留言状态
function doSearchSuggest(){
	var status = $("#searchValidId").val();
	var times = $("searchTimeId").val();
	if(state==-1){
		doGetObjects();
		return;
	}
	var url = "doSearchSuggestByState.do";
	var param = {"status":status,"times":times};
	$.post(url,param,function(result){
		if(result.state){
			doListSuggestPage(result.data);
		}
	})
}
//修改留言状态
function doGetAllInfo(){
	var id = $(this).parent().parent().data("id");
	$("#modal-dialog").data("id",id);
	$(".modal-title").html("留言内容");
	$(".ok").text("确认");
	$(".btn-default").text("取消");
	$("#modal-dialog").modal("show");
	$("#myModal").on("show.bs.modal",doGetSuggestInfo());
	
}
//确认阅读后
function doPrimaryBtn(){
	$("#modal-dialog").modal("hide");
}
//查看完整留言
function doGetSuggestInfo(){
	var url = "doGetAllSuggestInfo.do";
	var param = {"id":$("#modal-dialog").data("id")};
	$.post(url,param,function(result){
		if(result.state){
			var textarea = "<div class='form-group'>"+
			    "<label for='name'>文本框</label>"+
			    "<textarea class='form-control' rows='3'>"+result.data.suggestText+"</textarea>"+
			    "</div>";
			$(".modal-body").empty();
			$(".modal-body").append(textarea);
		}
	})
}
//加载留言
function doGetObjects(){
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	var param = {"pageCurrent":pageCurrent};
	var url = "doGetAllSuggest.do";
	$.post(url,param,function(result){
		if(result.state){
			console.log(result.data);
			var pageObject = result.data.page;
			var lists = result.data.list;
			setPagination(pageObject);
			doListSuggestPage(lists);
		}
	})
}
//显示显示留言信息
function doListSuggestPage(data){
	console.log(data);
	var tbody=$("#tbodyId");
	tbody.empty();
	 for(var i in data){
		 var tr=$("<tr></tr>");
		 tr.data("id",data[i].id);
		 var tds="<td><input type='checkbox' name='checkId' value='"+data[i].id+"'></td>"+
				 "<td>"+data[i].uId+"</td>"+
		         "<td>"+data[i].suggestText+"</td>"+
		         "<td>"+data[i].createdTime+"</td>"+
		         "<td>"+(data[i].status==1?"已读":"未读")+"</td>"+
		         "<td><input type='button' class='btn btn-default btn-info' value='详情'/></td>";
		
		 tr.append(tds);
		 tbody.append(tr);
	 }
}