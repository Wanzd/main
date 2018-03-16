console.log("r:db.index.js");
var $pageAtom = {
	init : function() {
		$('#dg').datagrid($r("grid.cfg"));
	}
}
var $pageCfg = {
	datagrid : {
		cfg : function() {
			return { // 定位到Table标签，Table标签的ID是grid
				width : '100%',
				height : '100%',
				url : 'db/p?pageNo=1&pageSize=15&mid=user', // 指向后台的Action来获取当前菜单的信息的Json格式的数据
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
					title : '姓名',
					field : 'NAME',
					width : 50
				}, {
					title : '性别',
					field : 'sex',
					width : 50
				}, {
					title : '电话',
					field : 'phoneNumber',
					width : 100
				}, {
					title : '生日',
					field : 'birthday',
					width : 50
				}, {
					title : '年龄',
					field : 'age',
					width : 50
				}, {
					title : '其它',
					field : 'other',
					width : 50
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
			};
		}
	}
};
var $pageImpl = {
	reader : {
		page : {
			id : function() {
				return "db";
			}
		},
		grid : {
			cfg : function() {
				return $pageCfg.datagrid.cfg();
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