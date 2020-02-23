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
				if (data.chartId instanceof Array) {
					$.each(data.chartId, function(idx, it) {
								var myChart = echarts.init(document
										.getElementById('myChart' + idx));
								myChart.clear();
								var chartUrl = '../CHART:' + it;
								var chartJson = common.ajax(chartUrl);
								option = ai$echart.x$option(chartJson);
								myChart.setOption(option);
							})
				} else {
					var myChart = echarts.init(document
							.getElementById('myChart0'));
					myChart.clear();
					var chartUrl = '../CHART:' + data.chartId;
					var chartJson = common.ajax(chartUrl);
					option = ai$echart.x$option(chartJson);
					myChart.setOption(option);
				}
			}
			$("#chartId").combobox({
						url : '../ai/ISystemChartDao/queryCombo',
						valueField : 'id',
						textField : 'text',
						multiple : true
					});
			$("#search").click($api.search);

		});