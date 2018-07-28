package com.pd.it.task.dig;

import java.util.List;

import com.pd.it.bigdata.builder.Job51ParseBuilder;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.vo.VO;

public class Job51DigTask implements ITask
{
    
    @Override
    public void execute()
    {
        // 清除旧数据
        Db.u("51job.truncate");
        
        // 获取新数据
        VO vo = new VO();
        boolean flag = true;
        int curPage = 1;
        while (flag)
        {
            String url = "https://search.51job.com/list/180200,000000,0000,00,9,99,java,2," + curPage
                + ".html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
            vo.put("url", url);
            VO rest = NetUtil.rest(vo);
            
            List<VO> rsList = AI.build(new Job51ParseBuilder(), rest);
            
            if (rsList == null && rsList.size() == 0)
            {
                flag = false;
                break;
            }
            Db.u("51job.us", new VO("list", rsList));
            curPage++;
        }
    }
    
}
