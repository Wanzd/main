package com.pd.it.dev.request;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.ISimpleDao;
import com.pd.it.common.vo.VO;

@Repository
public interface IRequestDao extends ISimpleDao<VO> {

}