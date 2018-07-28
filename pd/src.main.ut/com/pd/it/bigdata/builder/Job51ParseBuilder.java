package com.pd.it.bigdata.builder;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.util.XmlUtil;
import com.pd.it.common.vo.VO;

public class Job51ParseBuilder implements IBuilder<VO, List<VO>>
{
    static String xPath = "//div:class[e1]";
    
    @Override
    public List<VO> build(VO in)
    {
        String str = in.str("msg");
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
                    rsList.add(element2VO(eachElement));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        return rsList;
    }
    
    private VO element2VO(Element element)
    {
        VO rsVO = new VO();
        // rsVO.put("jobName", XmlUtil.readStr(element, "p[class=t1 tg1]/span/a/text()"));
        rsVO.put("job", XmlUtil.readStr(element, "p[contains(@class,'t1')]/span/a/text()"));
        rsVO.put("company", XmlUtil.readStr(element, "span[contains(@class,'t2')]/a/text()"));
        rsVO.put("location", XmlUtil.readStr(element, "span[contains(@class,'t3')]/text()"));
        rsVO.put("url", XmlUtil.readStr(element, "p/span/a/@href"));
        String detail = AI.build(new JobDetailBuilder(), rsVO);
        rsVO.put("detail", detail);
        String salaryStr = XmlUtil.readStr(element, "span[contains(@class,'t4')]/text()");
        VO salaryVO = AI.build(new SalaryVOBuilder(), salaryStr);
        rsVO.put("salary", salaryStr);
        rsVO.put("salaryStart", salaryVO.num("salaryStart"));
        rsVO.put("salaryEnd", salaryVO.num("salaryEnd"));
        rsVO.put("createDate", XmlUtil.readStr(element, "span[contains(@class,'t5')]/text()"));
        return rsVO;
    }
}
