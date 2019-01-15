package com.pd.it.common.vo;

public class VOFactory
{
    
    public static VO build(Object... kvArr)
    {
        VO rsVO = new VO();
        
        for (int i = 0, total = kvArr.length; i < total - 1; i += 2)
        {
            if (kvArr[i] != null)
            {
                rsVO.put(kvArr[i].toString(), kvArr[i + 1]);
            }
        }
        return rsVO;
    }
}
