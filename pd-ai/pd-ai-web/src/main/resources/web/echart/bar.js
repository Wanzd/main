require.config({
			urlArgs : "r=" + (new Date()).getTime(),
			paths : {
				common : "../common",
				jquery : "../jquery.min",
				echarts : "echarts.min"
			}
		});

require(['jquery', 'common', 'echarts'], function(jquery, common, echarts) {
	var impl = {
		init$all : function() {
			var data = common.ajax("../echart/bar/cfg/query");
			debugger;

			option = {
				title : {
					text : data.title,
					subtext : data.subTitle
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : data.legend
				},
				toolbox : {
					show : true,
					feature : {
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : ['line', 'bar']
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				xAxis : [{
							type : 'category',
							data : data.xaxis
						}],
				yAxis : [{
							type : 'value'
						}],
				series : data.series
			};
			echarts.init(document.getElementById('barChart')).setOption(option);

		},
		init : function() {
			this.init$all();
		}
	};
	impl.init();
});