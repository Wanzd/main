package com.pd.api;

public interface IDa<_V extends DbV, _F extends IFilter>
{
    @DaoApi
    long nextSeq();
    
    _V r(_F vo);
    
    int c(_V vo);
    
    int u(_V vo);
    
    int d(_V vo);
    
    PageList<_V> p(_F filterVO, PageV pageV);
}
