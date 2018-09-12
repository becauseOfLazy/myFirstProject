$(document).ready(function(){
	//连接webSocket
	socketConnect();
	//加载联系人
	contactsList();
})
var websocket;
//连接webSocket
function socketConnect(){
	   // websocket = new WebSocket("ws://localhost:8080/SecondNoteBook/web_chat/socketServer.do");
	    if ('WebSocket' in window) {
	        websocket = new WebSocket("ws://localhost:8080/SecondNoteBook/web_chat/socketServer.do");
	    } 
	    else if ('MozWebSocket' in window) {
	        websocket = new MozWebSocket("ws://localhost:8080/SecondNoteBook/web_chat/socketServer.do");
	    } 
	    else {
	        websocket = new SockJS("http://localhost:8080/SecondNoteBook/sockjs/socketServer.do");
	    }
	    websocket.onopen = function(event) {
	    	console.log("WebSocket:打开连接 ");
	    	console.log(event);
	    	//onopen(event);
	    	};
	    websocket.onmessage = function(event) {
	    	console.log("WebSocket:接收消息 ");
	    	console.log(event);
	    	//onmessage(event);
	    	};
	    websocket.onerror = function(event) {
	    	console.log("WebSocket:发生错误 ");
	    	console.log(event);
	    	//onerror(event);
	    	};
	    websocket.onclose = function(event) {
	    	console.log("WebSocket:关闭连接 ");
	    	console.log(event);
	    	//onclose(event);
	    	};
	    
	    
}
//加载联系人列表
function contactsList(){
	$("#t1").className="active";
	$("#t2").className="";
	$("#t3").className="";
	var url = "toGetContactsListObjects.do";
	var pageCurrent = $("#page_id").data("pageCurrent");
	if(!pageCurrent){
		pageCurrent=1;
	}
	$("#page_id").data("pageCurrent",pageCurrent);
	var param = {"pageCurrent":pageCurrent};
	//console.log(param);
	$.post(url,param,function(result){
		console.log(result);
		if(result.state){
			//doSetPageObject(result.data.page);
			doListContactsObject(result.data.lists);
		}
	});
}
//加载群组列表
function groupsList(){
	$("#t2").className="active";
	$("#t1").className="";
	$("#t3").className="";
	var url = "toGetGroupsListObjects.do";
	$.post(url,function(result){
		if(result.state){
			
		}
	});
}
//添加或创建联系人
function addOrCreatedContact(){
	$("#t3").className="active";
	$("#t1").className="";
	$("#t2").className="";
	var url = "toAddOrCreatedContactPage.do";
	$("#bodycontact-id").load(url);
}
//加载用户联系人列表对象
function doListContactsObject(data){
	var tbody = $("#bodycontact-id");
	tbody.empty();
	console.log("data:"+data);
	var ttb = $("<table class='table' style='width:230px;'></table>");
	for(var i in data){
		var tr = "<tr>" +
				"<td>" +
				"<input type='hidden' id='relatedUserId' value='"+data[i].relatedUserId+"'/>" +
				"<a href='javascript:void(0);' onclick='doGetChatMessageBox(this)'>"+data[i].relatedUser.nickName+"</a>" +
				"<input type='hidden' id='relatedId' value='"+data[i].relatedId+"'/>" +
				"</td>" +
				"<td>" +
				"<span>"+(data[i].relatedUser.status==1?"在线":data[i].relatedUser.status==2?"离线":"拉黑")+"</span>" +
				"</td>" +
				"</tr>";
		ttb.append(tr);
	}
	tbody.append(ttb);
}
//建立消息页面
function doGetChatMessageBox(btn){
	var realatedId = $(btn).parent().find("#relatedId").val();
	var relatedUserId = $(btn).parent().find("#relatedUserId").val();
	$("#messageBody_id").data("realatedId",realatedId);
	$("#messageBody_id").data("relatedUserId",relatedUserId);
	var url = "toloadSendPage.do";
	$("#messageBody_id").load(url);
}

//下一页
function nextPage(){
	
}
//上一页
function previousPage(){
	
}





