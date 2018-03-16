console.log("r:lookupItem.index.js");
var $pageAtom = {
	init : function() {
		$('#dg').datagrid($pageCfg.datagrid.cfg)
	}
}
var $pageCfg = {
	datagrid : {
		cfg : { // 定位到Table标签，Table标签的ID是grid
			width : '100%',
			height : '100%',
			url : 'lookup/p?pageNo=1&pageSize=15', // 指向后台的Action来获取当前菜单的信息的Json格式的数据
			iconCls : 'icon-view',
			nowrap : true,
			autoRowHeight : true,
			striped : true,
			collapsible : true,
			pagination : true,
			pageSize : 100,
			pageList : [ 50, 100, 200 ],
			rownumbers : true,
			// sortName: 'ID', //根据某个字段给easyUI排序
			sortOrder : 'asc',
			remoteSort : false,
			idField : 'ID',
			// queryParams : queryData, // 异步查询的参数
			columns : [ [ {
				field : 'ck',
				checkbox : true
			}, // 选择
			{
				title : '父类型',
				field : 'typeCn',
				width : 200
			}, {
				title : '编码',
				field : 'id',
				width : 150
			}, {
				title : '中文名称',
				field : 'cn',
				width : 80
			}, {
				title : '英文名称',
				field : 'en',
				width : 80
			}, {
				title : '详情',
				field : 'detail',
				width : 80
			}, {
				title : '属性1',
				field : 'attr1',
				width : 80
			}, {
				title : '属性2',
				field : 'attr2',
				width : 80
			}, {
				title : '属性3',
				field : 'attr3',
				width : 80
			}, {
				title : '属性4',
				field : 'attr4',
				width : 80
			}, {
				title : '属性5',
				field : 'attr5',
				width : 80
			}, {
				title : '属性6',
				field : 'attr6',
				width : 80
			} ] ],
			toolbar : [ {
				id : 'btnAdd',
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$build('db.c$open');// 实现添加记录的页面
				}
			}, '-', {
				id : 'btnEdit',
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					$build('db.u$open');// 实现修改记录的方法
				}
			}, '-', {
				id : 'btnDelete',
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					$build('db.d');// 实现直接删除数据的方法
				}
			}, '-', {
				id : 'btnView',
				text : '查看',
				iconCls : 'icon-table',
				handler : function() {
					ShowEditOrViewDialog("view");// 实现查看记录详细信息的方法
				}
			}, '-', {
				id : 'btnReload',
				text : '刷新',
				iconCls : 'icon-reload',
				handler : function() {
					// 实现刷新栏目中的数据
					$("#grid").datagrid("reload");
				}
			} ],
			onDblClickRow : function(rowIndex, rowData) {
				$('#grid').datagrid('uncheckAll');
				$('#grid').datagrid('checkRow', rowIndex);
				$build("db.u$open");
			}
		}
	}
};
var $pageImpl = {
	reader : {
		page : {
			id : function() {
				return "lookup";
			}
		}
	},
	formatter : {
		type : {
			id : function(row) {
				if (!row || !row.id) {
					return "";
				}
				return row.cn;
			}
		}

	}
};
$impl($ai, $pageImpl);
$pageAtom.init();