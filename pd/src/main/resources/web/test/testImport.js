require.config({
	urlArgs : "r=" + (new Date()).getTime(),
	paths : {
		jquery : "../jquery.min",
		easyui : "../jquery.easyui.min",
		common : "../common"
	},
	shim : {
		"easyui" : {
			deps : [ "jquery" ]
		}
	}
});
require([ 'jquery', 'common' ], function(jquery, common) {
	$('#excel-file').change(
			function(e) {
				var files = e.target.files;
				var fileReader = new FileReader();
				fileReader.onload = function(ev) {
					try {
						var data = ev.target.result;
						workbook = XLSX.read(data, {
							type : 'binary'
						}); // 以二进制流方式读取得到整份excel表格对象
						persons = []; // 存储获取到的数据
					} catch (e) {
						console.log('文件类型不正确');
						return;
					}

					// 表格的表格范围，可用于判断表头是否数量是否正确
					var fromTo = '';
					// 遍历每张表读取
					for ( var sheet in workbook.Sheets) {
						if (sheet == "personRelation") {
							fromTo = workbook.Sheets[sheet]['!ref'];
							persons = persons.concat(XLSX.utils
									.sheet_to_json(workbook.Sheets[sheet]));
							// break; // 如果只取第一张表，就取消注释这行
						}
					}

					console.log(persons);
					debugger;
					var data = common.ajax("../app/personRelation/importExcel", {
						"list" : persons
					});
				};

				// 以二进制方式打开文件
				fileReader.readAsBinaryString(files[0]);
			});
});