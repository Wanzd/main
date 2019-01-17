package com.pd.it.module.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service("menuTreeService")
public class MenuTreeService implements IDbService<VO, FO, VO, IDao<VO, FO, VO>> {

	@Autowired
	private IMenuTreeDao dao;

	@Override
	public IDao<VO, FO, VO> getDao() {
		return dao;
	}

}
