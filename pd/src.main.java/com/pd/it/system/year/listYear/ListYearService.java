package com.pd.it.system.year.listYear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service("listYearService")
public class ListYearService implements IDbService<VO, FO, VO, IDao<VO, FO, VO>> {

	@Autowired
	private ListYearDao dao;

	@Override
	public IDao<VO, FO, VO> getDao() {
		return dao;
	}

}
