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
			deps : [ "jquery" ]
		}
	}
});
var impl = {
	echarts:null,
	initSummary : function() {

	},
	initSub : function() {
		debugger;
		option = {
			legend : {},
			tooltip : {},
			dataset : {
				dimensions : [ 'product', 'demand', 'supply', 'gap' ],
				source : [ {
					product : 'wzd',
					demand : 1100,
					supply : 14000,
					gap : 12900
				}, {
					product : 'hc',
					demand : 1000,
					supply : 4000,
					gap : 3000
				}, {
					product : 'wbc',
					demand : 3000,
					supply : 1000,
					gap : -2000
				} ]
			},
			xAxis : {
				type : 'category'
			},
			yAxis : {},
			// Declare several bar series, each will be mapped
			// to a column of dataset.source by default.
			series : [ {
				type : 'bar'
			}, {
				type : 'bar'
			}, {
				type : 'bar'
			} ]
		};
		this.echarts.init(document.getElementById("dSub")).setOption(option);
	},
	init : function() {
		this.initSummary();
		this.initSub();
	}
}
require([ 'jquery', 'easyui', 'common', 'echarts' ], function(jquery, easyui,
		common, echarts) {
	impl.echarts=echarts;
	common.init(impl);
});