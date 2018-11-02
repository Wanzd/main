//package com.pd.it.task.heat;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.pd.it.common.itf.IBuilder;
//import com.pd.it.common.itf.ITask;
//import com.pd.it.common.util.AI;
//import com.pd.it.common.util.Db;
//import com.pd.it.common.util.V;
//import com.pd.it.common.util.X;
//import com.pd.it.common.vo.VO;
//import com.pd.it.db.dbvo.builder.CountMapFiltBuilder;
//import com.pd.it.db.dbvo.builder.MaxMatchFiltBuilder;
//
//public class JobSkillHeatTask implements ITask
//{
//    
//    @Override
//    public void execute()
//    {
//        
//        // 初始化字典结果表
//        Db.u("51Job$skillHeat$truncate.u");
//        
//        // 对字典内的词进行计数，并返回统计结果
//        List<VO> rsList = AI.build(new DictionaryCountBuilder());
//        
//        Db.u("51job$skill$dictCount.u", rsList);
//    }
//    
//    private static class DictionaryCountBuilder implements IBuilder<String, List<VO>>
//    {
//        
//        public static final int MAX_LENGTH = 15;
//        
//        public static final int MIN_LENGTH = 2;
//        
//        @Override
//        public List<VO> build(String in)
//        {
//            List<String> dictList = getDictSet();
//            List<String> detailList = getDetail();
//            return count(detailList, dictList);
//            
//        }
//        
//        private List<VO> count(List<String> detailList, List<String> dictList)
//        {
//            Map<String, Double> rsMap = new HashMap<String, Double>();
//            for (String eachDetail : detailList)
//            {
//                for (int curStart = 0, total = eachDetail.length(); curStart < total; curStart++)
//                {
//                    for (int curLength = MIN_LENGTH; (curLength < MAX_LENGTH)
//                        && (curStart + curLength < total); curLength++)
//                    {
//                        try
//                        {
//                            String tmpStr = eachDetail.substring(curStart, curStart + curLength).toLowerCase();
//                            if (!V.isWordChar(tmpStr))
//                            {
//                                break;
//                            }
//                            Double oldCount = rsMap.get(tmpStr);
//                            double newCount = (oldCount == null ? 0 : oldCount) + 1;
//                            rsMap.put(tmpStr, newCount);
//                        }
//                        catch (Exception e)
//                        {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//            rsMap = AI.build(new CountMapFiltBuilder(3), rsMap);
//            rsMap = AI.build(new MaxMatchFiltBuilder(), rsMap);
//            List<VO> rsList = X.map2voList(rsMap, "text", "c");
//            List<VO> voList = getJobVO();
//            l1: for (VO eachJobVO : voList)
//            {
//                l2: for (VO eachVO : rsList)
//                {
//                    if (eachVO.get("salaryStart") == null)
//                    {
//                        eachVO.put("salaryStart", 0);
//                    }
//                    if (eachVO.get("salaryEnd") == null)
//                    {
//                        eachVO.put("salaryEnd", 0);
//                    }
//                    eachVO.put("salaryAvg", (eachVO.num("salaryStart") + eachVO.num("salaryEnd")) / 2);
//                    if (!eachJobVO.str("detail").contains(eachVO.str("text")))
//                    {
//                        continue l2;
//                    }
//                    if (eachVO.num("salaryStart") == 0)
//                    {
//                        eachVO.put("salaryStart", eachJobVO.num("salaryStart"));
//                    }
//                    double newStart = Math.min(eachVO.num("salaryStart"), eachJobVO.num("salaryStart"));
//                    eachVO.put("salaryStart", newStart);
//                    
//                    if (eachVO.num("salaryEnd") == 0)
//                    {
//                        eachVO.put("salaryEnd", eachJobVO.num("salaryEnd"));
//                    }
//                    double newEnd = Math.max(eachVO.num("salaryEnd"), eachJobVO.num("salaryEnd"));
//                    eachVO.put("salaryEnd", newEnd);
//                    
//                    eachVO.put("salaryAvg", (newStart + newEnd) / 2);
//                }
//            }
//            return rsList;
//        }
//        
//        private List<VO> getJobVO()
//        {
//            return Db.ra("51Job.ra");
//        }
//        
//        private List<String> getDetail()
//        {
//            return Db.strs("51job$detail.strs");
//        }
//        
//        private List<String> getDictSet()
//        {
//            return Db.strs("51job$skill$dictionary.strs");
//        }
//        
//    }
//    
//}
