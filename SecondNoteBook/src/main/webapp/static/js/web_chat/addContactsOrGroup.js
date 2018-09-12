$(document).ready(function(){
	
});
//查询联系人
function doSearchContracts(){
	var url = "doSearchContractsObjects.do";
	var searchName = $("#searchName").val();
	var param = {"searchName":searchName};
	$.post(url,param,function(result){
		if(result.state){
			console.log(result.data);
			doListContracts(result.data);
		}
	})
}
//查询联系群
function doSearchGroups(){
	var url = "doSearchGroupsObjects.do";
	var searchName = $("#searchName").val();
	var param = {"searchName":searchName};
	$.post(url,param,function(result){
		if(result.state){
			console.log(result.data);
			doListGroups(result.data);
		}
	})
}
//加载显示查询的联系人
function doListContracts(data){
	var contactsBody = $("#contactsBodyId");
	contactsBody.empty();
	var t_tableBody = $("<table class='table table-striped' style='width:600px;'></table>");
	var t_head = "<thead><tr><th>联系人昵称</th><th>年龄</th><th>性别</th><th>个人介绍</th><th>操作</th></tr></thead>";
	t_tableBody.append(t_head);
	var t_body = $("<tbody></tbody>");
	for(var i in data){
		var tr = "<tr><td><input type='hidden' id='contactId' value='"+data[i].uId+"'/>"+data[i].userName+"</td>"+
		"<td>"+data[i].age+"</td>"+
		"<td>"+data[i].sex+"</td>"+
		"<td>"+data[i].note+"</td>"+
		"<td><a href='javascript:void(0);' onclick='AddContacts(this)'>添加</a></td>"+
		"</tr>";
		t_body.append(tr);
	}
	t_tableBody.append(t_body);
	contactsBody.append(t_tableBody);
}
//添加联系人
function AddContacts(btn){
	var url = "toAddContactsObject.do";
	var contactId = $(btn).parent().parent().find("#contactId").val();
	var param = {"contactId":contactId};
	console.log(param);
	$.post(url,param,function(result){
		if(result.state){
			alert("等待对方验证");
		}else{
			alert(result.message);
		}
		
	})
}
//加载显示群信息
function doListGroups(data){
	var contactsBody = $("#contactsBodyId");
	contactsBody.empty();
	var t_tableBody = $("<table class='table table-striped' style='width:600px;'></table>");
	var t_head = "<thead><tr><th>联系群名称</th><th>最大群人数</th><th>群地点</th><th>群介绍</th><th>操作</th></tr></thead>";
	t_tableBody.append(t_head);
	var t_body = $("<tbody></tbody>");
	for(var i in data){
		var tr = "<tr><td><input type='hidden' id='groupId' value='"+data[i].groupId+"'/>"+data[i].groupName+"</td>"+
		"<td>"+data[i].maxNumber+"</td>"+
		"<td>"+data[i].groupLocal+"</td>"+
		"<td>"+data[i].note+"</td>"+
		"<td><a href='javascript:void(0);' onclick='AddGroups(this)'>添加</a></td>"+
		"</tr>";
		t_body.append(tr);
	}
	t_tableBody.append(t_body);
	contactsBody.append(t_tableBody);
}
//添加联系群
function AddGroups(btn){
	var url = "toAddGroupObject.do";
	var groupId = $(btn).parent().parent().find("#groupId").val();
	var param = {"groupId":groupId};
	console.log(param);
	$.post(url,param,function(result){
		if(result.state){
			alert("等待群主验证...");
		}else{
			alert(result.message);
		}
	})
}