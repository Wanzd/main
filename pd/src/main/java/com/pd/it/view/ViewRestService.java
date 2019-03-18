package com.pd.it.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDimensionRestService;
import com.pd.it.view.common.CommonViewService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/viewRest")
public class ViewRestService implements IDimensionRestService {
	@Autowired
	protected CommonViewService commonService;

}
