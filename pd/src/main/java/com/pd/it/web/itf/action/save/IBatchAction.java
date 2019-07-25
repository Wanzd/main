package com.pd.it.web.itf.action.save;

import java.util.List;

import com.pd.it.base.util.Reflects;
import com.pd.it.base.util.x.ListX;
import com.pd.it.common.itf.IDao;
import com.pd.it.common.vo.VO;

public interface IBatchAction {

	default Object batch(VO fo) {
		Object validRs = validBatch(fo);
		return validRs != null ? validRs : executeBatch(fo);
	};

	default Object validBatch(VO vo) {
		return null;
	};

	default Object executeBatch(VO vo) {
		IDao dao = Reflects.field(this, "dao");
		VO rsVO = new VO();
		List<VO> createList = ListX.<VO>list(vo.get("items2Create"), VO.class);
		if (createList != null && createList.size() > 0) {

			dao.insertList(createList);
			rsVO.put("insertCount", createList.size());
		}
		List<VO> deleteList = ListX.<VO>list(vo.get("items2Delete"), VO.class);
		if (deleteList != null && deleteList.size() > 0) {
			dao.deleteList(deleteList);
			rsVO.put("deleteCount", deleteList.size());
		}
		List<VO> updateList = ListX.<VO>list(vo.get("items2Update"), VO.class);
		if (updateList != null && updateList.size() > 0) {
			dao.updateList(updateList);
			rsVO.put("updateCount", updateList.size());
		}

		if (rsVO.size() == 0) {
			rsVO.put("MSG", "Not operate any data !");
		}
		return rsVO;
	};

}
