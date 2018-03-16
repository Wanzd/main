require.config({
			paths : {
				jquery : "jquery.min",
				easyui : "jquery.easyui.min"
			},
			shim : {
				"easyui" : {
					deps : ["jquery"]
				}
			}
		});
require(['jquery', 'easyui', 'common', 'tree', 'db'], function(jquery, easyui,
		common, tree, db) {
	debugger;
	$(function() {
				main.init();
				$("#menu").tree({
							onClick : main.tabMenu
						});
			});
	
	function menu(title) {
		if (!$("#tt").tabs("exists", title)) {
			$('#tt').tabs('add', {
						title : title,
						href : 'http://localhost:8080/pd/module/menu/index.html',
						selected : true,
						closable : true
					});
		}
		$("#tt").tabs("select", title);
		setTimeout('$build("db.addEvent")', 500);
	}
	
});