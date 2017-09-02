<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/profile.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-confirm.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"/></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"/></script>
    <script src="${pageContext.request.contextPath}/js/jquery-confirm.js"></script>
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
    <script type="text/javascript">
    $(function(){
    	$('#upload_form').validate({
    		/* submitHandler:function(form){
    			//ajax提交注册信息，并且返回注册结果
    			console.log($('#regForm').serialize());
    			//使用ajax的post方法提交注册信息
    			$.post(
    					'front/user/regist.do',
    					$('#regForm').serialize(),
    					function(result){
    				console.log(result);
    				if(result=="success"){
    					//注册成功,刷新页面
    					location.reload();
    				}else{
    					$("#denglu").text("此邮箱已存在,请更换邮箱");
    				}
    			},'text');
    			
    		}, */
    		rules:{//写校验规则的
    			
    			image_file:{
    				required:true,
    				minlength:3
    			}
    		},
    		messages:{//写提示信息的
    			
    			image_file:'没有选择图片',
    			
    		}
    	});	
    });
    
    
    
    </script>
</head>

<body class="w100">
    <jsp:include page="uheader.jsp"></jsp:include>
    <main>
        <div class="container">
            <h2>我的资料-修改头像</h2>
            <div id="profile_tab">
               <ul class="profile_tab_header f_left clearfix">
                   <li><a href="front/user/profile/${_front_user.id}.do">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/avatar/${_front_user.id}.do">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/password/${_front_user.id}.do">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                            <c:if test="${empty user.headUrl}">
                                 <img  src="static/img/avatar_lg.png">
                            </c:if>
                            
                            <c:if test="${not empty user.headUrl}">
                                  <img width="200px" height="200px" src="${user.headUrl}">
                            </c:if>
                            
                            
                            <p style="text-align: center;">当前头像</p>
                        </div>
                        <div class="profile_ifo_area">
                            <form id="upload_form" enctype="multipart/form-data" method="post" action="front/user/avatar.do" >
                                <p>请选择图像文件</p>
                                <div>
                                <input type="file" class="form-control" name="image_file" id="image_file" accept="image/png,image/jpeg,image/jpg" /><span style="color: red; font-size: 15px;" id="spanid"></span>
                                <input class="btn btn-primary submitDl" type="submit" value="上传" />
                                <input type="hidden" name="id" value="${_front_user.id}">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="ufooter.jsp"></jsp:include>
</body>
<!-- 此处必须引入低版本的jquery，引入1.12.4版本，有问题 -->
<%@include file="../include/script.html"%>

</html>