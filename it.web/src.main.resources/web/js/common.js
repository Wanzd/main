var $commonAtom={
	validRule:{
		string:{
			"null":function(vo){
				return vo==null;
			}
		}
	}
};
var $commonCfg={};
var $commonImpl={};
matrix = {
	r : function(_vo) {
		var schema = _vo.schema;
		if (!schema || !schema.length || schema.length == 0) {
			return null;
		}
		var data = _vo.data;
		if (!data ) {
			return null;
		}
		var rsObj = {};
		for ( var eachData in data) {
			rsObj[eachData] = {};
			for (var i = 0; i < schema.length; i++) {
				rsObj[eachData][schema[i]] = data[eachData][i];
			}
		}
		return rsObj;
	}
}
var $ai={
	build:function(){
	},
	start:function(){
	},
	valid:function(vo){
		var validRule=$commonAtom.validRule;
		if(!validRule){
			return false;
		}
		var ruleSet=validRule[vo.types];
		if(!ruleSet){
			return false;
		}
		return ruleSet[vo.bean](vo.in);
	}
};