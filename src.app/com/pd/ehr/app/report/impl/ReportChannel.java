package com.pd.ehr.app.report.impl;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.app.report.dto.ReportFo;
import com.pd.ehr.app.report.dto.ReportVo;

public enum ReportChannel implements IBuilder<ReportFo, ReportVo>
{
    DailyCommon(new ReportDailyCommonBuilder());
    private IBuilder<ReportFo, ReportVo> builder;
    
    private ReportChannel(IBuilder<ReportFo, ReportVo> _builder)
    {
        builder = _builder;
    }
    
    @Override
    public ReportVo build(ReportFo _in)
    {
        return builder.build(_in);
    }
    
}
