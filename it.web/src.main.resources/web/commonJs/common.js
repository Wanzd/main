define(["ai"], function() {

		});
define(['tree'], function() {
			return {
				root : function(treeId) {
					var treeObj = $("#" + treeId);
					return treeObj.tree("getRoot");
				},
				find : function(vo) {
					var treeObj = $("#" + vo.treeId);
					return treeObj.tree("find", vo.itemId);
				},
				removeSub : function(vo) {

				},
				selected : function(treeId) {
					var treeObj = $("#" + treeId);
					return treeObj.tree("getSelected");
				},
				sub : function(treeId, parent) {
					var treeObj = $("#" + treeId);
					return treeObj.tree("getNode", parent);
				},
				append : function(vo) {
					var treeObj = $("#" + vo.treeId);
					treeObj.tree("append", {
								parent : vo.parent,
								data : vo.data,
								onClick : vo.onClickF
							});
				},
				refresh : function(vo) {
					var selectId = $r("tree.selected", vo.treeId).id;
					var treeObj = $("#" + vo.treeId);
					var allItem = treeObj.tree("getChildren");
					$r("tree.removeSub", {
								treeId : vo.treeId,
								itemId : selectId
							});
					treeObj.tree("append", {
								parent : vo.parent,
								data : vo.data,
								onClick : vo.onClickF
							});
				}
			}
		})

define(['ajax'], function() {
			return {
				post : {
					str : function(vo) {
						vo.type = "POST";
						vo.dataType = "text";
						vo.async = false;
						// return $aiAtom.post(vo);
					},
					json : function(vo) {
						vo.type = "POST";
						vo.dataType = "json";
						vo.async = false;
						// return $aiAtom.post(vo);
					}
				},
				get : {
					str : function(vo) {
						vo.type = "get";
						vo.dataType = "text";
						vo.aysnc = false;
						// return $aiAtom.ajax(vo);
					},
					json : function(vo) {
						vo.type = "get";
						vo.dataType = "json";
						vo.aysnc = false;
						// return $aiAtom.ajax(vo);
					}
				}
			}
		});
