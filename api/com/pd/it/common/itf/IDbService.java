package com.pd.it.common.itf;

import org.apache.ibatis.annotations.SelectProvider;

import com.pd.it.common.provider.AiSqlProvider;

public interface IDbService<Vo, Fo extends Vo>
    extends IService<Vo, Fo>, IBatchService<Vo, Fo>
{
    
}
