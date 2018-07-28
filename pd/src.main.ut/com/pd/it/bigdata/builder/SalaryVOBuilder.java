package com.pd.it.bigdata.builder;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.util.AI;
import com.pd.it.common.vo.VO;

public class SalaryVOBuilder implements IBuilder<String, VO>
{
    
    @Override
    public VO build(String in)
    {
        int unitValue = 0;
        if (in.endsWith("千/月"))
        {
            unitValue = 1000;
        }
        else if (in.endsWith("万/月"))
        {
            unitValue = 10000;
        }
        
        if (in.length() < 3)
        {
            VO rsVO = new VO();
            rsVO.put("salaryStart", 0);
            rsVO.put("salaryEnd", 0);
            return rsVO;
        }
        String valueStr = in.substring(0, in.length() - 3);
        String[] split = valueStr.split("-");
        VO rsVO = new VO();
        rsVO.put("salaryStart", AI.num(split[0]) * unitValue);
        rsVO.put("salaryEnd", AI.num(split[1]) * unitValue);
        return rsVO;
    }
    
}
