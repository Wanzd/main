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

public class House$fangtianxiaParseBuilder implements IBuilder<VO, List<VO>>
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
                List<Element> list = XmlUtil.readStr(eachStr, "//dl");
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
        rsVO.put("location", XmlUtil.readStr(element, "dd/p[contains(@class,'add_shop')]/span/text()"));
        String p1 = XmlUtil.readStr(element, "dd/p[contains(@class,'tel_shop')]/text()");
        String[] split = p1.split("\\|");
        rsVO.put("design", split[0].trim());
        rsVO.put("area", AI.num(split[1].trim()));
        rsVO.put("floor", split[2].substring(0, split[2].indexOf("层")));
        rsVO.put("floors", split[2].substring(split[2].indexOf("共") + 1, split[2].lastIndexOf("层")));
        rsVO.put("buildYear", split[4].substring(0, 4));
        rsVO.put("cost", AI.num(XmlUtil.readStr(element, "dd[contains(@class,'price_right')]/span/b/text()")));
        rsVO.put("detail", XmlUtil.readStr(element, "dd/h4/a/span/text()"));
        return rsVO;
    }
}
