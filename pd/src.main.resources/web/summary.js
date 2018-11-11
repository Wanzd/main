require.config({
	urlArgs : "r=" + (new Date()).getTime(),
	paths : {
		jquery : "jquery.min",
		easyui : "jquery.easyui.min",
		echarts : "echarts.min",
		wordcloud : "echarts-wordcloud.min"
	},
	shim : {
		"easyui" : {
			deps : [ "jquery" ]
		}
	}
});
var $cfg = {
	year : (new Date().getYear() + 1900)
};
var $api = null;
require(
		[ 'jquery', 'easyui', 'common', 'echarts', 'wordcloud', 'ai$echart' ],
		function(jquery, easyui, common, echarts, wordcloud, ai$echart) {
			$impl = {
				init$month : function() {
					for (var i = 1; i <= 12; i++) {
						var curMonthHtml = this.getMonthHtml($cfg.year, i);
						$("#month" + i).html(curMonthHtml);
					}
				},
				getMonthHtml : function(year, month) {
					// 获取第一天是星期几
					var weekDay = new Date(year, month - 1, 1).getDay();

					// 攻取当前月有几天
					var monthDayCount = new Date(year, month, 0).getDate();

					// 生成html的table格式字符串
					var tableHtml = "";
					tableHtml += "<table border=1 style='width:100%;height:200;'	>";
					tableHtml += "<tr><td colspan=7>" + month + "月</td></tr>";
					tableHtml += "<tr  bgcolor='lightgreen'><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td><td>日</td></tr>"
					tableHtml += "<tr>";
					for (var i = 0; i < (weekDay + 6) % 7; i++) {
						tableHtml += "<td></td>";
					}
					for (var i = 1; i <= monthDayCount; i++) {
						var dateStr = year + "_" + month + "_" + i;
						var titleStr = dateStr;
						tableHtml += "<td id='d" + dateStr + "' title='"
								+ dateStr + "'>" + i + "</td>";
						if ((i + weekDay) % 7 == 1 || i == monthDayCount) {
							tableHtml += "</tr>";
						}
					}
					tableHtml += "</table>";
					return tableHtml;
				}
			};
			$api = $impl;
			$impl.init$month();

		});