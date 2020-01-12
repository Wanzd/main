package com.pd.ai.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.ai.dao.ISystemMenuDao;
import com.pd.ai.model.SystemMenuDTO;
import com.pd.ai.model.SystemMenuFO;
import com.pd.it.common.Reflects;
import com.pd.it.operation.api.IQueryOperation;
import com.pd.it.rest.api.IQueryRest;
import com.pd.it.rest.api.IRest;

/**
 * 系统菜单rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/rest/system/menu")
public class SystemMenuRest implements IRest, IQueryRest<SystemMenuFO, SystemMenuDTO> {
	@Inject
	private ISystemMenuDao dao;

	@RequestMapping(value = "/root")
	@ResponseBody
	public List<SystemMenuDTO> root() {
		IQueryOperation<SystemMenuFO, SystemMenuDTO> operation = Reflects.firstExistField(this, IQueryOperation.class,
				"dao,service,business");
		return operation.queryList(new SystemMenuFO());
	}

	@RequestMapping(value = "/sub", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<SystemMenuDTO> root(SystemMenuFO fo) {
		IQueryOperation<SystemMenuFO, SystemMenuDTO> operation = Reflects.firstExistField(this, IQueryOperation.class,
				"dao,service,business");
		return operation.queryList(fo);
	}
}
