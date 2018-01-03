package com.pd.it.common.itf;

public interface IService<Vo, Fo extends Vo>
{
    int c(Vo vo);
    
    Vo r(Fo fo);
    
    int d(Vo vo);
    
    int u(Vo vo);
    
}
