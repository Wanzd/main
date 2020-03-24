var treeGridCols = [[{
			title : '区域',
			field : 'text',
			width : 120,
			rowspan : 2
		}, {
			title : '存量',
			width : 120,
			colspan : 3,
			rowspan : 1,
			align : 'right'
		}, {
			title : '确诊',
			width : 120,
			colspan : 3,
			rowspan : 1,
			align : 'right'
		}, {
			title : '治愈',
			width : 120,
			colspan : 3,
			rowspan : 1,
			align : 'right'
		}, {
			title : '死亡',
			width : 120,
			colspan : 3,
			rowspan : 1,
			align : 'right'
		}, {
			field : 'sickRate',
			title : '存量率',
			rowspan : 2,
			width : 60,
			align : 'right',
			formatter : function(value, vo) {
				if (vo.cnt == 0) {
					return '<div id="p" class="easyui-progressbar" data-options="value:0" style="width:60px;"></div>';
				}
				var rs = Number((vo.cnt - vo.death - vo.heal) / vo.cnt * 100)
						.toFixed(1);
				return '<div id="p" class="easyui-progressbar" data-options="value:'
						+ rs + '" style="width:60px;"></div>';
			}
		}, {
			field : 'healRate',
			title : '治愈率',
			rowspan : 2,
			width : 60,
			align : 'right',
			formatter : function(value, vo) {
				if (vo.cnt == 0) {
					return '<div id="p" class="easyui-progressbar" data-options="value:100" style="width:60px;"></div>';
				}
				var rs = Number(vo.heal / vo.cnt * 100).toFixed(1);
				return '<div id="p" class="easyui-progressbar" data-options="value:'
						+ rs + '" style="width:60px;"></div>';
			}
		}, {
			field : 'deathRate',
			title : '死亡率',
			rowspan : 2,
			width : 60,
			align : 'right',
			formatter : function(value, vo) {
				if (vo.cnt == 0) {
					return '<div id="p" class="easyui-progressbar" data-options="value:0" style="width:60px;"></div>';
				}
				var rs = Number(vo.death / vo.cnt * 100).toFixed(1);
				return '<div id="p" class="easyui-progressbar" data-options="value:'
						+ rs + '" style="width:60px;"></div>';
			}
		}, {
			field : 'passDays',
			title : '爆发天数',
			rowspan : 2,
			width : 30,
			align : 'right'
		}, {
			field : 'endDays',
			title : '预期天数',
			rowspan : 2,
			width : 60,
			align : 'right',
			styler : function(value, vo, index) {
				var sick = vo.cnt - vo.death - vo.heal;
				if (sick < 1) {
					return 'background-color:black;color:white;'
				}
				var speed = ((vo.cnt1 - vo.death1 - vo.heal1) - (vo.cnt
						- vo.death - vo.heal));
				var color = sick == 0 || speed > 0 ? "green" : "red";
				return 'background-color:' + color + ';color:white;'
			},
			formatter : function(value, vo) {
				var sick = vo.cnt - vo.death - vo.heal;
				if (sick < 1) {
					return ''
				}
				var speed = ((vo.cnt1 - vo.death1 - vo.heal1) - (vo.cnt
						- vo.death - vo.heal));
				if (speed <= 0) {
					return "";
				}
				var day = (vo.cnt - vo.death - vo.heal) / speed;
				return Number(day).toFixed(1);
			}
		}], [{
	title : '新增',
	field : 'sickAdd',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.sick > vo.sick1 ? "red" : (vo.sick == vo.sick1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.sick - vo.sick1;
	}
}, {
	field : 'sickIncrRate',
	title : '新增率',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.sick > vo.sick1 ? "red" : (vo.sick == vo.sick1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		if (vo.sick == 0) {
			return '-100.0%';
		}
		if (vo.sick1 == 0) {
			return '100.0%';
		}
		var percent = Number((vo.sick - vo.sick1) / vo.sick1 * 100).toFixed(1)
				+ "%";
		return percent;
	}
}, {
	title : '累计',
	field : 'sick',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.sick > vo.sick1 ? "red" : (vo.sick == vo.sick1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.sick;
	}
}, {
	title : '新增',
	field : 'cntAdd',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.cnt > vo.cnt1 ? "red" : (vo.cnt == vo.cnt1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.cnt - vo.cnt1;
	}
}, {
	title : '新增率',
	field : 'cntIncrRate',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.cnt > vo.cnt ? "red" : (vo.cnt == vo.cnt1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		if (vo.cnt == 0) {
			return '-100.0%';
		}
		if (vo.cnt1 == 0) {
			return '100.0%';
		}
		var percent = Number((vo.cnt - vo.cnt1) / vo.cnt1 * 100).toFixed(1)
				+ "%";
		return percent;
	}
}, {
	title : '累计',
	field : 'cnt',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.cnt > vo.cnt1 ? "red" : (vo.cnt == vo.cnt1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.cnt;
	}
}, {
	title : '新增',
	field : 'healAdd',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.heal > vo.heal1 ? "green" : (vo.heal == vo.heal1
				? "black"
				: "red");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.heal - vo.heal1;
	}
}, {
	title : '新增率',
	field : 'healIncrRate',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.heal > vo.heal1 ? "green" : (vo.heal == vo.heal1
				? "black"
				: "red");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		if (vo.heal == 0) {
			return '-100.0%';
		}
		if (vo.heal1 == 0) {
			return '100.0%';
		}
		var percent = Number((vo.heal - vo.heal1) / vo.heal1 * 100).toFixed(1)
				+ "%";
		return percent;
	}
}, {
	title : '累计',
	field : 'heal',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.heal > vo.heal1 ? "green" : (vo.heal == vo.heal1
				? "black"
				: "red");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.heal;
	}
}, {
	title : '新增',
	field : 'deathAdd',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.death > vo.death1 ? "red" : (vo.death == vo.death1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.death - vo.death1;
	}
}, {
	title : '新增率',
	field : 'deathIncrRate',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.death > vo.death1 ? "red" : (vo.death == vo.death1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		if (vo.death == 0) {
			return '-100.0%';
		}
		if (vo.death1 == 0) {
			return '100.0%';
		}
		var percent = Number((vo.death - vo.death1) / vo.death1 * 100)
				.toFixed(1)
				+ "%";
		return percent;
	}
}, {
	title : '累计',
	field : 'death',
	width : 40,
	rowspan : 1,
	align : 'right',
	styler : function(value, vo, index) {
		var color = vo.death > vo.death1 ? "red" : (vo.death == vo.death1
				? "black"
				: "green");
		return 'background-color:' + color + ';color:white;'
	},
	formatter : function(value, vo) {
		return vo.death;
	}
}]];