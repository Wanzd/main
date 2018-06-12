package com.pd.it.bigdata.builder;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import com.pd.it.common.itf.IBuilder;
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
        str = "<xml>" + str.substring(startIndex, endIndex) + "</div></xml>";
        str = str.replaceAll("&", "&amp;").replaceAll("<img .*>", "");
        System.out.println(str);
        List<Element> list = XmlUtil.readStr(str, "//div");
        List<VO> rsList = new ArrayList<VO>();
        for (Element eachElement : list)
        {
            rsList.add(element2VO(eachElement));
        }
        return rsList;
    }
    
    private VO element2VO(Element element)
    {
        VO rsVO = new VO();
//        rsVO.put("jobName", XmlUtil.readStr(element, "p[class=t1 tg1]/span/a/text()"));
        rsVO.put("company", XmlUtil.readStr(element, "span"));
        return rsVO;
    }
}
