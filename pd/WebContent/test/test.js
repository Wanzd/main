$testAtom = {
	indexedDbT : {
		openDb : function() {
			var dbVO = {
				name : 'user'
			};
			$indexDbU.openDb(dbVO);
		},
		createTable : function() {
			var createTableVO = {
				id : 'user',
				cols : {
					key : 'id'
				}
			};
			$indexDbU.createTable(createTableVO);
		},
		addData : function() {
			$test.indexedDbT.openDb();
			$test.indexedDbT.createTable();
		}
	}
};
$test = {
	dateT : {
		now : function() {
			$msg($dateU.now());
		}
	},
	indexedDbT : {
		addData : function() {
			$testAtom.indexedDbT.openDb();
			$testAtom.indexedDbT.createTable();
		}
	}
}