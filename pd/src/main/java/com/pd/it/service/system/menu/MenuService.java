package com.pd.it.service.system.menu;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.exception.AppException;
import com.pd.it.common.exception.CommonAppException;
import com.pd.it.dao.system.menu.MenuDao;
import com.pd.it.model.system.menu.MenuFO;
import com.pd.it.model.system.menu.MenuVO;

@Service
public class MenuService {

	@Autowired
	protected MenuDao dao;

	public List<MenuVO> queryList(MenuFO in) throws AppException {
		try {
			return dao.queryList(in);
		} catch (SQLException e) {
			throw new CommonAppException("queryList failed", e);
		}
	}

}
