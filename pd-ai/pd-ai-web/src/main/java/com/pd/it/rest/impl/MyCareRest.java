package com.pd.it.rest.impl;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.myCare.dao.impl.IMyCareDao;
import com.pd.it.rest.api.IRest;

@RestController
@RequestMapping("/myCareRest")
public class MyCareRest implements IRest {
	@Inject
	private IMyCareDao dao;
}
