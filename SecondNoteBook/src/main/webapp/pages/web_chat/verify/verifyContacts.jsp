<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="${basePath}/static/js/web_chat/checkContactOrGroup.js">
</script>
<table class="table table-striped">
  <caption>验证请求</caption>
  <thead>
    <tr>
      <th>名称</th>
      <th>类型</th>
      <th>请求</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody id="t_body_id">
   	
  </tbody>
</table>