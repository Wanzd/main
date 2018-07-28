package com.pd.it.task.heat;

import java.util.List;

import com.pd.it.common.itf.ITask;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.vo.VO;
import com.pd.it.db.dbvo.builder.DictionaryCountBuilder;

public class JobSkillHeatTask implements ITask
{
    
    @Override
    public void execute()
    {
        
        // 初始化字典结果表
        Db.u("51Job$skillHeat$truncate.u");
        
        // 对字典内的词进行计数，并返回统计结果
        List<VO> rsList = AI.build(new DictionaryCountBuilder());
        Db.u("51job$skill$dictCount.u", rsList);
    }
    
}
