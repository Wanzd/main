package com.pd.it.system.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.web.itf.IMultyRouteService;

/**
 * 待办rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/system/lookupRest")
public class LookupRestService implements IMultyRouteService {
	@Autowired
	protected LookupTypeService lookupType;
	@Autowired
	protected LookupItemService lookupItem;

}
