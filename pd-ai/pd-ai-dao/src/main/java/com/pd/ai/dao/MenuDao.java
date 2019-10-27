package com.pd.ai.dao;

import org.springframework.stereotype.Repository;

import com.pd.ai.model.SystemMenuFO;
import com.pd.ai.model.SystemMenuVO;
import com.pd.base.dao.IDao;

@Repository
public interface MenuDao extends IDao<SystemMenuVO, SystemMenuFO, SystemMenuVO> {

}