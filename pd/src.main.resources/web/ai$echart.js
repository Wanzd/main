define([ 'ai$echart' ], function() {
	return {
		x$TreeMapVO : function(groupVO) {
			var rsVO = [];
			for ( var eachAttrName in groupVO) {
				var eachAttr = groupVO[eachAttrName];
				var curVO = new Object();
				;
				curVO.name = eachAttrName;
				var valueSum = 0;
				curVO.children = [];
				for (var i = 0, total = eachAttr.length; i < total; i++) {
					var tmpVO = eachAttr[i];
					valueSum += tmpVO.value;
					curVO.children.push(tmpVO);
				}
				curVO.value = valueSum;
				rsVO.push(curVO);
			}
			return rsVO;
		},
		x$sunBurstVO : function(groupVO) {
			var rsVO = [];
			for ( var eachAttrName in groupVO) {
				var eachAttr = groupVO[eachAttrName];
				var curVO = new Object();
				;
				curVO.name = eachAttrName;
				var valueSum = 0;
				curVO.children = [];
				for (var i = 0, total = eachAttr.length; i < total; i++) {
					var tmpVO = eachAttr[i];
					valueSum += tmpVO.value;
					tmpVO.name = tmpVO.detail;
					var colorMap = {
						1 : "yellow",
						2 : "orange",
						3 : "red"
					};
					tmpVO.itemStyle = {
						color : colorMap[tmpVO.value]
					};
					curVO.children.push(tmpVO);
				}
				curVO.value = valueSum;
				rsVO.push(curVO);
			}
			return rsVO;
		}
	};
});
