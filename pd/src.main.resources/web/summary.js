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
	year : (new Date().getYear() + 1900),
	day : {
		warnLevel : {},
		map : {}
	}
};
var $api = null;
require(
		[ 'jquery', 'easyui', 'common', 'echarts', 'wordcloud', 'ai$echart' ],
		function(jquery, easyui, common, echarts, wordcloud, ai$echart) {
			$impl = {
				init$todo : function() {
					var todoRs = common.ajax("common/ra/todo", {
						year : 2018
					});
					$.each(todoRs,
							function(index, value, array) {
								var startDate = value.startDate;
								var endDate = value.endDate;

								if ($cfg.day.map[startDate] == null) {
									$cfg.day.map[startDate] = [];
								}
								$cfg.day.map[startDate].push(value);

								if ($cfg.day.warnLevel[startDate] == null) {
									$cfg.day.warnLevel[startDate] = 0;
								}
								$cfg.day.warnLevel[startDate] = Math.max(
										$cfg.day.warnLevel[startDate],
										value.baseLevel);
							});
				},
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
					tableHtml += "<table border=0 style='width:100%;height:200;font-size:12px;'	>";
					tableHtml += "<tr><td colspan=7>" + month + "月</td></tr>";
					tableHtml += "<tr  bgcolor='lightgreen'><td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td><td>日</td></tr>"
					tableHtml += "<tr>";

					var rowCount = 0;
					for (var i = 0; i < (weekDay + 6) % 7; i++) {
						tableHtml += "<td bgcolor='white'></td>";
					}
					for (var i = 1; i <= monthDayCount; i++) {
						var dateStr = year + "_" + month + "_" + i;
						var titleStr = this.getTitle$day(year, month, i);
						var bgColorStr = this.getColor$day(year, month, i);
						tableHtml += "<td id='d" + dateStr + "' title='"
								+ titleStr + "' bgcolor='" + bgColorStr + "'>"
								+ i + "</td>";
						if ((i + weekDay) % 7 == 1 || i == monthDayCount) {
							tableHtml += "</tr>";
							rowCount++;
						}
					}
					for (var i = rowCount; i <= 6; i++) {
						tableHtml += "<tr><td bgcolor='white' colspan=7>-</td></tr>";
					}
					tableHtml += "</table>";
					return tableHtml;
				},
				getColor$day : function(y, m, d) {
					if (new Date() > new Date(y, m - 1, d)) {
						return "gray";
					}

					if ($cfg.day.warnLevel[y + "-" + m + "-" + d] != null) {
						var warnLevel = $cfg.day.warnLevel[y + "-" + m + "-"
								+ d];

						var warnColor = "white";
						switch (warnLevel) {
						case 1:
							warnColor = "lightgreen";
							break;
						case 2:
							warnColor = "yellow";
							break;
						case 3:
							warnColor = "red";
							break;
						default:
							warnColor = "white"
							break;
						}
						return warnColor;
					}
					return "white";
				},
				getTitle$day : function(y, m, d) {
					if ($cfg.day.map[y + "-" + m + "-" + d] != null) {
						debugger;
						var todoDayList = $cfg.day.map[y + "-" + m + "-" + d];
						var titleRs = "";
						$.each(todoDayList, function(index, value, array) {
							titleRs += value.detail ;
						})
						return titleRs;
					}
					return "";
				}
			};

			$api = $impl;
			$impl.init$todo();
			$impl.init$month();
			debugger;
		});