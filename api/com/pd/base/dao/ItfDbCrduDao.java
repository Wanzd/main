package com.pd.base.dao;

import java.util.List;

import com.pd.ehr.core.vo.BatchVO;
import com.pd.ehr.core.vo.EhrDBVO;

public interface ItfDbCrduDao<VO extends EhrDBVO> extends IBaseDao
{
    public List<VO> listAll(VO filterVO);
    
    public VO get(VO vo);
    
    public long getNextSeq();
    
    public int add(VO vo);
    
    public int adds(List<VO> list);
    
    public int batchUpdate(BatchVO<VO> batchVO);
    
    public int update(VO vo);
    
    public int updates(List<VO> list);
    
    public int delete(VO vo);
    
    public int deletes(List<VO> list);
}
