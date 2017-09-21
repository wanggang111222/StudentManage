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
<link href="layer-v3.0.3/layer/skin/default/layer.css" type="text/css"
	rel="stylesheet" />
<link href="layui-v1.0.9_rls/layui/css/layui.css" type="text/css"
	rel="stylesheet" />
<style>
body {
	background-image: url("image/usermanage.jpg");
}

.search-wrap {
	padding: 15px 0;
	margin: 20px 115px;
}

#item {
	text-align: left;
	margin-top: 20px;
	margin-left: 20px;
	width: 1650px;
	height: 50px;
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
	width: 305px;
	height: 35px;
}

.result-wrap {
	padding: 10px 20px;
	margin-left: 110px;
	margin-top: -35px;
}

.result-title {
	line-height: 35px;
	padding-bottom: 5px;
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
			window.location.href="studentsco.action?sort="+sort+"&menuname="+menuname;
			
		});
	});
	function seeresult() {
		var tab = document.getElementById("t1");
		var rows = tab.rows.length;
		for(var i=1;i<=rows;i++)
		{
			if($("#t1 tr:eq(" + i + ") td:eq(2)").text()<60)
			{
				$("#t1 tr:eq(" + i + ") td:eq(2)").attr("style","color:red");
			}
		}
		var sid = $("#t1 tr:eq(1) td:eq(0)").text();
		 $.ajax({
		   url:"stuperson",
		   type:"GET",
		   async:false,
		   data:{"sid":sid},
		   success:function(data)
		   {
		   	var str=data.split(",");
		   	$("#sum").text(str[0]);
		   	$("#credit").text(str[1]);
		   }
	   });
	}
</script>
</head>

<body>
	<div class="search-wrap">
		<div class="layui-form-item">
			<table class="search-tab">
				<tr>
					<th width="120"><label class="layui-form-label">选择分类：</label>
					</th>
					<td><select name="search-sort" id="search-sort"
						lay-filter="aihao">
							<option value="all">全部</option>
							<option value="sid">学生编号</option>
							<option value="sname">学生姓名</option>
					</select>
					</td>
					<th width="70"><label class="layui-form-label">关键字：</label></th>
					<td><input type="text" id="menuname" name="menuname"
						lay-verify="title" autocomplete="off" placeholder="关键字"
						class="layui-input">
					</td>
					<th width="100"><button name="sub" id="searchbutton"
							class="layui-btn layui-btn-normal">统计</button>
					</th>
				</tr>
			</table>
		</div>
	</div>
	<div class="result-wrap" id="111">
		<s:set name="score" value="#request.score" />
		<s:if test="#score.size != 0">
			<div class="result-content">
			<table class="result-tab" id="t2">
					<thead>
						<tr>
							<td>汇总信息</td>
							<td>已选课程总学分</td>
							<td id="credit">0</td>
							<td>不及格课程门数（标红显示）</td>
							<td id="sum">0</td>
							<td><a class="layui-btn" href='javascript:void(0)'
								onclick='seeresult()'> <i class="layui-icon">&#xe63c;</i>查看结果
							</a>
							</td>
						</tr>
					</thead>
				</table>
				<table class="result-tab" id="t1" style="margin-top: 20px;">
					<thead>
						<tr>
							<th>学生编号</th>
							<th >课程编号</th>
							<th >分数</th>
						</tr>
					</thead>
					<s:iterator value="#score" id="sco">
						<tbody id="movies">
							<tr>
								<td><s:property value="#sco.id.student.sid" />
								</td>
								<td><s:property value="#sco.id.course.cid" />
								</td>
								<td><s:property value="#sco.score" />
								</td>
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
