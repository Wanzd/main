require.config({
			urlArgs : "r=" + (new Date()).getTime(),
			paths : {
				jquery : "../jquery.min",
				easyui : "../jquery.easyui.min",
				common : "../common",
				echarts : "../echarts.min",
				echartsgl : "../echarts-gl.min"
			},
			shim : {
				"easyui" : {
					deps : ["jquery"]
				}
			}
		});
var $api = null;
require(['jquery', 'easyui', 'common', 'echarts', 'echartsgl', 'wordcloud',
				'ai$echart'], function(jquery, easyui, common, echarts,
				echartsgl, wordcloud, ai$echart) {
			$api = this;
			this.search = function() {
				var myChart = echarts.init(document.getElementById('myChart'));
				data = $("#form").serializeJson();
				url = '../DS:'+data.dataSource;
				result = common.ajax(url);
				var symbolSize = 2.5;
				option=ai$echart.x$option(data);
				myChart.setOption(option);
				option = {
					grid3D : {},
					xAxis3D : {
						type : 'category'
					},
					yAxis3D : {},
					zAxis3D : {},
					dataset : {
						dimensions : ['qty', 'city', {
									name : 'creationDate',
									type : 'ordinal'
								}],
						source : result
					},
					series : [{
								type : 'scatter3D',
								symbolSize : symbolSize,
								encode : {
									x : 'city',
									y : 'creationDate',
									z : 'qty',
									tooltip : [0, 1, 2]
								}
							}]
				};
				myChart.setOption(option);
			}
			$("#dataSource").combobox({
						url : '../ai/ISystemDataSourceDao/queryCombo',
						valueField : 'id',
						textField : 'text'
					});
			$("#chartType").combobox({
						url : '../ai/ISystemEchartTypeDao/queryCombo',
						valueField : 'id',
						textField : 'text'
					});
			$("#search").click($api.search);
		});