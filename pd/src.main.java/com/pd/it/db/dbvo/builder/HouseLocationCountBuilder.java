package com.pd.it.db.dbvo.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.util.V;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.VO;

public class HouseLocationCountBuilder implements IBuilder<String, List<VO>>
{
    
    public static final int MAX_LENGTH = 15;
    
    public static final int MIN_LENGTH = 4;
    
    @Override
    public List<VO> build(String in)
    {
        List<String> detailList = Db.strs("house$location.strs");
        return count(detailList);
        
    }
    
    private List<VO> count(List<String> detailList)
    {
        Map<String, Integer> rsMap = new HashMap<String, Integer>();
        for (String eachDetail : detailList)
        {
            for (int curStart = 0, total = eachDetail.length(); curStart < total; curStart++)
            {
                for (int curLength = MIN_LENGTH; (curLength < MAX_LENGTH)
                    && (curStart + curLength < total); curLength++)
                {
                    try
                    {
                        String tmpStr = eachDetail.substring(curStart, curStart + curLength).toLowerCase();
                        if (!V.isWordChar(tmpStr))
                        {
                            break;
                        }
                        Integer oldCount = rsMap.get(tmpStr);
                        int newCount = (oldCount == null ? 0 : oldCount) + 1;
                        rsMap.put(tmpStr, newCount);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        rsMap = AI.build(new CountMapFiltBuilder(5), rsMap);
        rsMap = AI.build(new MaxMatchFiltBuilder(), rsMap);
        List<VO> rsList = X.map2voList(rsMap, "text", "c");
        List<VO> voList = getJobVO();
        l1: for (VO eachJobVO : voList)
        {
            l2: for (VO eachVO : rsList)
            {
                if (eachVO.get("salaryStart") == null)
                {
                    eachVO.put("salaryStart", 0);
                }
                if (eachVO.get("salaryEnd") == null)
                {
                    eachVO.put("salaryEnd", 0);
                }
                eachVO.put("salaryAvg", (eachVO.num("salaryStart") + eachVO.num("salaryEnd")) / 2);
                if (!eachJobVO.str("detail").contains(eachVO.str("text")))
                {
                    continue l2;
                }
                if (eachVO.num("salaryStart") == 0)
                {
                    eachVO.put("salaryStart", eachJobVO.num("salaryStart"));
                }
                double newStart = Math.min(eachVO.num("salaryStart"), eachJobVO.num("salaryStart"));
                eachVO.put("salaryStart", newStart);
                
                if (eachVO.num("salaryEnd") == 0)
                {
                    eachVO.put("salaryEnd", eachJobVO.num("salaryEnd"));
                }
                double newEnd = Math.max(eachVO.num("salaryEnd"), eachJobVO.num("salaryEnd"));
                eachVO.put("salaryEnd", newEnd);
                
                eachVO.put("salaryAvg", (newStart + newEnd) / 2);
            }
        }
        return rsList;
    }
    
    private List<VO> getJobVO()
    {
        return Db.ra("51Job.ra");
    }
    
}