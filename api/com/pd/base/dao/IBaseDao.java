package com.pd.base.dao;

import java.util.List;

import com.pd.ehr.core.vo.BatchVO;
import com.pd.ehr.core.vo.EhrDBVO;
import com.pd.ehr.core.vo.EhrPageVO;
import com.pd.ehr.core.vo.IEhrFilterVO;

public interface IBaseDao<VO extends EhrDBVO, FO extends IEhrFilterVO>
{
    public List<VO> pagedList(FO filterVO, EhrPageVO page);
    
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
