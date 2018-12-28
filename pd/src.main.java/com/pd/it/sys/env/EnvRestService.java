package com.pd.it.sys.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 房价应用
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("sys/env")
public class EnvRestService {

	@Autowired
	private EnvService service;

	@RequestMapping(value = "init")
	public Object init() {
		return service.init();
	}

}
