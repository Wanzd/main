package com.pd.it.dao.system.menu;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.IDao;
import com.pd.it.model.system.menu.MenuFO;
import com.pd.it.model.system.menu.MenuVO;

@Repository
public interface MenuDao extends IDao<MenuVO, MenuFO, MenuVO> {

}