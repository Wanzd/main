require.config({
			urlArgs : "r=" + (new Date()).getTime(),
			paths : {
				jquery : "../jquery.min",
				easyui : "../jquery.easyui.min",
				common : "../common",
				echarts : "../echarts.min",
				echartsgl : "../echarts-gl.min",
				ai$echart : "../ai$echart"
			},
			shim : {
				"easyui" : {
					deps : ["jquery"]
				}
			}
		});
var $api = null;
require(['jquery', 'easyui', 'common', 'echarts', 'echartsgl', 'ai$echart'],
		function(jquery, easyui, common, echarts, echartsgl, ai$echart) {
			$api = this;
			this.search = function() {
				var data = $("#form").serializeJson();
				var perspectiveJson = common.ajax(
						'../perspectiveRest/queryList', data);
				$.each(perspectiveJson, function(idx, it) {
							var myChart = echarts.init(document
									.getElementById('myChart' + idx));
							myChart.clear();
							var chartUrl = '../CHART:' + it.id;
							var chartJson = common.ajax(chartUrl);
							if (chartJson != null) {
								option = ai$echart.x$option(chartJson);
								myChart.setOption(option);
							}
						})
			}
			$("#perspectiveId").combobox({
						url : '../perspectiveRest/queryCombo',
						valueField : 'id',
						textField : 'text'
					});
			$("#search").click($api.search);

		});