package com.pd.it.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.app.housePrice.month.listMonth.HousePriceService;

/**
 * 房价应用
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("app/housePrice")
public class HousePriceRestService {

	@Autowired
	private HousePriceService service;

	@RequestMapping(value = "query")
	public Object query() {
		return service.query(null);
	}

	@RequestMapping(value = "save")
	public Object save() {
		return service.save(null);
	}
}
