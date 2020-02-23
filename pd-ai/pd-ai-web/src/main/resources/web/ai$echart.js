define(['ai$echart'], function() {
			var impl = {
				x$TreeMapVO : function(groupVO) {
					var rsVO = [];
					for (var eachAttrName in groupVO) {
						var eachAttr = groupVO[eachAttrName];
						var curVO = new Object();;
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
					for (var eachAttrName in groupVO) {
						var eachAttr = groupVO[eachAttrName];
						var curVO = new Object();;
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
				},
				x$option$scatter3D : function(data) {
					var symbolSize = 2.5;
					var option = {
						grid3D : {},
						xAxis3D : {
							type : 'category'
						},
						yAxis3D : {},
						zAxis3D : {},
						dataset : {
							dimensions : ['qty', 'city', {
										name : 'creationDate',
										type : 'ordinal'
									}],
							source : data
						},
						series : [{
									type : 'scatter3D',
									symbolSize : symbolSize,
									encode : {
										x : 'city',
										y : 'creationDate',
										z : 'qty',
										tooltip : [0, 1, 2]
									}
								}]
					};
					return option;
				},
				x$option$line : function(data) {
					var list = data.list;
					xDatas = [];
					yDatas = [];
					$.each(list, function(idx, it) {
								xDatas.push(list[idx][data.xCol]);
								yDatas.push(list[idx][data.yCol]);
							})
					var option = {
						title : {
							text : data.title
						},
						xAxis : {
							type : 'category',
							data : xDatas
						},
						yAxis : {
							type : 'value'
						},
						series : [{
									data : yDatas,
									type : 'line'
								}]
					};
					return option;
				},
				x$option$treeMap : function(data) {
					var list = data.list;
					var datas = [];
					$.each(list, function(idx, it) {
								datas.push({
											name : it.name,
											value : it.qty
										});
							})
					var option = {
						title : {
							text : data.title
						},
						tooltip : {
							confine : true
						},
						series : [{
									data : datas,
									type : 'treemap'
								}]
					};
					return option;
				},
				x$option$stackLine : function(data) {
					var list = data.list;
					var zDatas = [];
					var xDatas = [];
					var yDatas = [];
					$.each(list, function(i, it) {
								if (i == 0) {
									$.each(it.list, function(i2, it2) {
												xDatas.push(it2[data.xCol]);
											})
								}
								zDatas.push(it[data.zCol]);

								tmpData = [];
								$.each(it.list, function(i2, it2) {
											tmpData.push(it2[data.yCol]);
										})
								yData = {
									name : it[data.zCol],
									type : "line",
									data : tmpData
								};
								yDatas.push(yData);
							});
					var option = {
						title : {
							text : data.title
						},
						tooltip : {
							trigger : 'axis',
							confine : true
						},
						legend : {
							data : zDatas
						},
						grid : {
							left : '3%',
							right : '4%',
							bottom : '3%',
							containLabel : true
						},
						toolbox : {
							feature : {
								saveAsImage : {}
							}
						},
						xAxis : {
							type : 'category',
							boundaryGap : false,
							data : xDatas
						},
						yAxis : {
							type : 'value'
						},
						series : yDatas
					};
					return option;
				}
			};
			impl.x$option = function(data) {
				var option = null;
				fMap = {
					"line" : impl.x$option$line,
					"stackLine" : impl.x$option$stackLine,
					"scatter3D" : impl.x$option$scatter3D,
					"treeMap" : impl.x$option$treeMap
				}
				f = fMap[data.chartType]
				return f != null ? f(data) : null;
			}
			return impl;
		});
