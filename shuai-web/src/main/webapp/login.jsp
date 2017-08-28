<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台登录界面</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"/></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/messages_zh.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"/></script>
	<style>
		.container{
			width: 360px;
			height: 280px;
			padding-top: 20px;
   			 padding-bottom: 40px;
   			margin-top: 200px;
   			 text-align: center;
		}
	</style> 
	<script type="text/javascript">
	$(function(){
		$("#checkForm").validate({
			rules:{
				loginName:{
							required:true,
						
							minlength:4
							},
							loginPwd:{
								required:true,
							
								minlength:1
								}
					},
			messages:{
				loginName:{
							required:"用户名不能为空",
						
							minlength:"长度不能少于4位"	
							},
							loginPwd:{
								required:"密码名不能为空",
							
								minlength:"长度不能少于6位"	
								}
								
					}
		});
	});
	
	
	
	
	
	
	</script>     	
    
  </head>
 	<body>

    <div class="container">
			<img src="${pageContext.request.contextPath }/img/logo.png"/>
      <form class="form-signin" action="admin/login.action" method="get" id="checkForm">
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name="loginName" value="admin" class="form-control"  placeholder="请输入管理员账号" required="" autofocus="" style="border-color: #419641;">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="loginPwd" value="3" class="form-control" placeholder="请管理员密码" required="" style="border-color: #419641;">
        <p style="color: red; font-size: 15px;">${error}</p>
        <div class="checkbox">
            <input type="checkbox" name="remember-me">记住密码
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="background-color: #67B168;">登录</button>
      </form>

    </div> 
  

</body>
</html>
