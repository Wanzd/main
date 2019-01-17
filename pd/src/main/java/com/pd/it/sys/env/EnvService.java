package com.pd.it.sys.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("envService")
public class EnvService {

	@Autowired
	private MysqlEnvService mysqlService;

	public Object init() {
		return mysqlService.init();
	}

}
