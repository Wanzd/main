require.config({
			urlArgs : "r=" + (new Date()).getTime(),
			paths : {
				jquery : "../jquery.min",
				easyui : "../jquery.easyui.min",
				echarts : "../echarts.min",
				common : "../common"
			},
			shim : {
				"easyui" : {
					deps : ["jquery"]
				}
			}
		});
var impl = {

	init : function() {

	}
}
require(['jquery', 'easyui', 'common', 'echarts'], function(jquery, easyui,
				common, echarts) {
			debugger;
			var data = [{
						"name" : "万成龙",
						"children" : [{
									"name" : "万咸",
									"children" : [{
												"name" : "大伯",
												"children" : [{
															"name" : "万秀莉",
															"value" : 1
														}, {
															"name" : "万正刚",
															"value" : 1
														}]
											}, {
												"name" : "万玉林",
												"children" : [{
															"name" : "万正东",
															"value" : 1
														}, {
															"name" : "万正阳",
															"value" : 1
														}]
											}, {
												"name" : "万冬清",
												"children" : [{
															"name" : "万正鑫",
															"value" : 1
														}, {
															"name" : "万翠",
															"value" : 1
														}]
											}, {
												"name" : "万腊英",
												"children" : [{
															"name" : "张文艳",
															"value" : 1
														}, {
															"name" : "张文琪",
															"value" : 1
														}]
											}]
								}]
					}];
			var option = {
				tooltip : {
					trigger : 'item',
					triggerOn : 'mousemove'
				},
				series : [{
							type : 'tree',

							data : data,

							top : '1%',
							left : '7%',
							bottom : '1%',
							right : '20%',

							symbolSize : 7,

							label : {
								normal : {
									position : 'right',
									verticalAlign : 'middle',
									align : 'left',
									fontSize : 9
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
						}]
			};
			echarts.util.each(data.children, function(datum, index) {
						index % 2 === 0 && (datum.collapsed = true);
					});
			echarts.init(document.getElementById("dPersonMind"))
					.setOption(option);

			common.init(impl);
		});