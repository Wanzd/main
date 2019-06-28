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
	var impl = {
		init$person$tree : function() {
			// var data = common.ajax("rest/ra_phone$price$product");
			// var salaryData = common.attrArray(data,
			// "price,monthSales,sellNum,company,title");

			// 初始化echarts实例
			var myChart = echarts.init(document.getElementById("chartmain"));

			myChart.showLoading();
			var data1 = {
				"name" : "wzd",
				"children" : [ {
					"name" : "wbc",
					"children" : [ {
						"name" : "converters",
						"children" : [ {
							"name" : "Converters",
							"value" : 721
						}, {
							"name" : "DelimitedTextConverter",
							"value" : 4294
						} ]
					}, {
						"name" : "DataUtil",
						"value" : 3322
					} ]
				} ]
			};

			var data2 = {
				"name" : "flare",
				"children" : [ {
					"name" : "data",
					"children" : [ {
						"name" : "converters",
						"children" : [ {
							"name" : "Converters",
							"value" : 721
						}, {
							"name" : "DelimitedTextConverter",
							"value" : 4294
						} ]
					}, {
						"name" : "DataUtil",
						"value" : 3322
					} ]
				} ]
			};
			var option = {
				tooltip : {
					trigger : 'item',
					triggerOn : 'mousemove'
				},
				legend : {
					top : '2%',
					left : '3%',
					orient : 'vertical',
					data : [ {
						name : 'wzd',
						icon : 'rectangle'
					}, {
						name : 'tree2',
						icon : 'rectangle'
					} ],
					borderColor : '#c23531'
				},
				series : [ {
					type : 'tree',

					name : 'wzd',

					data : [ data1 ],

					top : '5%',
					left : '7%',
					bottom : '2%',
					right : '60%',

					symbolSize : 7,

					label : {
						normal : {
							position : 'left',
							verticalAlign : 'middle',
							align : 'right'
						}
					},

					leaves : {
						label : {
							normal : {
								position : 'right',
								verticalAlign : 'middle',
								align : 'left'
							}
						}
					},

					expandAndCollapse : true,

					animationDuration : 550,
					animationDurationUpdate : 750

				} ]
			};

			myChart.hideLoading();
			// 使用制定的配置项和数据显示图表
			myChart.setOption(option);
		},
		init : function() {
			this.init$person$tree();
		}
	}

	impl.init();
});