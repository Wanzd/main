package com.pd.ehr.app.report.impl;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.app.report.dto.ReportFo;
import com.pd.ehr.app.report.dto.ReportVo;

class ReportDailyCommonBuilder implements IBuilder<ReportFo, ReportVo>
{
    
    @Override
    public ReportVo build(ReportFo _in)
    {
        ReportVo rsReportVo = new ReportVo();
        
        return rsReportVo;
    }
    
}
