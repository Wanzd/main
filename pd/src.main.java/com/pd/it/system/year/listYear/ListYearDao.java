package com.pd.it.system.year.listYear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.util.Format;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.Attr;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.FO$page;
import com.pd.it.common.vo.VO;

@Repository
public class ListYearDao implements IDao<VO, FO, VO> {

	@Override
	public int c(VO vo) {
		return 0;
	}

	@Override
	public int cs(List<VO> vo) {
		return 0;
	}

	@Override
	public VO r(FO fo) {
		return null;
	}

	@Override
	public String str(FO fo) {
		return null;
	}

	@Override
	public List<String> strs(FO fo) {
		return null;
	}

	@Override
	public int us(List<FO> vo) {
		return 0;
	}

	@Override
	public int ds(List<FO> vo) {
		return 0;
	}

	@Override
	public List<VO> ra(FO vo) {
		String yearStr = Format.date(new Date(), "yyyy");
		int year = X.int$str(yearStr);
		List<VO> rsList = new ArrayList<VO>();
		for (int i = 0; i < 10; i++) {
			VO curVO = new VO(new Attr("value", year - i), new Attr("text", year - i));
			if (i == 0) {
				curVO.p(new Attr("selected", true));
			}
			rsList.add(curVO);
		}
		return rsList;
	}

	@Override
	public List<VO> rs(FO$page arg0) {
		return null;
	}

}