package com.pd.common.util;

import com.pd.common.report.IReportService;
import com.pd.common.report.ReportService;

public class ReportUtil
{
    public static IReportService g(Object obj){
        
        return new ReportService(obj);
    }
}
