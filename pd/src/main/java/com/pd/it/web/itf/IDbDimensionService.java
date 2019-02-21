package com.pd.it.web.itf;

import java.util.List;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.itf.IDao;
import com.pd.it.common.model.BatchVO;
import com.pd.it.common.util.Valids;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

public interface IDbDimensionService<Dao extends IDao<VO, FO, VO>> extends IDimensionService {

	default Dao getDao() {
		return (Dao) Reflects.field(this, "dao");
	};

	@Override
	default Object validQuery(VO vo) {
		return null;
	}

	@Override
	default Object executeQuery(VO vo) {
		switch (vo.str("queryType")) {
		default:
			return getDao().ra(new FO(vo));
		}
	};

	@Override
	default Object validUpdate(VO vo) {
		return null;
	}

	@Override
	default Object executeUpdate(VO vo) {
		switch (vo.str("updateType")) {
		default:

			BatchVO<VO> batchVO = X.transformBatch(vo, VO.class);

			int rs = 0;

			List<VO> csList = batchVO.getItems2Create();
			if (Valids.notEmpty(csList)) {
				rs += getDao().cs(csList);
			}

			List<VO> dsList = batchVO.getItems2Delete();
			if (Valids.notEmpty(csList)) {
				rs += getDao().ds(dsList);
			}

			List<VO> usList = batchVO.getItems2Update();
			if (Valids.notEmpty(csList)) {
				rs += getDao().us(usList);
			}
			return rs;
		}
	};

}
