<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="bbq" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <title>视频列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"/></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"/></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-confirm.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/css/jquery-confirm.css"></script>
   <script type="text/javascript">
   $(function(){
	    var count = 0;
	    var countp =0;
	      	$(".clickk").click(function(){
	      		 if(this.checked==true){
	      			count++;
	      		}else{
	      				count--;
	      		}
	      		$(".badge").text(count);
	      		 if(count==$(".clickk").length){
	      			$(".allcheckbox")[0].checked=true;
	      		}else{
	      			$(".allcheckbox")[0].checked=false;
	      			
	      		}
	      	});
	      	
	      	$(".allcheckbox").click(function(){
	      		$.each($(".clickk"),function(i){
	      		if($(".allcheckbox")[0].checked){
	      			 $(".clickk")[i].checked = true;
	      			count=$(".clickk").length;
	      		}else{
	      			$(".clickk")[i].checked = false;
	      			count=0;
	      		} 
	      		});
	      	$(".badge").text(count);
	      	});
	      	
	      });
   </script> 
  </head>
  <body>
  	    <nav class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">视频管理系统</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="#">视频管理</a></li>
	            <li><a href="${pageContext.request.contextPath}/speaker/speakerList.action">主讲人管理</a></li>
	            <li><a href="${pageContext.request.contextPath}/course/courseList.action">课程管理</a></li>
				<li><a href="${pageContext.request.contextPath}/statistics.action">统计分析</a></li>
	          </ul>
	        
		        <div id="navbar" class="navbar-brand navbar-right" >
		           <a href="#">${admin.loginName}</a><a href="${pageContext.request.contextPath}/admin/loginout.action" class="glyphicon glyphicon-log-out"></a>
		        </div>
	        
	        </div>
	      </div>
	    </nav>
	   
	    
	    <div class="container theme-showcase" role="main">
	    	
		    <div class="jumbotron">
		        <h3>视频列表-视频管理</h3>
		    </div>
		    
		  
		    <div style="float: right;">
	          <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/video/videoList.action">
	            <div class="form-group">
	              <input type="text" placeholder="视频标题" class="form-control"name="vodeoTitle" value="${vodeotitle1 }">
	            </div>
	            <div class="form-group">
	            	<select name="speaker">
    				<option value="0">请选择主讲人</option>
					<c:forEach var="de" items="${speaker1}">
					<option value="${de.id}"${ de.id==speaker2?"selected":"" }>${de.speakerName}</option>
					</c:forEach>
					</select>
	            </div>
	            <div class="form-group">
	            	<select name="course">
    				<option value="0">请选择所属课程</option>
					<c:forEach var="de" items="${course1}">
					<option value="${de.id}"${ de.id==course2?"selected":"" }>${de.courseName}</option>
					</c:forEach>
					</select>
	            </div>
	            <button type="submit" class="btn btn-primary">查询</button>
	          </form>
        	</div>
        	
        	
        	
		    <form action="${pageContext.request.contextPath}/video/deleteAll.action">
		     <a href="${pageContext.request.contextPath}/video/videoadd.action"><button type="checkbox" class="btn btn-primary">添加视频</button></a>
			<button type="submit" class="btn btn-primary" onclick = "return shouconfirm()">
		    <font color="white">批量删除</font>&nbsp;&nbsp;<span class="badge">0</span></button>
			<div class="bs-example" data-example-id="hoverable-table">
			    <table class="table table-hover">
			      <thead>
			        <tr>
			          <th class="col-md-1">全选/不选<input type="checkbox" class="allcheckbox"/></th>
			          <th class="col-md-0">序号</th>
			          <th class="col-md-1">名称</th>
			          <th class="col-md-8">介绍</th>
			          <th class="col-md-1">讲师</th>
			          <th class="col-md-1">课程</th>
			          <th class="col-md-0">时长(秒)</th>
			          <th class="col-md-0">播放次数</th>
			          <th class="col-md-0">编辑</th>
			          <th class="col-md-0">删除</th>
			        </tr>
			      </thead>
			      <tbody>
			        
			        <c:forEach var="video" items="${page.rows}" varStatus="status">
			        <tr>
			          <td><input type="checkbox" name="thecheckbox"  class="clickk" value="${video.id}"></td>
			          <td>${status.count }</td>
			          <td>${video.videoTitle}</td>
			          <td>${video.videoDescr}</td>
			          <td>${video.speakerName}</td>
			          <td>${video.courseName}</td>
			          <td>${video.videoLength}</td>
			          <td>${video.videoPlayTimes}</td>
			          <td><a href="${pageContext.request.contextPath}/video/${video.id}.action" class="glyphicon glyphicon-edit"></a></td>
			          <%-- <td><a class="glyphicon glyphicon-trash" title="删除" onclick="shouconfirm(${video.id})"></a></td> --%>
			          <td><a href="${pageContext.request.contextPath}/video/delete/${video.id}.action" onclick = "return shouconfirm()" class="glyphicon glyphicon-trash"></a></td>
			        </tr>
			          </c:forEach>
			         
			      </tbody>
			    </table>
			</div>
			</form>
		</div>
			<bbq:page url="${pageContext.request.contextPath}/video/videoList.action"></bbq:page>
  </body>
</html>