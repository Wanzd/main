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
	var data = common.ajax("rest/ra_51Job");
	debugger;
	var salaryData = common.attrArray(data, "salaryStart,salaryEnd,company,job,location");
	debugger;

	option = {
		xAxis : {
			scale : true,
			name:"最低工资"
		},
		yAxis : {
			scale : true,
			name:"最高工资"
		},
		tooltip : {
			trigger : 'item',
			axisPointer : {
				type : "shadow"
			},
			formatter : function(params) {
				debugger;
				var curVO=params.data;
				return "位置："+curVO[4]+"<br/>公司："+curVO[2]+"<br/>岗位："+curVO[3];
			},
			position : function(point, params, dom, rect, size) {
				return [ point[0], point[1]+30 ];
			}
		},
		series : [ {
			type : 'effectScatter',
			symbolSize : 20,
			data : [ [ 172.7, 105.2 ], [ 153.4, 42 ] ]
		}, {
			type : 'scatter',
			data : salaryData,
		} ]
	};
	// 初始化echarts实例
	var myChart = echarts.init(document.getElementById('chartmain'));

	// 使用制定的配置项和数据显示图表
	myChart.setOption(option);
});