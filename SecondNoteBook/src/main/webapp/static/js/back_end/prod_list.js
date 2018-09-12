$(document).ready(function(){
	  doGetObjects();
	 $("#queryFormId").on("click",".btn-search",doQueryObjects);
	  
});
/**查询商品*/
function doQueryObjects(){
	var searchName = $("#searchNameId").val();
	var status = $("#searchValidId").val();
	var url = "doSearchProdObject.do";
	var param = {"searchName":searchName,"status":status};
	$.post(url,param,function(result){
		if(result.state){
			setTableBodyRows(result.data);
		}else{
			alert(result.message);
			doGetObjects();
		}
	})
}

//编辑商品信息
function doShowEditDialog(btn){
	var title;
	$("#modal-dialog").data("id",$(btn).parent().parent().data("id"));
	title="修改商品,id为"+$("#modal-dialog").data("id");
	var url="toEditProdUI.do";
	$("#modal-dialog .modal-body").load(url,function(){
		$(".modal-title").html("修改商品");
		$(".bt-concle").text("取消");
		$(".bt-ok").text("确认");
		//显示模态框(index.jsp中)
		$("#modal-dialog").modal("show");
	});
}

/*获取项目信息*/
function doGetObjects(){
	//获取当前页的页码值,假如没有值,默认值设置为1
	var pageCurrent=$("#pageId").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	var param = {"pageCurrent":pageCurrent};
	var url="toGetPageObjects.do";
	var pageObject = {"pageCurrent":pageCurrent};
	//发起异步请求获取服务端数据
	$.post(url,param,function(result){
		var pageObject = result.data.page;
		var lists = result.data.lists;
		//设置分页
		setPagination(pageObject);
		//设置页面内容
		setTableBodyRows(lists);
	});
}
/*将数据填充在table对象的body中*/
function setTableBodyRows(data){
	
	 var tBody=$("#tbodyId");
	 tBody.empty();
	 for(var i in data){
		 var tr=$("<tr></tr>");
		 tr.data("id",data[i].id);
		 var tds="<td><input type='checkbox' name='checkId' value='"+data[i].id+"'></td>"+
				 "<td>"+data[i].id+"</td>"+
				 "<td>"+data[i].prodName+"</td>"+
		         "<td>"+data[i].beginDate+"</td>"+
		         "<td>"+data[i].endDate+"</td>"+
		         "<td>"+(data[i].status==1?"等待上架" +
		         	"":(data[i].status==2?"已上架" +
		         	"":(data[i].status==3?"暂停上架":"已下架")))+
		         "</td>"+
		         "<td><input type='button' class='btn btn-default' onclick='doShowEditDialog(this)' value='修改'/></td>";
		
		 tr.append(tds);
		 tBody.append(tr);
	 }
}




