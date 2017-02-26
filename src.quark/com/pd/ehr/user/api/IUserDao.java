package com.pd.ehr.user.api;

import com.pd.base.EhrApi.Db.IDao;
import com.pd.ehr.user.dto.UserFo;
import com.pd.ehr.user.dto.UserVo;

public interface IUserDao<_Vo extends UserVo, _Fo extends UserFo> extends IDao<_Vo, _Fo>
{
    
}
