package com.pd.common.report;

import com.pd.common.vo.ReportVO;

public class ReportService implements IReportService
{
    
    public ReportVO vo;
    
    public ReportService(Object obj)
    {
        if (obj instanceof ReportVO)
        {
            this.vo = (ReportVO)obj;
        }
    }
    
    @Override
    public String report()
    {
        return vo.getXml();
    }
    
}
