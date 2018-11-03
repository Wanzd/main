package com.pd.it.system.grid;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.IDao;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.VO;

@Repository
public interface IGridSchemaDao extends IDao<VO, FO, VO> {

}