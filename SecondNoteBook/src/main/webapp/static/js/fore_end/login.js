$(document).ready(function(){
	$("#usernameId").validatebox({
		 required: true,  
		 validType:'nameRule',  
         missingMessage: '用户名不能为空.' 
	});
	$("#passwordId").validatebox({
		required:true,
		missingMessage:'密码不能为空'
	});
	 $.extend($.fn.validatebox.defaults.rules, {      
		 nameRule : {// 验证中文  
                 validator : function(value) {  
                     return /^[a-zA-Z][a-zA-Z0-9_]{2,8}$/i.test(value)  
                 },  
                 message : '用户名不合法（字母开头，允许3-9字符，允许字母数字下划线）' 
             }   
     }); 
	$("#login-form").form({
		url : "login.do",
		onSubmit: function(){
			var isValid = $(this).form('validate');
			return isValid;
		},
		success: function (data){
			//json字符串转为json对象
			var result = $.parseJSON(data);
			if(result.state){
				alert(result.message+",3秒后跳转主页")
				setTimeout(window.location.href='/SecondNoteBook/fore_end/toIndex.do',3000); 
			}
		}
	});
});