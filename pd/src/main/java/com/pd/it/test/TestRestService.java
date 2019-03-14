package com.pd.it.test;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.app.economic.EconomicYearService;
import com.pd.it.app.user.PersonRelationService;
import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.test.curInfo.CurInfoService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/test")
public class TestRestService implements IDimensionRestService {
	@Autowired
	protected CurInfoService curInfoService;

}
