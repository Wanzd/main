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
//public class JokeQiushibaikeHeatTask implements ITask
//{
//    
//    @Override
//    public void execute()
//    {
//        
//        // 初始化字典结果表
//        Db.u("joke$thumbsHeat$cloud.truncate");
//        
//        // 对字典内的词进行计数，并返回统计结果
//        List<VO> rsList = AI.build(new DictionaryCountBuilder());
//        
//        Db.u("joke$thumbsHeat$cloud.us", rsList);
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
//            List<VO> detailList = getDetail();
//            return count(detailList);
//            
//        }
//        
//        private List<VO> count(List<VO> detailList)
//        {
//            Map<String, Double> rsMap = new HashMap<String, Double>();
//            for (VO eachDetail : detailList)
//            {
//                String text = eachDetail.str("text");
//                double c = eachDetail.num("thumbs");
//                c = c == 0 ? 1 : c;
//                for (int curStart = 0, total = text.length(); curStart < total; curStart++)
//                {
//                    for (int curLength = MIN_LENGTH; (curLength < MAX_LENGTH)
//                        && (curStart + curLength < total); curLength++)
//                    {
//                        try
//                        {
//                            String tmpStr = text.substring(curStart, curStart + curLength).toLowerCase();
//                            if (!V.isWordChar(tmpStr))
//                            {
//                                break;
//                            }
//                            Double oldCount = rsMap.get(tmpStr);
//                            double newCount = (oldCount == null ? 1 : oldCount) + Math.log10(c * 10);
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
//            return rsList;
//        }
//        
//        private List<VO> getDetail()
//        {
//            return Db.ra("joke$thumbsHeat.ra");
//        }
//        
//    }
//    
//}
