package com.pd.it.web.itf.service;

import java.util.List;

import com.pd.it.base.util.Reflects;
import com.pd.it.base.util.x.BatchX;
import com.pd.it.common.itf.IDao;
import com.pd.it.common.util.Valids;
import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.action.save.IBatchAction;
import com.pd.it.web.itf.action.save.ICreateAction;
import com.pd.it.web.itf.action.save.IDeleteAction;
import com.pd.it.web.itf.action.save.IUpdateAction;

public interface ISaveService extends IBatchAction, ICreateAction, IDeleteAction, IUpdateAction {
	@Override
	default Object executeUpdate(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.update(vo);
	};

	@Override
	default Object executeBatch(VO vo) {
		IDao dao = Reflects.field(this, "dao");

		BatchVO<VO> batchVO = BatchX.vo(vo, VO.class);

		int rs = 0;

		List<VO> csList = batchVO.getItems2Create();
		if (Valids.notEmpty(csList)) {
			rs += dao.insertList(csList);
		}

		List<VO> dsList = batchVO.getItems2Delete();
		if (Valids.notEmpty(dsList)) {
			rs += dao.deleteList(dsList);
		}

		List<VO> usList = batchVO.getItems2Update();
		if (Valids.notEmpty(usList)) {
			rs += dao.updateList(usList);
		}
		return rs;
	};
}
