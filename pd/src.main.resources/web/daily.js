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
		init$todo$month : function() {
			var graphData = [ [new Date("2018/08/05").getTime(),110] ];

			var links = graphData.map(function(item, idx) {
				return {
					source : idx,
					target : idx + 1
				};
			});
			links.pop();

			function getVirtulData(year) {
				year = year || '2017';
				var date = +echarts.number.parseDate(year + '-01-01');
				var end = +echarts.number.parseDate((+year + 1) + '-01-01');
				var dayTime = 3600 * 24 * 1000;
				var data = [];
				for (var time = date; time < end; time += dayTime) {
					data.push([ echarts.format.formatTime('yyyy-MM-dd', time),
							Math.floor(Math.random() * 10000) ]);
				}
				return data;
			}

			option = {
				tooltip : {},
				calendar : {
					top : 'middle',
					left : 'center',
					orient : 'vertical',
					cellSize : 40,
					yearLabel : {
						margin : 50,
						textStyle : {
							fontSize : 30
						}
					},
					dayLabel : {
						firstDay : 1,
						nameMap : 'cn'
					},
					monthLabel : {
						nameMap : 'cn',
						margin : 15,
						textStyle : {
							fontSize : 20,
							color : '#999'
						}
					},
					range : [ '2018-08', '2018-10-31' ]
				},
				visualMap : {
					min : 0,
					max : 10000,
					type : 'piecewise',
					left : 'center',
					bottom : 20,
					inRange : {
						color : [ '#5291FF', '#C7DBFF' ]
					},
					seriesIndex : [ 1 ],
					orient : 'horizontal'
				},
				series : [ {
					type : 'graph',
					edgeSymbol : [ 'none', 'arrow' ],
					coordinateSystem : 'calendar',
					links : links,
					symbolSize : 15,
					calendarIndex : 0,
					itemStyle : {
						normal : {
							color : 'yellow',
							shadowBlue : 9,
							shadowOffsetX : 1.5,
							shadowOffsetY : 3,
							shadowColor : '#555'
						}
					},
					lineStyle : {
						normal : {
							color : '#D10E00',
							width : 1,
							opacity : 1
						}
					},
					data : graphData,
					z : 20
				}, {
					type : 'heatmap',
					coordinateSystem : 'calendar',
					data : getVirtulData(2018)
				} ]
			};

			echarts.init(document.getElementById('chartTodoMonth')).setOption(
					option);

		},
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
			this.init$todo$month();
			this.init$health();
			this.init$summary();
		}
	}

	impl.init();
});