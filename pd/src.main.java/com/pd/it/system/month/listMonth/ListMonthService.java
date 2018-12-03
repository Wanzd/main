package com.pd.it.system.month.listMonth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.itf.IDbService;
import com.pd.it.common.util.AI;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.RedisDao;

@Service("listMonthService")
public class ListMonthService implements IDbService<VO, FO, VO, IDao<VO, FO, VO>> {

	@Autowired
	private RedisDao dao;

	@Override
	public IDao<VO, FO, VO> getDao() {
		return null;
	}

	@Override
	public List<VO> ra(FO fo) {
		String string = dao.get(fo.str("key"));
		return AI.list(new VO(new Attr("a", string)));
	}

}
