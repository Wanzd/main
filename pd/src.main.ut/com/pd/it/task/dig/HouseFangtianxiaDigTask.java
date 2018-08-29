package com.pd.it.task.dig;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.util.F;
import com.pd.it.common.util.Find;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.util.XmlUtil;
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
    
    private static class House$fangtianxiaParseBuilder implements IBuilder<VO, List<VO>>
    {
        static String xPath = "//div:class[e1]";
        
        @Override
        public List<VO> build(VO in)
        {
            String str = in.str("msg");
            str = str.replaceAll("<img .*>", "")
                .replaceAll("</dt>", "</a></dt>")
                .replaceAll("<i>|</i>|&#xfffd;O", "")
                .replaceAll("<dl ", "@@<dl ");
            String[] split = str.split("@@");
            List<VO> rsList = new ArrayList<VO>();
            for (String eachStr : split)
            {
                if (eachStr.length() == 0)
                {
                    continue;
                }
                try
                {
                    // List<Element> list = XmlUtil.readStr(eachStr, "//dl");
                    // for (Element eachElement : list)
                    // {
                    // rsList.add(element2VO(eachElement));
                    // }
                    rsList.addAll(str2vo(eachStr));
                    
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            
            return rsList;
        }
        
        private List<VO> str2vo(String str)
        {
            List<VO> rsList = new ArrayList<VO>();
            if (!str.startsWith("<dl "))
            {
                return rsList;
            }
            try
            {
                VO rsVO = new VO();
                String locationStr = Find.str$between(str, "<p class=\"add_shop\">", "</p>");
                rsVO.put("location",
                    Find.str$between(locationStr, "title=\"", "\"> ") + " "
                        + Find.str$between(locationStr, "<span>", "</span>"));
                String p1 = Find.str$between(str, "<p class=\"tel_shop\">", "</span>");
                String[] split = p1.split("\\|");
                rsVO.put("design", split[0].trim());
                rsVO.put("area", AI.num(split[1].trim()));
                rsVO.put("floor", split[2].substring(0, split[2].indexOf("层")));
                rsVO.put("floors", split[2].substring(split[2].indexOf("共") + 1, split[2].lastIndexOf("层")));
                rsVO.put("buildYear", split[4].substring(0, 4));
                rsVO.put("cost", AI.num(Find.str$between(str, "<span class=\"red\"><b>", "</b>")));
                rsVO.put("detail", Find.str$between(str, "<span class=\"tit_shop\">", "</span>"));
                rsVO.put("url", "http://esf.wuhan.fang.com" + Find.str$between(str, "\" href=\"", "\""));
                
                rsList.add(rsVO);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return rsList;
        }
        
    }
    
}
