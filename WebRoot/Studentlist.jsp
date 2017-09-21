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

.icon-font {
	font-family: 'icomoon';
	speak: none;
	font-weight: 400;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
	line-height: 1;
	-webkit-font-smoothing: antialiased;
}

@font-face {
	font-family: 'icomoon';
	src: url('fonts/icomoon.eot');
	src: url('fonts/icomoon.eot?#iefix') format('embedded-opentype'),
		url('fonts/icomoon.woff') format('woff'), url('fonts/icomoon.ttf')
		format('truetype'), url('fonts/icomoon.svg#icomoon') format('svg');
	font-weight: normal;
	font-style: normal;
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
	   $.ajax({
		   url:"showclass",
		   type:"GET",
		   datatype:"text",
		   success:function(data)
		   {
		   	var str=data.split(",");
		   	var classname=$("#classname");
		   	for(var i=0;i<str.length;i=i+2)
		  	{
		  		classname.append("<option value="+"'"+str[i]+"'"+">"+str[i+1]+"</option>");
		  	}
		   }
	   });
		$("#batchDel").click(function() {
			var msg = "您真的确定要删除吗？";
			if (confirm(msg) == true) {
				var becheckbox = "";
				$("input[name='check']").each(function() { //遍历table里的全部checkbox
					if ($(this).prop("checked")) //如果被选中
						becheckbox += $(this).val() + ","; //获取被选中的值
				});
				if (becheckbox.length > 0) //如果获取到
				{
					becheckbox = becheckbox.substring(0, becheckbox.length - 1); //把最后一个逗号去掉
					window.location = "deletestu.action?checkTnum=" + becheckbox;
				}
				else
				{
					alert("请选择一行数据");
					return false;
				}
				
			} 
			else 
			{
				return false;
			}
		});
		$("#selectall").click(function() {
	    	var chkOneObjs = document.getElementsByName("check");
	    	if ($(this).prop("checked"))
	    	{
	    		for (var i = 0; i < chkOneObjs.length; i++) 
	    		{
		            chkOneObjs[i].checked = true;
		        }
	    	}
	    	else
	    	{
	    		for (var i = 0; i < chkOneObjs.length; i++) 
	    		{
		            chkOneObjs[i].checked = false;
		        }
	    	}
	        
	    });
		 $("#addstu").click(function(){
		 		$("#sid").prop("disabled",false);
		 		$("#sid").val("");
				$("#sname").val("");
				$("#sex").val("");
				$("#birthday").val("");
				$("#password").val("");
				$("#tel").val("");
				$("#address").val("");
				$("#classname").val("");
				
		 	    layui.use(['form', 'layedit', 'laydate'], function(){
		 				var form = layui.form()
  						,layer = layui.layer
  						,layedit = layui.layedit
  						,laydate = layui.laydate;
  		
  				});
			   layer.open({
				          title:"新增学生",
                          type: 1,
                          area: ['350px', '430px'],
                          shadeClose: true, //点击遮罩关闭
						  content:$("#addstudent"),
                          btn: ['保存'],
                          yes: function(index, layero){
                          	var sid = $("#sid").val();
                          	var sname = $("#sname").val();
                          	var sex = $("#sex").val();
                          	var birthday = $("#birthday").val();
                          	var password = $("#password").val();
                          	var tel = $("#tel").val();
                          	var address = $("#address").val();
                          	var id = $("#classname").val();
							window.location.href="addstu.action?sid="+sid+"&sname="+sname+"&sex="+sex+"&birthday="+birthday+"&password="+password+"&tel="+tel+"&address="+address+"&id="+id;
							layer.close(index); //如果设定了yes回调，需进行手工关闭
    					 }
                });
		});
		 $("#searchbutton").click(function(){
		 	var sort =$("#search-sort").val();
		 	var menuname = $("#menuname").val();
			window.location.href="searchstu.action?sort="+sort+"&menuname="+menuname;
		});
	});
	function revise() {
		var e = e || window.event;
		var target = e.target || e.srcElement;
		if (target.parentNode.tagName.toLowerCase() == "td") {
			var rowIndex = target.parentNode.parentNode.rowIndex;
		}
		var sid = $("#t1 tr:eq('" + rowIndex + "') td:eq(1)").text();
		var sname = $("#t1 tr:eq('" + rowIndex + "') td:eq(2)").text();
		var sex = $("#t1 tr:eq('" + rowIndex + "') td:eq(3)").text();
		var birthday = $("#t1 tr:eq('" + rowIndex + "') td:eq(4)").text();
		var password = $("#t1 tr:eq('" + rowIndex + "') td:eq(5)").text();
		var tel = $("#t1 tr:eq('" + rowIndex + "') td:eq(6)").text();
		var address = $("#t1 tr:eq('" + rowIndex + "') td:eq(7)").text();
		var id = $("#t1 tr:eq('" + rowIndex + "') td:eq(8)").text();
		$("#sid").prop("disabled",true);
		$("#sid").val(sid);
		$("#sname").val(sname);
		$("#sex").val(sex);
		$("#birthday").val(birthday);
		$("#password").val(password);
		$("#tel").val(tel);
		$("#address").val(address);
		$("#classname").val(id);
		layui.use(['form', 'layedit', 'laydate'], function(){
		 				var form = layui.form()
  						,layer = layui.layer
  						,layedit = layui.layedit
  						,laydate = layui.laydate;
  		
  				});
		layer.open({
				          title:"修改学生",
                          type: 1,
                          area: ['350px', '410px'],
                          shadeClose: true, //点击遮罩关闭
						  content:$("#addstudent"),
                          btn: ['保存'],
                          yes: function(index, layero){
                          	var sid = $("#sid").val();
                          	var sname = $("#sname").val();
                          	var sex = $("#sex").val();
                          	var birthday = $("#birthday").val();
                          	var password = $("#password").val();
                          	var tel = $("#tel").val();
                          	var address = $("#address").val();
                          	var id = $("#classname").val();
							window.location.href="updatestu.action?sid="+sid+"&sname="+sname+"&sex="+sex+"&birthday="+birthday+"&password="+password+"&tel="+tel+"&address="+address+"&id="+id;
							layer.close(index); //如果设定了yes回调，需进行手工关闭
    					 }
                });
	}
