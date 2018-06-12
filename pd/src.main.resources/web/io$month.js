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
	var data=common.ajax("rest/ra_io$month");
	var yeasArr=common.attrArray(data,"year");
	debugger;
	
	option = {
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    legend: {
		        data:['累计','利润', '支出', '收入']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    yAxis : [
		        {
		            type : 'category',
		            axisTick : {show: false},
		            data : common.attrArray(data,"month")
		        }
		    ],
		    series : [
		        {
		            name:'累计',
		            type:'bar',
		            itemStyle : { normal: {label : {show: true, position: 'inside'}}},
		            data:common.attrArray(data,"gaps")
		        },
		        {
		            name:'利润',
		            type:'bar',
		            itemStyle : { normal: {label : {show: true, position: 'inside'}}},
		            data:common.attrArray(data,"gap")
		        },
		        {
		            name:'收入',
		            type:'bar',
		            barWidth : 5,
		            itemStyle: {normal: {
		                label : {show: true}
		            }},
		            data:common.attrArray(data,"supply")
		        },
		        {
		            name:'支出',
		            type:'bar',
		            itemStyle: {normal: {
		                label : {show: true}
		            }},
		            data:common.attrArray(data,"demand")
		        }
		    ]
		};
	// 初始化echarts实例
	var myChart = echarts.init(document.getElementById('chartmain'));

	// 使用制定的配置项和数据显示图表
	myChart.setOption(option);
});