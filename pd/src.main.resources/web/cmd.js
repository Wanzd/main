require.config({
	urlArgs : "r=" + (new Date()).getTime(),
	paths : {
		jquery : "jquery.min",
		easyui : "jquery.easyui.min"
	},
	shim : {
		"easyui" : {
			deps : [ "jquery" ]
		}
	}
});
require([ 'jquery', 'easyui', 'common', 'tree', 'db' ], function(jquery,
		easyui, common, tree, db) {
	main = {
		init : function() {
			main.init$module();
		},
		init$module : function() {
			console.log("init$menu");
			$('#cbModule').combobox({
				url : 'rest/ra_cmd$module',
				valueField : 'id',
				textField : 'text'
			});
		}
	}
	main.init();
});