</script>
</head>

<body>
	<div class="search-wrap">
		<div class="layui-form-item">
			<table class="search-tab" width="1490px">
				<tr>
					<th width="120"><label class="layui-form-label">选择分类：</label>
					</th>
					<td><select name="search-sort" id="search-sort"
						lay-filter="aihao">
							<option value="all">全部</option>
							<option value="sid">学生编号</option>
							<option value="sname">学生姓名</option>
							<option value="id">班级</option>
					</select>
					</td>
					<th width="70"><label class="layui-form-label">关键字：</label></th>
					<td><input type="text" id="menuname" name="menuname"
						lay-verify="title" autocomplete="off" placeholder="关键字"
						class="layui-input">
					</td>
					<th width="100"><button name="sub" id="searchbutton"
							class="layui-btn layui-btn-normal">查询</button>
					</th>
					<td align="right">
						<div class="result-list">
							<a id="addstu" class="layui-btn" href='javascript:void(0)'> <i
								class="layui-icon">&#xe608;</i>新增学生 </a> <a id="batchDel"
								class="layui-btn" href='javascript:void(0)'> <i
								class="layui-icon">&#xe640;</i>批量删除 </a> <a id="updateOrd"
								class="layui-btn" href='javascript:void(0)'> <i
								class="layui-icon">&#xe62a;</i>更新排序 </a>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="result-wrap">
		<s:set name="student" value="#request.student" />
		<s:if test="#student.size != 0">
			<div class="result-content">
				<table class="result-tab" id="t1">
					<thead>
						<tr>
							<th class="tc" width="5%"><input name="selectall"
								type="checkbox" id="selectall" class="allChoose">全选</th>
							<th>学生编号</th>
							<th>学生名称</th>
							<th>性别</th>
							<th>出生日期</th>
							<th>密码</th>
							<th>联系电话</th>
							<th>家庭住址</th>
							<th>所在班级编号</th>
							<th>操作</th>
						</tr>
					</thead>
					<s:iterator value="#student" id="stu">
						<tbody id="movies">
							<tr>
								<td class='tc'><input class='allChoose' name='check'
									type='checkbox' value=<s:property value="#stu.sid" />>
								</td>
								<td><s:property value="#stu.sid" /></td>
								<td><s:property value="#stu.sname" /></td>
								<td><s:property value="#stu.sex" /></td>
								<td><s:property value="#stu.birthday" /></td>
								<td><s:property value="#stu.password" /></td>
								<td><s:property value="#stu.tel" /></td>
								<td><s:property value="#stu.address" /></td>
								<td><s:property value="#stu.cla.id" /></td>
								<td><a id='revise' href='javascript:void(0)'
									onclick='revise()'>修改</a>&nbsp;&nbsp; <a
									href="deletestu.action?checkTnum=<s:property value="#stu.id" />">删除</a>
								</td>
							</tr>
						</tbody>
					</s:iterator>
				</table>
			</div>
		</s:if>
	</div>
	<div class="holder" style="margin-left: 760px;"></div>
	<div id="addstudent" style="display:none">
		<label class="layui-form-label">学生编号：</label>
		<div class="layui-input-block">
			<input type="text" name="sid" id="sid" lay-verify="required"
				placeholder="请输入学生编号" autocomplete="off" class="layui-input">
		</div>
		<label class="layui-form-label">学生名称：</label>
		<div class="layui-input-block">
			<input type="text" name="sname" id="sname" 
				lay-verify="required" placeholder="请输入学生名称" autocomplete="off"
				class="layui-input">
		</div>
		<label class="layui-form-label">性别：</label>
		<div class="layui-input-block">
			<input type="text" name="sex" id="sex"  lay-verify="required"
				placeholder="请输入性别" autocomplete="off" class="layui-input">
		</div>
		<label class="layui-form-label">出生日期：</label>
		<div class="layui-input-block">
			<input type="text" name="birthday" id="birthday" 
				lay-verify="required" placeholder="请输入出生日期" autocomplete="off"
				class="layui-input">
		</div>
		<label class="layui-form-label">密码：</label>
		<div class="layui-input-block">
			<input type="text" name="password" id="password"
				lay-verify="required" placeholder="请输入密码" autocomplete="off"
				class="layui-input">
		</div>
		<label class="layui-form-label">联系电话：</label>
		<div class="layui-input-block">
			<input type="text" name="tel" id="tel" lay-verify="required"
				placeholder="请输入联系电话" autocomplete="off" class="layui-input">
		</div>
		<label class="layui-form-label">家庭住址：</label>
		<div class="layui-input-block">
			<input type="text" name="address" id="address" lay-verify="required"
				placeholder="请输入家庭住址" autocomplete="off" class="layui-input">
		</div>
		<form class="layui-form">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">班级名称：</label>
					<div class="layui-input-inline">
						<select id="classname" name="modules" lay-verify="required"
							lay-search="">
							<option value="">直接选择或搜索选择</option>
						</select>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
