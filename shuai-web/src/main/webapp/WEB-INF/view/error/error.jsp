<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body background="/pic/859c734b37284c5e856163b068f78508.jpg" style="width=100%;height=100%;background-repeat:no-repeat;" >
	<div class="box">
	出事了!<br>
	${req}<br>
	${res}<br>
	出事地点:${obj}<br>
	错误原因:${error.message}<br>
	</div>
</body>
</html>