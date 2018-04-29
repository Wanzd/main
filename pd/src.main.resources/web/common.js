define([ 'common' ], function() {
	return {
		ajax : function(url, data) {
			debugger;
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
		}
	};
});
