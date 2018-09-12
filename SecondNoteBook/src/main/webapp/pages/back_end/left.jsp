<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>产品管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a id="load-prod-id"><i class="fa fa-circle-o"></i>商品管理</a></li>
             <li><a id="load-demand-id"><i class="fa fa-circle-o"></i>需求单管理</a></li>
            <li><a id="load-order-id"><i class="fa fa-circle-o"></i>订单管理</a></li>
            <li><a id="load-leftmessage-id"><i class="fa fa-circle-o"></i>留言管理</a></li>
            <li><a id="load-prodreview-id"><i class="fa fa-circle-o"></i>上架审核管理</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>用户管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a id="load-role-id"><i class="fa fa-circle-o"></i>角色管理</a></li>
            <li><a id="load-permission-id"><i class="fa fa-circle-o"></i>权限管理</a></li>
            <li><a id="load-user-id"><i class="fa fa-circle-o"></i>用户管理</a></li>
            <li><a id="load-userreview-id"><i class="fa fa-circle-o"></i>用户审核管理</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>聊天管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a id="load-contacts-id"><i class="fa fa-circle-o"></i>联系人管理</a></li>
            <li><a id="load-group-id"><i class="fa fa-circle-o"></i>联系群管理</a></li>
            <li><a id="load-groupreview-id"><i class="fa fa-circle-o"></i>业务管理</a></li>
          	<li><a id="load-groupreview-id"><i class="fa fa-circle-o"></i>留言管理</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
<script type="text/javascript">
//前往商品管理界面
$('#load-prod-id').click(function(){
	var url="tolistProdUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
//前往需求单管理界面
$('#load-demand-id').click(function(){
	var url = "tolistDemandUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
//前往订单管理界面
$('#load-order-id').click(function(){
	var url="tolistOrderUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
//前往留言管理界面
$('#load-leftmessage-id').click(function(){
	var url="toListMessageUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
//前往上架审核管理
$('load-prodreview-id').click(function(){
	var url = "tolistProdReviewUI.do";
	$(".content").load(url);
})
//前往角色管理界面
$('#load-role-id').click(function(){
	var url="tolistRoleUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
//前往权限管理界面
$('#load-permission-id').click(function(){
	var url = "tolistPermissionUI.do";
	$(".content").load(url);
})
//前往用户管理界面
$('#load-user-id').click(function(){
	var url="tolistUserUI.do?t="+Math.random(1000);
	$(".content").load(url);
})

//前往会员审核管理界面
$('#load-userreview-id').click(function(){
	var url="tolistUserReviewUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
//前往联系人管理界面
$('#load-contacts-id').click(function(){
	var url="tolistContactsUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
//前往群管理界面
$('#load-group-id').click(function(){
	var url="tolistGroupsUI.do?t="+Math.random(1000);
	$(".content").load(url);
})

//前往审核管理界面
$('#"load-groupreview-id"').click(function(){
	var url="tolistGroupRevicewUI.do?t="+Math.random(1000);
	$(".content").load(url);
})
</script>





