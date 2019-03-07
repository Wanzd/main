package com.pd.it.web.itf;

import com.pd.it.common.vo.VO;

public interface IImportExcelService {

	default Object importExcel(VO fo) {
		Object validRs = validImportExcel(fo);
		return validRs != null ? validRs : executeImportExcel(fo);
	};

	default Object validImportExcel(VO vo) {
		return null;
	};

	default Object executeImportExcel(VO vo) {
		return new VO().put("MSG", "Not impl yet");
	};

}
