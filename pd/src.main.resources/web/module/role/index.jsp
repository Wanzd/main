<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>JQuery easyui demo</title>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.1/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.1/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-1.4.1/demo/demo.css">
<script type="text/javascript" src="commonJs/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="commonJs/ai.js"></script>
<script type="text/javascript" src="commonJs/db.js"></script>
<script type="text/javascript" src="jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table id="dg" class="easyui-datagrid" style="height: 470px;"
		url="user/p?pageNo=1&pageSize=15" toolbar="#toolbar" pagination="true"
		rownumbers="true" fitColumns="true" singleSelect="true"
		data-options="fit:false,border:false,pageSize:5,pageList:[5,10,15,20]">
		<thead>
			<tr>

				<th field="name" width="50">姓名</th>
				<th field="sex" width="50">性别</th>
				<th field="phoneNumber" width="50">电话</th>
				<th field="birthday" width="50">生日</th>
				<th field="age" width="50">年龄</th>
				<th field="other" width="50">其它</th>
			</tr>
		</thead>
	</table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="$build('db.c$open')">新增</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="$build('db.u$open')">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="$build('db.d')">删除</a>
	</div>

	<div id="dlg" class="easyui-dialog" style="padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<div class="ftitle">详细信息</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>姓名:</label> <input name="name" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>性别:</label> <input name="sex" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>电话:</label> <input name="phoneNumber" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>邮箱:</label> <input name="email" class="easyui-textbox"
					validType="email">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="$build('db.s')" style="width: 90px">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width: 90px">取消</a>
	</div>
	<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>
</body>
</html>