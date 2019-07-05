require.config({
	urlArgs : "r=" + (new Date()).getTime(),
	paths : {
		jquery : "/jquery.min",
		easyui : "/jquery.easyui.min"
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
			main.init$menu();
		},
		init$menu : function() {
			$('#tt').etree({
				url : '/tree_data.json',
				createUrl : '',
				updateUrl : '',
				destroyUrl : '',
				dndUrl : ''
			});
		}

	}
	main.init();
});