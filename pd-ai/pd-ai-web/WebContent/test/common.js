$logU = {
	log : function(_vo) {
		console.log(_vo);
	},
	msg : function(_vo) {
		alert(_vo);
	}
};
$dateU = {
	now : function() {
		return new Date();
	}
};
$indexDbU = {
	conn : null,
	/** 打开数据库 */
	openDb : function(_vo) {
		var version = _vo.version || 1;
		var request = window.indexedDB.open(_vo.name, version);
		request.onerror = function(e) {
			console.log(e.currentTarget.error.message);
		};
		request.onsuccess = function(e) {
			$indexDbU.conn = e.target.result;
		};
		request.onupgradeneeded = function(e) {
			console.log('DB version changed to ' + version);
		};
	},
	createTable : function(_vo) {
		$indexDbU.conn.createObjectStore(_vo.id, {
					keyPath : _vo.cols.key
				});
	},
	/** 关闭数据库 */
	closeDb : function(_vo) {
		$indexDbU.conn.close();
	},
	/** 删除数据库 */
	deleteDb : function(_vo) {
		indexedDB.deleteDatabase(_vo.name);
	},
	addData : function(_vo) {
		var transaction = $indexDbU.conn.transaction(_vo.name, "readwrite");
		var table = transation.objectStore(_vo.name);
		for (var i = 0; i < _vo.data.length; i++) {
			table.add(data[i]);
		}
	},
	r : function(_vo) {
		var objectStore = db.transaction([_vo.table]).objectStore(_vo.table);
		var request = objectStore.get(_vo.id);
		request.onerror = function(event) {
			alert("Unable to retrieve data from database!");
		};
		request.onsuccess = function(event) {
			if (request.result) {
				alert("Name: " + request.result.name + ", Age: "
						+ request.result.age + ", Email: "
						+ request.result.email);
			} else {
				alert("Bidulata couldn't be found in your database!");
			}
		};
	},
	rAll : function(_vo) {

	}
};
$log = $logU.log;
$msg = $logU.msg;