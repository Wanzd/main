package com.pd.common.util;

import java.util.List;

import com.pd.common.service.IPropertyService;
import com.pd.common.vo.MetaModelVO;

public class MetaModelUtil
{
    public static List<MetaModelVO> getAllModel()
    {
        IPropertyService service = Config.getService("config/models");
        return null;
    }
}
