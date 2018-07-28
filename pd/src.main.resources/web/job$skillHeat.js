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
	var groupArr = common.groupArray(data, "category");
	var treeMapVO = ai$echart.x$TreeMapVO(groupArr);
	option = {
		tooltip : {
			formatter : function(info) {
				var vo = info.data;
				return "Name：" + vo.name + "<br/>Value：" + vo.value;
			}
		},
		series : [ {
			type : 'treemap',
			data : treeMapVO
		} ]
	};

	// 初始化echarts实例
	var myChart = echarts.init(document.getElementById('chartmain'));

	// 使用制定的配置项和数据显示图表
	myChart.setOption(option);
});