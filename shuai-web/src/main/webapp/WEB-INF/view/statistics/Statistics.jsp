<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"/></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"/></script>
<script src="${pageContext.request.contextPath}/static/echarts-all.js"></script>
<script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        $(function(){
        	
        	
        	var myChart = echarts.init($("#main")[0]); 
        
       var option = {
    title : {
        text: '课程平均播放次数',
        
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true},
             magicType : {show: true, type: ['line', 'bar', 'stack']}  
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ${name}
        }
    ],
    yAxis : [
        {
            type : 'value',
            boundaryGap: [0, 0.1]
        }
    ],
    series : [
        {
            name:'Acutal',
            type:'bar',
            stack: 'sum',
            barCategoryGap: '50%',
            itemStyle: {
                normal: {
                    color: '#0099ff',
                    barBorderColor: '#00d856',
                    barBorderWidth: 6,
                    barBorderRadius:0,
                    label : {
                        show: true, position: 'insideTop'
                    }
                }
            },
            data:${count}
        }
       
    ]
};

        // 为echarts对象加载数据 
        myChart.setOption(option); 
        	
        });
        
    </script>
<title>统计分析</title>
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
	            <li><a href="${pageContext.request.contextPath}/video/videoList.action">视频管理</a></li>
	            <li><a href="${pageContext.request.contextPath}/speaker/speakerList.action">主讲人管理</a></li>
	            <li><a href="${pageContext.request.contextPath}/course/courseList.action">课程管理</a></li>
				<li class="active"><a href="#">统计分析</a></li>
	          </ul>
	           <div id="navbar" class="navbar-brand navbar-right" >
		           <a href="#">${admin.loginName}</a><a href="${pageContext.request.contextPath}/admin/loginout.action" class="glyphicon glyphicon-log-out"></a>
		        </div>
	        
	        </div>
	      </div>
	    </nav>
	    <div class="container theme-showcase" role="main">
	    	
		    <div class="jumbotron">
		        <h3>课程数据统计分析</h3>
		    </div>
		    
		    <div id="main" style="height:400px"></div>
			
		</div>
	    

    

</body>
</html>