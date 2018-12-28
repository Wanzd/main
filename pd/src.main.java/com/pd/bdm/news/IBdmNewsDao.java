package com.pd.bdm.news;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Repository
public interface IBdmNewsDao extends IDao<VO, FO, VO> {

}