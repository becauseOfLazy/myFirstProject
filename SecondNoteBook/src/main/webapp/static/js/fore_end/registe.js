$(document).ready(function(){
	var code;
	document.getElementById("code").onclick=changeImg;
	changeImg();
	$("#usernameId").validatebox({
		required:true,
		 validType:'nameRule',  
        missingMessage: '用户名不能为空.' 
	});
	$("#passwordId").validatebox({
		required:true,
		missingMessage:'密码不能为空'
	});
	$("#confirmpwdId").validatebox({
		required:true,
		validType:'equalpwd',
		missingMessage:'确认密码不能为空'
	});
	$("#nicknameId").validatebox({
		required:true,
		validType:'chinese',
		missingMessage:'用户昵称不能为空'
	});
	 $('#emailId').validatebox({   
         required: true,  
         validType: 'email',  
         missingMessage: '邮件地址不能为空.',  
         invalidMessage:'请输入正确的邮件地址.'  
     }); 
	 $("#vcodeId").validatebox({
		required: false,
		validType: 'checkcodes',
		missingMessage: ''
	 });
	 $.extend($.fn.validatebox.defaults.rules, {      
		 nameRule : {// 验证中文  
                 validator : function(value) {  
                     return /^[a-zA-Z][a-zA-Z0-9_]{2,8}$/i.test(value);  
                 },  
                 message : '用户名不合法（字母开头，允许3-9字符，允许字母数字下划线）'  
             },  
         
         equalpwd : {
        	 validator : function(value){
        		 return value == $("#passwordId").val();
        	 },
        	 message : '两次密码不一致'
         },
         
         chinese : {// 验证中文  
             validator : function(value) {  
                 return /^[\u0391-\uFFE5]{2,7}$/i.test(value);  
             },  
             message : '请输入3-8中文'  
         },
         checkcodes : {
        	 validator : function(value){
        		 var inputcode = value.toUpperCase();
        		 var codes = document.getElementById('code').innerHTML.toUpperCase();
        		 
        		 return inputcode == codes;
        	 },
        	 message : ''
         }
     }); 
	 $("#registe-form").form({
		 url : "registe.do",
		 onSubmit : function(){
			 var isValid = $(this).form('validate');
				return isValid;
		 },
		 success : function(data){
			 var result = $.parseJSON(data);
			 if(result.state==1){
				 alert(result.message+",3秒后跳转登录界面")
				 setTimeout(window.location.href='toLogin.do',3000); 
			 }else{
				alert(result.message);
				window.location.href='toRegiste.do';
			}
		 }
	 });
})
function changeImg(){
	var arrays=new Array(  
            '1','2','3','4','5','6','7','8','9','0',  
            'a','b','c','d','e','f','g','h','i','j',  
            'k','l','m','n','o','p','q','r','s','t',  
            'u','v','w','x','y','z',  
            'A','B','C','D','E','F','G','H','I','J',  
            'K','L','M','N','O','P','Q','R','S','T',  
            'U','V','W','X','Y','Z'               
        );  
        code='';//重新初始化验证码    
        //随机从数组中获取四个元素组成验证码  
        for(var i=0;i<4;i++){  
        //随机获取一个数组的下标  
            var r=parseInt(Math.random()*arrays.length);  
            code+=arrays[r];  
        }  
        document.getElementById('code').innerHTML=code;//将验证码写入指定区域 
}