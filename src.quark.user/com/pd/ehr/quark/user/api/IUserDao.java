package com.pd.ehr.quark.user.api;

import com.pd.base.EhrApi.Db.IDao;
import com.pd.ehr.quark.user.dto.UserFo;
import com.pd.ehr.quark.user.dto.UserVo;

public interface IUserDao<_Vo extends UserVo, _Fo extends UserFo> extends IDao<_Vo, _Fo>
{
    
}
