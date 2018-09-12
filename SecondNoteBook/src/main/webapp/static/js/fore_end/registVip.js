$(document).ready(function(){
	$("#name").validatebox({
		 required: true,  
		 validType:'chinese',  
         missingMessage: '请输入合法的姓名.' 
	});
	$("#idCard").validatebox({
		required:true,
		validType:'idCard',
		missingMessage:'请输入身份证号码'
	});
	$("#phoneNumber").validatebox({
		required:true,
		validType:'mobile',
		missingMessage:'请输入手机号码'
	});
	
	 $.extend($.fn.validatebox.defaults.rules, {      
		 chinese : {// 验证中文  
             validator : function(value) {  
                 return /^[\u0391-\uFFE5]{2,7}$/i.test(value);  
             },  
             message : '请输入合法的中文名字'  
         },
         idcard: {// 验证身份证
             validator: function (value) {
                 return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
             },
             message: '身份证号码格式不正确'
         },
         mobile: {// 验证手机号码
             validator: function (value) {
                 return /^(13|15|18)\d{9}$/i.test(value);
             },
             message: '手机号码格式不正确'
         }
     }); 
	
});
//获取手机短信验证码
function doGetCode(){
	var phoneNumber = $("#phoneNumber").val();
	if(!phoneNumber){
		alert("请输入手机号");
		return;
	}
	
	$("#code_id").attr("disabled",'disabled');
	
	var url = "toGetMobileCode.do";
	var param = {"phoneNumber":phoneNumber};
	$.post(url,param,function(result){
		if(result.state){
			console.log(result.data);
			$(".form-horizontal").data("uuId",result.data.uuId);
			console.log(result.data.uuId);
			doSetTime();
		}else{
			alert(result.message);
		}
	})
}
//设置定时
var timeOut = 60;
function doSetTime(){
	console.log(timeOut);
	if(timeOut>0){
		$("#code_id").val("已发送，剩余("+timeOut+"秒)");
	}else{
		$("#code_id").removeAttr("disabled");
		$("#code_id").val("重新获取验证码");
		timeOut = 60;
		return;
	}
	timeOut--;
	setTimeout(doSetTime,1000);
}
//校验手机验证码
function checkMobilePhone(){
	var uuId = $(".form-horizontal").data("uuId");
	console.log(uuId);
	var phoneNumber = $("#phoneNumber").val();
	var code = $("#code_val_id").val();
	var url = "toCheckPhoneCode.do";
	var param = {"uuId":uuId,"code":code,"phoneNumber":phoneNumber};
	$.post(url,param,function(result){
		console.log(result);
		if(result.state){
			doSubmitApplyInfo();
		}else{
			$("#code_message").text("验证码不对!");
			
		}
	})
}
//提交信息
function doSubmitApplyInfo(){
	
	var url = "toSubmitVipData.do";
	var param = {"name":$("#name").val(),
			"age":$("#age").val(),
			"sex":$("#sex_id checked:checked").text(),
			"education":$("#education_id option:selected").val(),
			"idCard":$("#idCard").val(),
			"phoneNumber":$("#phoneNumber").val(),
			};
	$.post(url , param , function(result){
		if(result.state){
			alert("提交成功，正在审核!");
			setTimeout(window.location.href="/SecondNoteBook/fore_end/toIndex.do",3000);
		}else{
			alert("注册信息有误!");
		}
	})
}
//校验注册信息
function doSubmitApplyVip(){
	//页面非空校验
	
	//校验身份证信息
	
	//校验手机号信息
	checkMobilePhone();
}











