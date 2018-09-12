<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>

<script type="text/javascript">
var words = $("#words");
var realatedId;
var relatedUserId;
$(document).ready(function(){
	realatedId = $("#messageBody_id").data("realatedId");
	relatedUserId = $("#messageBody_id").data("relatedUserId");
})
	
	websocket.onopen = function(event) {
    	console.log("WebSocket:打开连接 ");
    	console.log(event);
    	onopen(event);
    	};
    websocket.onmessage = function(event) {
    	console.log("WebSocket:接收消息 ");
    	console.log(event);
    	onmessage(event);
    	};
    websocket.onerror = function(event) {
    	console.log("WebSocket:发生错误 ");
    	console.log(event);
    	onerror(event);
    	};
    websocket.onclose = function(event) {
    	console.log("WebSocket:关闭连接 ");
    	console.log(event);
    	onclose(event);
    	};
	
	function onopen(evt) {
	    console.log("onOpen:"+evt.Data);
	}
	
	function onmessage(evt) {
		var data=JSON.parse(evt.data);
		console.log("接收消息为:"+data);
		var atalk = "<div class='atalk'><span id='asay'>"+data.fromUser.nickName+"&nbsp;&nbsp; : "+data.message+"</span></div>";
		words.append(atalk);
	}
	function onerror(evt) {
		
	}
	
	function onclose(evt) {}
	
    function doSend() {
        if (websocket.readyState == websocket.OPEN) {
        	var text = $("#inputMsg").val();
        	var msg = {"toUserId":relatedUserId,
        			"relatedId":realatedId,
        			"message":text};
            var btalk = "<div class='btalk'><span id='bsay'>"+text+"&nbsp;&nbsp; : 我</span></div>";
            words.append(btalk);
            console.log(msg);
            websocket.send(JSON.stringify(msg));//调用后台handleTextMessage方法
          /*  var url = 'toSendToUserMessage.do';
            $.post(url,msg,function(result){
            	if(result.state){
            		 alert("发送成功!"); 
            	}
            }); */
           
        } else { 
            alert("连接失败!");
        }  
    }
</script>
	<div class="panel panel-default" id="messageBodyId">
		
		<div class="panel-body">
			<div class="talk_show" id="words">
				<!-- <div class="atalk"><span id="asay">A说：吃饭了吗？</span></div>
				<div class="btalk"><span id="bsay">B说：还没呢，你呢？</span></div> -->
			</div>
		</div>
	</div>
	<div class="talk_input">
	
		<div class="col-lg-6" >
			<div class="input-group" style="margin:auto;padding:auto;">
			
				<input type="textarea" class="form-control" style="width:500px;" id="inputMsg" name="inputMsg">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" onclick="doSend();">发送</button>
				</span>
			</div>
			</div>
		</div>
		
	</div>
