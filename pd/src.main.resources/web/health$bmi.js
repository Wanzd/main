require.config({
	urlArgs : "r=" + (new Date()).getTime(),
	paths : {
		jquery : "jquery.min",
		easyui : "jquery.easyui.min",
		echarts : "echarts.min"
	},
	shim : {
		"easyui" : {
			deps : [ "jquery" ]
		}
	}
});
require([ 'jquery', 'easyui', 'common', 'echarts' ], function(jquery, easyui,
		common, echarts) {
	var data = common.ajax("rest/ra_health$weight");
	option = {
		xAxis : {
			data : common.attrArray(data, "logDate")
		},
		yAxis : {
			type : 'value',
			min:25
		},
		series : [ {
			data : common.attrArray(data, "bmi"),
			type : 'line'
		} ]
	};

	// 初始化echarts实例
	var myChart = echarts.init(document.getElementById('chartmain'));

	// 使用制定的配置项和数据显示图表
	myChart.setOption(option);
});