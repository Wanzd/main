package com.pd.it.task.dig;

import java.util.List;

import com.pd.it.bigdata.builder.House$fangtianxiaParseBuilder;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.util.F;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.vo.VO;

public class HouseFangtianxiaDigTask implements ITask
{
    
    @Override
    public void execute()
    {
        // 清除旧数据
        Db.u("house.truncate");
        
        // 获取新数据
        VO vo = new VO();
        boolean flag = true;
        int curPage = 1;
        while (flag)
        {
            String url = F.str("http://esf.wuhan.fang.com/house/i3%d/", curPage);
            vo.put("url", url);
            VO rest = NetUtil.jsoup(vo);
            
            List<VO> rsList = AI.build(new House$fangtianxiaParseBuilder(), rest);
            
            if (rsList == null && rsList.size() == 0)
            {
                flag = false;
                break;
            }
            Db.u("house.us", new VO("list", rsList));
            curPage++;
        }
    }
    
}
