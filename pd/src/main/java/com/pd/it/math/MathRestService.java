package com.pd.it.math;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.math.service.RateService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/math")
public class MathRestService implements IDimensionRestService {
	@Inject
	protected RateService rate;

}
