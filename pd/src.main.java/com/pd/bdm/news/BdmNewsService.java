package com.pd.bdm.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDbService;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Service("bdmNewsService")
public class BdmNewsService implements IDbService<VO, FO, VO, IBdmNewsDao> {

	@Autowired
	private IBdmNewsDao dao;

	@Override
	public IBdmNewsDao getDao() {
		return dao;
	}

}
