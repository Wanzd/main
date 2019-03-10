package com.pd.it.web.itf;

import java.util.List;

import com.pd.it.base.util.Reflects;
import com.pd.it.common.itf.IDao;
import com.pd.it.common.util.Valids;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.BatchVO;
import com.pd.it.common.vo.VO;

public interface ICommonService extends IQueryService, IUpdateService, IImportExcelService {
<<<<<<< HEAD
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
=======
	default Object executeQuery(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		return dao.ra(vo);
	};

>>>>>>> branch 'dev_20190225' of https://github.com/Wanzd/main.git
	default Object executeUpdate(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		switch (vo.str("updateType")) {
		default:

			BatchVO<VO> batchVO = X.transformBatch(vo, VO.class);

			int rs = 0;

			List<VO> csList = batchVO.getItems2Create();
			if (Valids.notEmpty(csList)) {
				rs += dao.cs(csList);
			}

			List<VO> dsList = batchVO.getItems2Delete();
			if (Valids.notEmpty(csList)) {
				rs += dao.ds(dsList);
			}

			List<VO> usList = batchVO.getItems2Update();
			if (Valids.notEmpty(csList)) {
				rs += dao.us(usList);
			}
			return rs;
		}
	};

}
