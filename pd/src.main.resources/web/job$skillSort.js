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
require([ 'jquery', 'easyui', 'common', 'echarts', 'ai$echart' ], function(
		jquery, easyui, common, echarts, ai$echart) {
	var data = common.ajax("rest/ra_51Job$skillHeat");
	debugger;
	var textArr = common.attrArray(data, "text");
	var salaryAvgArr = common.attrArray(data, "salaryAvg");
	var salaryEndArr = common.attrArray(data, "salaryEnd");
	var salaryStartArr = common.attrArray(data, "salaryStart");
	debugger;
	option = {
		title : {
			text : '公司工资统计'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'shadow'
			}
		},
		legend : {
			data : [ '最大工资', '平均工资', '最低工资' ]
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : {
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		},
		yAxis : {
			type : 'category',
			data : textArr
		},
		series : [ {
			name : '最大工资',
			type : 'bar',
			data : salaryEndArr
		}, {
			name : '平均工资',
			type : 'bar',
			data : salaryAvgArr
		}, {
			name : '最低工资',
			type : 'bar',
			data : salaryStartArr
		} ]
	};


	// 初始化echarts实例
	var myChart = echarts.init(document.getElementById('chartmain'));

	// 使用制定的配置项和数据显示图表
	myChart.setOption(option);
});