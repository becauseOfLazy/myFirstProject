<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form id="suggestId" role="form">
	<div class="form-group">
		<label for="name">欢迎发表你的建议</label>
		<textarea class="form-control" rows="3" placeholder="请输入..."></textarea>
	</div>
	<div style="height:30px;position:relative;">
		<button style="position:absolute;bottom:0;right:0;" 
		type="button" class="btn btn-primary" data-toggle="button" onclick="doSubmit()">
		 提交建议 </button>
	</div>
</form>
<script type="text/javascript">
	function doSubmit(){
		var text = $(".form-control").val();
		var url = "toSubmitSuggest.do";
		var param = {"text":text};
		$.post(url,param,function(result){
			if(result.state){
				alert("建议提交成功!");
			}
		})
	}
</script>