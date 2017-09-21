<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Studentlist.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/jPages.css">
<script src="js/jquery-3.1.1.min(1).js"></script>
<script src="js/jPages.js"></script>
<script src="layer-v3.0.3/layer/layer.js"></script>
<script src="layui-v1.0.9_rls/layui/layui.js"></script>
<link href="layer-v3.0.3/layer/skin/default/layer.css" type="text/css" rel="stylesheet"/>
<link href="layui-v1.0.9_rls/layui/css/layui.css" type="text/css" rel="stylesheet"/>
<style>
body {
	background-image: url("image/usermanage.jpg");
}

.search-wrap {
	padding: 15px 0;
	margin: 20px 130px;
}

#item {
	text-align: left;
	margin-top: 20px;
	margin-left: 20px;
	width: 1650px;
	height: 50px;
}

.btn-primary {
	height: 30px;
	width: 100px;
	color: #ffffff;
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
	background-color: #006dcc;
	*background-color: #0044cc;
	background-image: linear-gradient(to bottom, #0088cc, #0044cc);
	background-repeat: repeat-x;
	border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
	color: #ffffff;
}

.common-text {
	height: 23px;
	line-height: 23px;
	padding: 2px 4px;
	border: 1px solid #ccc;
	background: #fff;
	border-radius: 5px;
}

select {
	width: 100px;
	height: 23px;
	border-radius: 5px;
}

.result-wrap {
	padding: 10px 20px;
	margin-left: 110px;
	margin-top: -45px;
}

.result-title {
	line-height: 35px;
	padding-bottom: 10px;
	overflow: hidden;
}

.result-list a {
	margin-right: 15px;
}

.result-list i {
	padding-right: 5px;
}

.result-tab {
	width: 1480px;
	border-collapse: collapse;
	border: 1px solid #ddd;
}

.result-tab th {
	font-weight: normal;
	font-size: 15px;
	text-align: left;
	background: url(Image/tab-thbg.png) #f9f9f9 0 bottom repeat-x;
}

.result-tab th,.result-tab td {
	padding: 5px;
	border-bottom: 1px solid #ddd;
	border-right: 1px solid #e1e1e1;
}

.result-tab tr {
	line-height: 35px;
}

.result-tab th.tc,.result-tab td.tc {
	text-align: center;
}

.result-tab tr:nth-child(odd) {
	background: #f9f9f9;
}

.result-tab tr:hover {
	background: #f1f1f1;
}

.result-tab tr.even-tr {
	background: #e9fff2;
}
</style>
<script>
	$(function() {
		$("div.holder").jPages({
			containerID : "movies", //存放表格的窗口标签ID
			previous : "←前一页", //指示首页的按钮
			next : "后一页→",//指示尾页的按钮
			perPage : 10,//每页显示表格的行数
			delay : 0
		//分页时动画持续时间，0表示无动画
		});
	});
</script>
<script language="JavaScript">
	$(document).ready(function() {
		 $("#searchbutton").click(function(){
		 	var sort =$("#search-sort").val();
		 	var menuname = $("#menuname").val();
			window.location.href="searchcourse.action?sort="+sort+"&menuname="+menuname;
		});
		$("#tongji").click(function(){
		 	var tab = document.getElementById("t1");
			var rows = tab.rows.length;
			for(var i=1;i<=rows;i++)
			{
				var cid = $("#t1 tr:eq(" + i + ") td:eq(0)").text();
				$.ajax({
		   			url:"coudetail",
		   			type:"GET",
		   			async:false,
		   			data:{"cid":cid},
		   			success:function(data)
		   			{
		   				var str=data.split(",");
		   				$("#t1 tr:eq(" + i + ") td:eq(2)").text(str[1]);
		   				$("#t1 tr:eq(" + i + ") td:eq(3)").text(str[2]);
		   				$("#t1 tr:eq(" + i + ") td:eq(4)").text(str[0]);
		   			}
	   			});
	   		}
		 	
		});
	});
</script>
</head>

<body>
<div class="search-wrap">
	<form class="layui-form">
		<div class="layui-form-item">
			<a id="tongji" class="layui-btn" href='javascript:void(0)'> <i
				class="layui-icon">&#xe63c;</i>开始统计 </a>
		</div>
	</form>
	</div>
	<div class="result-wrap">		
		<s:set name="course" value="#request.course" />
		<s:if test="#course.size != 0">
			<div class="result-content">
				<table class="result-tab" id="t1">
					<thead>
						<tr>
							<th>课程编号</th>
							<th>课程名称</th>
							<th>最高分</th>
							<th>最低分</th>
							<th>平均分</th>
						</tr>
					</thead>
					<s:iterator value="#course" id="cou">
						<tbody id="movies">
							<tr>
								<td><s:property value="#cou.cid" /></td>
								<td><s:property value="#cou.cname" /></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</tbody>
					</s:iterator>
				</table>
			</div>
		</s:if>
	</div>
	<div class="holder" style="margin-left: 760px;"></div>
</body>
</html>
