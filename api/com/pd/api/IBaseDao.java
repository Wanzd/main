package com.pd.api;

import java.util.List;

public interface IBaseDao<Vo extends DatabaseVO, Fo extends IFilterVO>
{
    public PagedList<Vo> pagedList(Fo filterVO, PageVO page);
    
    public List<Vo> listAll(Fo filterVO);
    public List<Vo> listValid(Fo filterVO);
    public List<Vo> listActived(Fo filterVO);
    
    public Vo get(Vo vo);
    
    public long getNextSeq();
    
    public int add(Vo vo);
    
    public int adds(List<Vo> list);
    
    public int batchUpdate(BatchVO<Vo> batchVO);
    
    public int update(Vo vo);
    
    public int updates(List<Vo> list);
    
    public int delete(Vo vo);
    
    public int deletes(List<Vo> list);
}
