package com.pd.ehr.task;

import com.pd.EhrApi.Agent.ITask;
import com.pd.ehr.EhrLog;

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
        EhrLog.start();
    }
    public static void main(String[] args)
    {
        new DailyReportTask().execute(null);
    }
}
