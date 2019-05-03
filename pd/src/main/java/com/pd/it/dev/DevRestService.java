package com.pd.it.dev;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.dev.genCode.GenCodeService;
import com.pd.it.dev.genModel.GenModelService;

/**
 * 开发者rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/dev")
public class DevRestService implements IDimensionRestService {
	@Inject
	protected GenModelService genModel;
	@Inject
	protected GenCodeService genCode;

}
