define([ 'common' ], function() {
	return {
		ajax : function(url, data) {
			var rs = $.ajax({
				url : url,
				async : false
			});
			var rsJson = eval("(" + rs.responseText + ")");
			return rsJson;
		},
		parseUrl : function(url) {
			var result = {};
			var query = url.split("?")[1];
			var queryArr = query.split("&");
			queryArr.forEach(function(item) {
				var obj = {};
				var key = item.split("=")[0];
				var value = item.split("=")[1];
				result[key] = value;
			});
			return result;
		},
		addTab:function(vo){
			if ($('#'+vo.divId).tabs('exists', vo.title)){
				$('#'+vo.divId).tabs('select', vo.title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'+vo.url+'" style="width:100%;height:100%;"></iframe>';
				$('#tt').tabs('add',{
					title:vo.title,
					content:content,
					closable:true
				});
			}
		},
		attrArray:function(data,attrName){
			var result=[];
			for(var i=0,total=data.length;i<total;i++){
				result.push(data[i][attrName]);
			}
			return result;
		}
	};
});
