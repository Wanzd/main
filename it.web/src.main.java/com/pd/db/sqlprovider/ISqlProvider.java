package com.pd.db.sqlprovider;

import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;

public interface ISqlProvider
{
    String cal(KV path, VO vo);
}
