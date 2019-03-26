package com.pd.it.web.itf.service;

import java.util.List;

import com.pd.it.base.util.Reflects;
import com.pd.it.base.util.x.BatchX;
import com.pd.it.common.itf.IDao;
import com.pd.it.common.util.Toy;
import com.pd.it.common.util.Valids;
import com.pd.it.common.util.x.BatchVOX;
import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.VO;

public interface ICommonService extends IQueryService, ISaveService, IExcelService {
	@Override
	default Object executeRa(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.ra(vo);
	};

	@Override
	default Object executeR(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.r(vo);
	};

	@Override
	default Object executeUpdate(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.u(vo);
	};

	@Override
	default Object executeBatch(VO vo) {
		IDao dao = Reflects.field(this, "dao");

		BatchVO<VO> batchVO = BatchX.vo(vo, VO.class);

		int rs = 0;

		List<VO> csList = batchVO.getItems2Create();
		if (Valids.notEmpty(csList)) {
			rs += dao.cs(csList);
		}

		List<VO> dsList = batchVO.getItems2Delete();
		if (Valids.notEmpty(dsList)) {
			rs += dao.ds(dsList);
		}

		List<VO> usList = batchVO.getItems2Update();
		if (Valids.notEmpty(usList)) {
			rs += dao.us(usList);
		}
		return rs;
	};
}
