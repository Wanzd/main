package com.pd.api;

import java.util.List;

public interface IBaseDao<VO extends DatabaseVO, FO extends IFilterVO>
{
    public PagedList<VO> pagedList(FO filterVO, PageVO page);
    
    public List<VO> pagedList(FO filterVO);
    
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
