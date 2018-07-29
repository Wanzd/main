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
	var impl = {
		init$health$weight : function() {
			var data = common.ajax("rest/ra_health$weight");
			option = {
				xAxis : {
					data : common.attrArray(data, "logDate")
				},
				yAxis : {
					type : 'value',
					min : 80
				},
				series : [ {
					data : common.attrArray(data, "value"),
					type : 'line'
				} ]
			};

			// 初始化echarts实例
			var myChart = echarts.init(document
					.getElementById('chartHealthWeight'));

			// 使用制定的配置项和数据显示图表
			myChart.setOption(option);
		},
		init$health : function() {
			this.init$health$weight();
		},
		init$summary : function() {
			$("#divSummaryHealth").html("健康指数：肥胖");
			$("#divSummaryRelation").html("关系指数：计算机国考");
			$("#divSummaryIO").html("收入指数：XXXXXX");
		},
		init : function() {
			this.init$health();
			this.init$summary();
		}
	}

	impl.init();
});