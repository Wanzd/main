console.log(1);
var ehr={
	out:function(_in){
		print(_in);
	},
	run:function(){
		print("ehr.run");
	},
	sub:{
		run:function(){
			alert("ehr.sub.run");
		}
	}
};
var runImpl=function(){
	print("runImpl");
}
ehr.sub.run();
		