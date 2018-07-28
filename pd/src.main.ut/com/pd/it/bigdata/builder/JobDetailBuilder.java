package com.pd.it.bigdata.builder;

import java.util.List;

import org.dom4j.Element;

import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.util.XmlUtil;
import com.pd.it.common.vo.VO;

public class JobDetailBuilder implements IBuilder<VO, String>
{
    
    @Override
    public String build(VO in)
    {
        VO htmlStr = NetUtil.rest(in);
        String mainStr = htmlStr.str("msg");
        int startIndex = mainStr.indexOf("<div class=\"bmsg job_msg inbox\">");
        int endIndex = mainStr.indexOf("<div class=\"tBorderTop_box\">\r\n" + "", startIndex);
        mainStr = mainStr.substring(startIndex, endIndex);
        mainStr = mainStr.replaceAll("<br>", "").replaceAll("&", "&amp;").replaceAll("<img .*>", "");
        List<Element> list = XmlUtil.readStr(mainStr, "//div/*");
        StringBuffer sBuffer = new StringBuffer();
        for (Element eachElement : list)
        {
            sBuffer.append(element2VO(eachElement) + "\n");
        }
        return sBuffer.toString().trim();
    }
    
    private String element2VO(Element element)
    {
        return XmlUtil.readStr(element, "text()");
    }
    
    public static void main(String[] args)
    {
        VO vo = new VO();
        vo.put("url", "https://jobs.51job.com/wuhan/102909708.html?s=01&t=0");
        String rsStr = new JobDetailBuilder().build(vo);
        System.out.println(rsStr);
    }
}
