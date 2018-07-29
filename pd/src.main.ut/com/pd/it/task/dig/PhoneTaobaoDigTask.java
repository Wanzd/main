package com.pd.it.task.dig;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.pd.it.bigdata.builder.House$fangtianxiaParseBuilder;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.util.F;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.util.XmlUtil;
import com.pd.it.common.vo.VO;

public class PhoneTaobaoDigTask implements ITask
{
    
    @Override
    public void execute()
    {
        // 清除旧数据
        Db.u("phone$taobao.truncate");
        
        // 获取新数据
        VO vo = new VO();
        boolean flag = true;
        List<VO> complanyList = AI.build(new CompanyParseBuilder());
        int curPage = 1;
        while (flag)
        {
            String url = F.str(
                "https://s.taobao.com/search?q=%E6%89%8B%E6%9C%BA&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306&cps=yes&ppath=",
                curPage);
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
    
    private class CompanyParseBuilder implements IBuilder<VO, List<VO>>
    {
        
        @Override
        public List<VO> build(VO in)
        {
            VO vo = new VO();
            String url = F.str(
                "https://s.taobao.com/search?q=%E6%89%8B%E6%9C%BA&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306&cps=yes&ppath=",
                "");
            vo.put("url", url);
            VO rest = NetUtil.jsoup(vo);
            
            String str = rest.str("msg");
            System.out.println(str);
            int startIndex = str.indexOf("<div class=\"el\">");
            int lastIndex = str.lastIndexOf("<div class=\"el\">");
            int endIndex = str.indexOf("</div>", lastIndex);
            str = str.substring(startIndex, endIndex) + "</div>";
            str = str.replaceAll("&", "&amp;").replaceAll("<img .*>", "");
            str = str.replaceAll("<div", "@@<div");
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
                    List<Element> list = XmlUtil.readStr(eachStr, "//div");
                    for (Element eachElement : list)
                    {
                        // rsList.add(element2VO(eachElement));
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            
            return rsList;
        }
        
    }
    
}
