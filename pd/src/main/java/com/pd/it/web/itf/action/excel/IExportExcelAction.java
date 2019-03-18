package com.pd.it.web.itf.action.excel;

import com.pd.it.common.vo.VO;

public interface IExportExcelAction {

	default Object exportExcel(VO fo) {
		Object validRs = validExportExcel(fo);
		return validRs != null ? validRs : executeExportExcel(fo);
	};

	default Object validExportExcel(VO vo) {
		return null;
	};

	default Object executeExportExcel(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
