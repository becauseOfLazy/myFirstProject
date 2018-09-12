$(document).ready(function(){
	toLoadCheckedListObject();
})
//加载需要校验的对象
function toLoadCheckedListObject(){
	var url = "toLoadCheckedListObject.do";
	$.post(url,param,function(result){
		if(result.state){
			console.log(result.data);
		}
	})
}