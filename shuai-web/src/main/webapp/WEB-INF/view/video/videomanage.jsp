<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改视频</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"/></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"/></script>
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
		        <h3>修改视频-视频管理</h3>
		    </div>
		    <form action="${pageContext.request.contextPath}/video/videomanage.action" method="get" class="form-horizontal">
		      <div class="form-group">
		        <label for="inputEmail3" class="col-sm-2 control-label">视频标题:</label>
		        <div class="col-sm-10">
		          <input type="text" class="form-control" name= "videoTitle"  value = "${video.videoTitle}">
		        </div>
		      </div>
		      <div class="form-group">
		        <label for="inputPassword3" class="col-sm-2 control-label">主讲人:</label>
		        <div class="col-sm-10">
				          <select class="form-control" name="speakerId">
							<c:forEach var="de" items="${speaker1}">
							<option value="${de.id}"${ de.id==video.speakerId?"selected":"" }>${de.speakerName}</option>
							</c:forEach>
							</select>
		        </div>
		      </div>
		      <div class="form-group">
		        <label for="inputEmail3" class="col-sm-2 control-label">所属课程:</label>
		        <div class="col-sm-10">
				          <select class="form-control" name="courseId">
							<c:forEach var="de" items="${course1}">
							<option value="${de.id}"${ de.id==video.courseId?"selected":"" }>${de.courseName}</option>
							</c:forEach>
							</select>
		        </div>
		      </div>
		      <div class="form-group">
		        <label for="inputPassword3" class="col-sm-2 control-label">视频时长:</label>
		        <div class="col-sm-10">
		          <input type="text" class="form-control" name="videoLength" value="${video.videoLength}">
		        </div>
		      </div>
		      <div class="form-group">
		        <label for="inputEmail3" class="col-sm-2 control-label">封面图片:</label>
		        <div class="col-sm-10">
		          <input type="text" class="form-control" name="videoImageUrl" value="${video.videoImageUrl}">
		        </div>
		      </div>
		      <div class="form-group">
		        <label for="inputPassword3" class="col-sm-2 control-label">视频播放地址:</label>
		        <div class="col-sm-10">
		          <input type="text" class="form-control" name="videoUrl" value="${video.videoUrl}">
		        </div>
		      </div>
		      <div class="form-group">
		        <label for="inputEmail3" class="col-sm-2 control-label">视频简介:</label>
		        <div class="bs-example" data-example-id="textarea-form-control">
					<textarea class="col-sm-10 " rows="2" placeholder="Textarea" name="videoDescr">${video.videoDescr}</textarea>
			</div>
		      </div>
			     <div style="text-align: center;">
			     <input type="hidden" name="id" value="${video.id}">
			  <button type="submit" class="btn btn-primary" >保存</button>
			  <a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>
			  </div>
		    </form>
		</div>
  </body>
</html>