package com.pd.common.service;
import java.util.Date;

import com.pd.api.AreaVO;
import com.pd.common.service.ITimerCountService;
import com.pd.common.util.DateUtil;

public class TimerCountService implements ITimerCountService
{
    private AreaVO<Date> dateAreaVO = new AreaVO<Date>();
    
    @Override
    public void start()
    {
        dateAreaVO.setStart(new Date());
    }
    
    @Override
    public void end()
    {
        dateAreaVO.setEnd(new Date());
    }
    
    @Override
    public long count()
    {
        // TODO Auto-generated method stub
        return DateUtil.timeDiff(dateAreaVO.getStart(), dateAreaVO.getEnd());
    }
    
}
