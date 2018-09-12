<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style type="text/css">
        .img-div{
            border: 1px solid #ddd;
            border-radius: 100%;
            float: left;
            line-height: 1;
            margin-left: 5px;
            overflow: hidden;
        }
</style>
<script src="${basePath}/static/js/fore_end/shelve_prod.js"></script>
<script type="text/javascript">
function doSubmitData(){
	var url = "toSubmitProd.do";
	var param = {"buyType":$(".space input[name='deal_type']:checked").val(),
			"prodType":$("#id_prodType option:selected").val(),
			"prodName":$("#id-prodName").val(),
			"title":$("#id_title").val(),
			"prodPrice":$("#id_price").val(),
			"note":$("#id_description").val(),
			"warranty":$("#id-warranty option:selected").val(),
			"city":$("#province option:selected").text()+"-"+$("#city option:selected").text(),
			"phoneNumber":$("#id_phone").val(),
			"contactName":$("#id-person").val()
			};
	$.post(url,param,function(result){
		if(result.state){
			alert(result.message);
			var id = result.data;
			var uploadImages = new FormData();
			uploadImages.append("id",id);
			var imgs = document.getElementById("xdaTanFileImg");
			var imgList = imgs.files;
		   for(var i in imgList){
			   uploadImages.append("img"+i,imgList[i]);
		   }
		   console.log(uploadImages);
	        $.ajax({  
	            url:'uploadImgs.do',  
	            type:'POST',  
	            data:uploadImages,  
	            async: false,    
	            cache: false,   
	            contentType: false, //不设置内容类型  
	            processData: false, //不处理数据  
	            success:function(data){  
	                console.log(data);
	            },  
	            error:function(){  
	                alert("上传失败！");  
	            }  
	        });
		}
	})
	
}
</script>
<form  target="_self" id="itemForm" action="" enctype="multipart/form-data">
<table style="margin: auto" id="table_id" cellspacing="0" cellpadding="0" border="0" width="980px;">
		<tr id="id_tr_deal_type">
			<td width="1%"><i> * </i></td>
			<td width="11%">交易方式</td>
			<td class="space">
				<label for="id_deal_type_0">
					<input id="id_deal_type_0" name="deal_type" type="radio" value="1" checked="" autocomplete="off"><span>在线竞拍</span>
				</label>
				<label for="id_deal_type_2">
					<input id="id_deal_type_2" name="deal_type" type="radio" value="2" autocomplete="off"><span>线下交易</span>
				</label>
				<label for="id_deal_type_3">
					<input id="id_deal_type_3" name="deal_type" type="radio" value="3" autocomplete="off"><span>物品交换</span>
				</label>
				<span id="tip_span_deal_type"></span>
			</td>
		</tr>
		<tr id="id_prodType">
					<td width="2%"><i> * </i></td>
					<td width="10%">品牌</td>
					<td width="88%" class="d-sel-bd">
                    <span>
	                 	<select name="prodType" type="select" id="id_prodType" autocomplete="off">
							<option value="">请选择</option>
							<option value=苹果>苹果</option>
							<option value=ThinkPad>ThinkPad</option>
							<option value=华硕>华硕</option>
							<option value=联想>联想</option>
							<option value=宏碁>宏碁</option>
							<option value=戴尔>戴尔</option>
							<option value=神舟>神舟</option>
							<option value=惠普>惠普</option>
							<option value=微软>微软</option>
							<option value=索尼>索尼</option>
							<option value=三星>三星</option>
							<option value=东芝>东芝</option>
							<option value=机械革命>机械革命</option>
							<option value=Alienware>Alienware</option>
							<option value=雷神>雷神</option>
							<option value=其他品牌>其他品牌</option>
						</select>
						 &nbsp;&nbsp; &nbsp;
						 *商品名称：
						 <input class="easyui-validatebox" id="id-prodName" type="text" width="120" name="prodName" data-options="required:true,validType:'length[3,10]'" value=""/>
                    </span>
						<span id="tip_span_district"></span>
					</td>
				</tr>
		<tr id="id_tr_title">
			<td><i> * </i></td>
			<td>标题</td>
			<td><label for="textfield"></label>
				<input value="" name="title" type="text" id="id_title" size="45" maxlength="30" class="input1 easyui-validatebox" data-options="required:true">
				<span id="tip_span_title"></span>
			</td>
		</tr>

		<tr id="id_tr_price">
			<td><i> * </i></td>
			<td>价格</td>
			<td>
				<input value="" name="price" type="text" id="id_price" size="4" maxlength="6" class="input2 js-price-listen easyui-validatebox" data-options="required:true">
				&nbsp;元
				<span id="tip_span_price"></span>
			</td>
		</tr>

		<tr>
			<td valign="top"><i> * </i></td>
			<td valign="top">描述</td>
			<td>
				<table cellspacing="0" cellpadding="0" border="0" class="normal">
					<tbody><tr>
						<td>
							<textarea name="description" type="textarea" id="id_description" class="textarea1 easyui-validatebox" data-options="required:true" rows="6" autocomplete="off"></textarea>
						</td>
						<td><span id="tip_span_description"></span></td>
					</tr>
				</tbody></table>
			</td>
		</tr>
	
		<tr id="id_warranty" >
			<td width="2%"><i> * </i></td>
			<td width="10%">是否保修</td>
			<td width="88%" class="d-sel-bd">
				<select id="id-warranty" name="warranty" type="select" class="w-98">
					<option value="-1">请选择</option>
					<option value="1">保修</option>
					<option value="2">不保修</option>
				</select>
			</td>
		</tr>
		<tr>
			<td valign="top">&nbsp;</td>
			<td valign="top">上传照片</td>
			<td style="width:660px;">
				<div class="ui-uploader" id="uploader_container">
					<input type="file" id="xdaTanFileImg"  multiple="multiple"  name="fileAttach" onchange="xmTanUploadImg(this)"/>
					<div class="img-box" id="imgboxid"></div>
					<span class="ui-uploader-message" style="margin-left: 0">最多15张，可多选上传，最大10MB。有图可使浏览量增加3倍，并会在推荐位显示。</span>
					<ul class="ui-uploader-thumbImages ui-uploader-sortable"></ul>
				</div>
				<input id="input_upload_image" type="hidden" name="images">
			</td>
		 </tr>
				<tr id="id_tr_district">
					<td width="2%"><i> * </i></td>
					<td width="10%">地点</td>
					<td width="88%" class="d-sel-bd">
                    <span>
	                 	<select id="province" name="provice" onchange="chooseProvince(this)">  
    						<option id="option_prov" value="1">请选择省</option>  
						</select>  
						  
						<select id="city" name="city" onChange="chooseCity(this)">  
						    <option id="option_city" value="1">请选择市</option>  
						</select>  
						  
						<select id="area" name="area">  
						    <option id="option_area" value="1">请选择区</option>  
						</select> 
                    </span>
					</td>
				</tr>
				
				<tr>
					<td><i> * </i></td>
					<td id="change_phone">手机号码</td>
					<td width="88%">
						<input value="" name="phone" type="text" id="id_phone" size="20" class="input1 easyui-validatebox" data-options="required:true" maxlength="30">
						<span class="tips_wrap"><span id="tip_span_phone"></span></span>
					</td>
				</tr>
				
				<tr>
					<td><i> * </i></td>
					<td>联系人</td>
					<td><input id="id-person" value="" name="person" type="text" size="20" class="input1 easyui-validatebox" data-options="required:true" maxlength="6">
						<span id="tip_span_person"></span>
					</td>
				</tr>
				<tr>
					<td valign="top"><i>*</i></td>
					<td valign="top">发布人</td>
					<td valign="top" id="id_agent" class="space">
						<label for="id_agent_0"><input id="id_agent_0" name="agent" type="radio" value="0" autocomplete="off" checked="">个人</label>
						<label for="id_agent_1"><input id="id_agent_1" name="agent" type="radio" value="1" autocomplete="off">商家</label>
					</td>
				</tr>
					
				<tr>
					<td></td>
					<td></td>
					<td>
					<input type="button"  class="btn btn-success submit_btn" value="提交商品" onclick="doSubmitData()" />
					<td>
				</tr>
	</table>
</form>
