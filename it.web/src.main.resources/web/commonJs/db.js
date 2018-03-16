define([ "db" ], function() {
	return {
		builder : {
			db : {
				c$open : function() {
					$("#dlg").dialog("open").dialog("setTitle", "新增");
					$("#fm").form("clear");
					url = "db/c?mid=" + $r("page.id");
				},
				s : function() {
					$("#fm").form("submit", {
						url : url,
						onSubmit : function() {
							return $(this).form("validate");
						},
						success : function(rs) {
							rs = eval("(" + rs + ")");
							if (rs.status == "SUCCESS") {
								$("#dg").datagrid("reload"); // reload the
								// user data
							} else {
								$.messager.show({ // show error message
									title : "Error",
									msg : rs.errorMsg
								});
							}
						}
					});
				},
				r : function() {

				},
				u$open : function() {
					var row = $("#dg").datagrid("getSelected");
					if (row) {
						$("#dlg").dialog("open").dialog("setTitle", "编辑");
						$("#fm").form("load", row);
						url = "db/u?mid=" + $r("page.id");
					}
				},
				d : function() {
					var row = $("#dg").datagrid("getSelected");
					if (row) {
						debugger;
						$.messager.confirm("Confirm", "确定要删除吗?", function(r) {
							debugger;
							if (r) {
								var rs = $r("ajax.post.json", {
									url : "db/d?mid=" + $r("page.id"),
									data : {
										id : row.id
									}
								});
								debugger;
								if (rs.status == "SUCCESS") {
									$("#dg").datagrid("reload"); // reload
																	// the
									// user data
								} else {
									$.messager.show({ // show error message
										title : "Error",
										msg : rs.errorMsg
									});
								}
							}
						});
					}
				},
				addEvent : function() {
					$('#dg').datagrid({
						onClickCell : function(index, field, value) {
							$build("db.u$open");
						}
					});
				}
			}
		},
		editFlag : false,
		widget : {
			dgTable : {
				ondblclickVO : {
					id : ".datagrid-btable",
					startF : function() {
						$build("db.u$open");
					}
				}
			}
		}
	};
});
