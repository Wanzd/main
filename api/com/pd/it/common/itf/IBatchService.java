package com.pd.it.common.itf;

import java.util.List;

public interface IBatchService<Vo, Fo extends Vo>
{
    
    int cs(List<Vo> list);
    
    List<Vo> rs(Fo fo);
    
    int ds(List<Vo> list);
    
    int us(List<Vo> list);
    
}
