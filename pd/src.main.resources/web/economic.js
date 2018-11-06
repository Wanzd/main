require.config({
	urlArgs : "r=" + (new Date()).getTime(),
	paths : {
		jquery : "jquery.min",
		easyui : "jquery.easyui.min",
		echarts : "echarts.min",
		wordcloud : "echarts-wordcloud.min"
	},
	shim : {
		"easyui" : {
			deps : [ "jquery" ]
		}
	}
});
var $api = null;
require(
		[ 'jquery', 'easyui', 'common', 'echarts', 'wordcloud', 'ai$echart' ],
		function(jquery, easyui, common, echarts, wordcloud, ai$echart) {
			$impl = {
				init$description : function() {

				},
				init$detail : function() {
					common.init({
						type : "date$month",
						id : "economicDetailDateMonth"
					});
					$("#frmEconoicDetail").attr("src",
							"commonGrid.html?module=economic&dimension=detail");
				},
				init$config : function() {
					$("#frmEconoicCfg").attr("src",
							"commonGrid.html?module=economic&dimension=config");
				},
				init$summary : function() {

				},
				init$report : function() {
					common.init({
						type : "date$month",
						id : "economicMonthlyDateMonth"
					});
					$("#frmEconoicMonthly")
							.attr("src",
									"commonGrid.html?module=economic&dimension=monthly");
				},
				init$risk : function() {

				}
			};
			$api = $impl;
			$('#dEconoic').tabs({
				border : false,
				onSelect : function(title, index) {
					var funcMap = {
						0 : $api.init$description,
						1 : $api.init$detail,
						2 : $api.init$config,
						3 : $api.init$report
					};

					funcMap[index]();
				}
			});

		});