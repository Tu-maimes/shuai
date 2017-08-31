<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/forget_password.css">
    <link rel="icon" href="favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body>
    <header>
        <div class="container">
            <img src="static/img/logo.png" alt="智游">
        </div>
    </header>
    <main>
        <div class="container">
            <form class="ma" action="front/user/forgetpwd.do" method="post" id="regForm">
                <div class="form_header">
                    <div class="form_title">
                        <h2>忘记密码</h2>
                        <span>通过注册邮箱重设密码</span>
                    </div>
                    <div class="form_back">
                        <a href="front/user.do">返回立即登录</a>
                    </div>
                </div>
                <div class="form_body">
                    <input type="email" placeholder="请输入登录邮箱" name="email" id="email">
                    <input type="text" placeholder="请输入验证码" name="captcha"><span style="color: red; font-size: 15px;" id="denglu"></span>
                    
                    <input type="button" value="发邮件获取验证码" onclick="submitEmail();">
                    <input type="submit" value="提交">
                </div>
                <div class="form_footer">
                    <div class="FAQ">
                        <span>收不到邮件？查看</span><a href="https://jingyan.baidu.com/article/0bc808fc67f8ce1bd485b9bc.html">常见问题</a>
                    </div>
                </div>
            </form>
        </div>
        
    </main>
<%@include file="../include/script.html"%>
    <script type="text/javascript">
		function submitEmail(){
			var email = $('#email').val();
			//改为ajax提交邮箱
			if(email!=null&&email!=''){
				$.post('sendemail.do',{email:email},function(data){
					console.log(data);
					if(data=="success"){
						alert('验证码以发送请查看邮箱');
					
					}else{
						alert('验证码发送失败：'+data.message);
					}
				},'text');
			}
		}
		
		$('#regForm').validate({
			submitHandler:function(form){
				//ajax提交注册信息，并且返回注册结果
				console.log($('#regForm').serialize());
				//使用ajax的post方法提交注册信息
				$.post(
						'front/user/forgetpwd.do',
						$('#regForm').serialize(),
						function(result){
					console.log(result);
					if(result=="success"){
						//注册成功,刷新页面
						location="front/user/forget.do";
					}else{
						$("#denglu").text("验证码错误");
					}
				},'text');
				
			},
			rules:{//写校验规则的
				email:{
					required:true,
					email:true,
					minlength:3
				},
				captcha:{
					required:true,
					minlength:4,
					maxlength:4
				}
				
			},
			messages:{//写提示信息的
				email:"账户必须是邮箱",
				captcha:'验证码必须四位'
				
			}
		});	
    </script>
</body>

</html>