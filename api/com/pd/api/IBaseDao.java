package com.pd.api;

import java.util.List;

import com.pd.ehr.vo.BatchVO;
import com.pd.ehr.vo.DatabaseVO;
import com.pd.ehr.vo.EhrPageVO;
import com.pd.ehr.vo.IEhrFilterVO;

public interface IBaseDao<VO extends DatabaseVO, FO extends IEhrFilterVO>
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
