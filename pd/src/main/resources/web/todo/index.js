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
	init : function() {

	},
	cfg : {},
	getDayTdHtml : function(year, month, day) {
		var htmlStr = new Array();
		var bgColor = "lightyellow";
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
		if (weekDay == 6) {
			dayValue = "周六";
		}
		if (weekDay == 0) {
			dayValue = "周日";
		}
		if (month == 10 && day == 1) {
			dayValue = "国庆";
		}
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
		var monthDays = [ 31, 28 + (isLeapYear ? 1 : 0), 31, 30, 31, 30, 31,
				31, 30, 31, 30, 31 ];
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
	refreshTime : function() {
		var htmlStr = new Array();
		htmlStr.push("2019年还有：<p/>");
		htmlStr.push((new Date(2020, 0, 1) - new Date())/1000 + "秒<p/>");
		htmlStr.push((new Date(2020, 0, 1) - new Date())/1000/60 + "分<p/>");
		htmlStr.push((new Date(2020, 0, 1) - new Date())/1000/60/60 + "时<p/>");
		htmlStr.push((new Date(2020, 0, 1) - new Date())/1000/60/60/24 + "天<p/>");
		htmlStr.push((new Date(2020, 0, 1) - new Date())/1000/60/60/24/7 + "周<p/>");
		htmlStr.push((11-new Date().getMonth())+(new Date(2020, 0, 1) - new Date())/1000/60/60/24/7 + "月<p/>");
		htmlStr.push((new Date(2020, 0, 1) - new Date())/10/60/60/24/365 + "%");
		$("#dRestYear").html(htmlStr.join(""));
	},
	init : function() {
		var year = new Date().getFullYear();
		yearTableHtml = this.getYearTableHtml(year);
		$("#dTodoYear").html(yearTableHtml);
		setInterval(this.refreshTime, 1000);
	}
}
require([ 'jquery', 'easyui', 'common', 'echarts' ], function(jquery, easyui,
		common, echarts) {
	common.init(impl);
});