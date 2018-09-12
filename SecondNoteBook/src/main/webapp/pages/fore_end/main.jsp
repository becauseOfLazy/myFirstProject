<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${basePath}/static/js/fore_end/main.js"></script>

			<div id="line1">
				<div id="myCarousel" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>   
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img id="line1_1" src="" alt="First slide">
		
		</div>
		<div class="item">
			<img id="line1_2" src="" alt="Second slide">
		
		</div>
		<div class="item">
			<img id="line1_3" src="" alt="Third slide">
		
		</div>
		<div class="item">
			<img id="line1_4" src="" alt="Four slide">
		
		</div>
		<div class="item">
			<img id="line1_5" src="" alt="Fives slide">
		
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" 
	   data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" 
	   data-slide="next">&rsaquo;</a>
</div> 
				
			</div>
			
			<div id="line2">
				<div class="panel panel-info">
					<div class="panel-heading">
					        <h3 class="panel-title">热门商品</h3>
					 </div>
				</div>
				<table class="table table-bordered">
				
	 			
				  <tbody>
				    <tr>
				      <td><img width="278" height="312" id="line2_1" src=""/></td>
				      <td><img width="278" height="312" id="line2_2" src=""/></td>
				      <td><img width="278" height="312" id="line2_3" src=""/></td>
				    </tr>
				  </tbody>
				</table>	
			</div>
			
			<div id="line3">
			
		    <div class="panel panel-info">
			<div class="panel-heading">
			        <h3 class="panel-title">优惠商品</h3>
			 </div>
			</div>
			<table class="table table-bordered">
	 			  
				  <tbody>
				    <tr>
				      <td><img width="278" height="312" id="line3_1" src=""/></td>
				      <td><img width="278" height="312" id="line3_2" src=""/></td>
				      <td><img width="278" height="312" id="line3_3" src=""/></td>
				    </tr>
				  </tbody>
				</table>
			</div>
			<div id="line4">
				<div class="panel panel-default">
				    <div class="panel-heading">
				        <h3 class="panel-title">精品推荐</h3>
				    </div>
				    <div class="panel-body">
				    <span >
					<img id="line4_1" src=""/>&nbsp;&nbsp; 
					</span>
					<span >
						<img id="line4_2" src=""/>&nbsp;&nbsp;
					</span>
					<span >
						<img id="line4_3" src=""/>&nbsp;&nbsp;
					</span>
					<span>
						<img id="line4_4" src=""/>&nbsp;&nbsp;
					</span>
					<span>
						<img id="line4_5" src=""/>&nbsp;&nbsp;
					</span>
				
			         </div>
   			   </div>
				
			</div>
			<div id="line5">
				<span >
					<img id="line5_1" src=""/>&nbsp;&nbsp;新手帮助 
				</span>
				<span >
					<img id="line5_2" src=""/>&nbsp;&nbsp;商家帮助
				</span>
				<span >
					<img id="line5_3" src=""/>&nbsp;&nbsp;问题建议
				</span>
				<span>
					<img id="line5_4" src=""/>&nbsp;&nbsp;关于我们 
				</span>
			</div>
