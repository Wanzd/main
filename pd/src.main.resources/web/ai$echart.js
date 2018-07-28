define([ 'ai$echart' ], function() {
	return {
		x$TreeMapVO : function(groupVO) {
			var rs = [ {
				name : 'nodeA', // First tree
				value : 10,
				children : [ {
					name : 'nodeAa', // First leaf of first tree
					value : 4
				}, {
					name : 'nodeAb', // Second leaf of first tree
					value : 6
				} ]
			}, {
				name : 'nodeB', // Second tree
				value : 20,
				children : [ {
					name : 'nodeBa', // Son of first tree
					value : 20,
					children : [ {
						name : 'nodeBa1', // Granson of first tree
						value : 20
					} ]
				} ]
			} ];

			var rsVO = [];
			debugger;
			for ( var eachAttrName in groupVO) {
				var eachAttr = groupVO[eachAttrName];
				var curVO = new Object();
				;
				curVO.name = eachAttrName;
				var valueSum = 0;
				curVO.children = [];
				for (var i = 0, total = eachAttr.length; i < total; i++) {
					var tmpVO = eachAttr[i];
					valueSum += tmpVO.c;
					curVO.children.push({
						name : tmpVO.text,
						value : tmpVO.c
					});
				}
				curVO.value = valueSum;
				rsVO.push(curVO);
			}
			return rsVO;
		}
	};
});
