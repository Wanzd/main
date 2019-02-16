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
	getDayTdHtml : function(year, month, day) {
		var htmlStr = new Array();
		var bgColor = "white";
		var weekDay = new Date(year, month - 1, day).getDay();
		if (weekDay == 6 || weekDay == 0) {
			bgColor = "lightblue";
		}
		if (new Date(year, month - 1, day + 1).getTime() < new Date()) {
			bgColor = "gray";
		}
		var title = "d" + month + "_" + day;
		var id = "d" + month + "_" + day;
		var dayValue = "";
		htmlStr.push("<td id='" + id + "' title='" + title + "' bgcolor='"
				+ bgColor + "'>" + dayValue + "</td>");
		return htmlStr.join();
	},
	getDayThHtml : function(year) {
		var htmlStr = new Array();
		htmlStr.push("<tr><td colspan=2>" + year + "年</td>");
		for (var day = 1; day <= 31; day++) {
			htmlStr.push("<td>" + day + "</td>");
		}
		htmlStr.push("</tr>")
		return htmlStr.join();
	},
	getMonthTrHtml : function(year, month) {
		var htmlStr = new Array();
		var isLeapYear = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
		var monthDays = [31, 28 + (isLeapYear ? 1 : 0), 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31];
		htmlStr.push("<tr><td colspan=2>" + month + "月</td>");
		var monthDayCount = monthDays[month - 1];
		for (var day = 1; day <= monthDayCount; day++) {
			htmlStr.push(this.getDayTdHtml(year, month, day));
		}
		htmlStr.push("</tr>")
		return htmlStr.join();
	},
	getYearTableHtml : function(year) {
		var htmlStr = new Array();
		htmlStr.push("<table>");
		htmlStr.push(this.getDayThHtml(year));
		for (var month = 1; month <= 12; month++) {
			htmlStr.push(this.getMonthTrHtml(year, month));
		}
		htmlStr.push("</table>");
		return htmlStr.join();
	},
	init : function() {
		var year = new Date().getFullYear();
		yearTableHtml = this.getYearTableHtml(year);
		$("#dTodoYear").html(yearTableHtml);
	}
}
require(['jquery', 'easyui', 'common', 'echarts'], function(jquery, easyui,
				common, echarts) {
			common.init(impl);
		});