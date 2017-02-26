package com.pd.ehr.task;

import com.pd.base.EhrApi.Agent.ITask;
import com.pd.ehr.app.report.dto.ReportFo;
import com.pd.ehr.app.report.dto.ReportVo;
import com.pd.ehr.app.report.impl.ReportChannel;
import com.pd.ehr.app.report.impl.ReportVoToMailVoBuilder;
import com.pd.ehr.base.mail.dto.EhrMailVo;
import com.pd.ehr.base.mail.impl.MailChannel;

/**
 * 
 * 日报任务体
 * 
 * @author 姓名 工号
 * @version [版本号, 2017年1月23日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DailyReportTask implements ITask
{
    
    @Override
    public void execute(Object _in)
    {
        ReportVo reportVo = ReportChannel.DailyCommon.build((ReportFo)_in);
        System.out.println(reportVo);
        EhrMailVo ehrMailVo = new ReportVoToMailVoBuilder().build(reportVo);
        MailChannel.NetEaseBySession.send(ehrMailVo);
    }
    
    public static void main(String[] args)
    {
        new DailyReportTask().execute(null);
    }
}
