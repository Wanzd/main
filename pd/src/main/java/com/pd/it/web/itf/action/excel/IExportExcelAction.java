package com.pd.it.web.itf.action.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.pd.it.base.util.Excels;
import com.pd.it.base.util.Reflects;
import com.pd.it.common.itf.IDao;
import com.pd.it.common.util.x.Trans;
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
		IDao dao = Reflects.field(this, IDao.class, "dao");
		HttpServletResponse response = Reflects.field(this, HttpServletResponse.class, "response");
		Class exportClass = Reflects.field(this, Class.class, "exportClass");

		List list = Trans.list(dao.queryList(vo), exportClass);

		try {
			return Excels.getTestResponse(response, list);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	};

}
