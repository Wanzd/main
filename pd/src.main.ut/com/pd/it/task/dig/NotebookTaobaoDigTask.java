package com.pd.it.task.dig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.itf.ITask;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.util.Find;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.util.X;
import com.pd.it.common.util.XmlUtil;
import com.pd.it.common.vo.VO;

public class NotebookTaobaoDigTask implements ITask
{
    
    @Override
    public void execute()
    {
        // 清除旧数据
        Db.u("notebook$taobao.truncate");
        
        // 获取新数据
        VO vo = new VO();
        boolean flag = true;
        List<VO> companyList = AI.build(new NotebookCompanyParseBuilder());
        
        for (VO companyVO : companyList)
        {
            List<VO> phoneList = AI.build(new NotebookParseBuilder(), companyVO);
            Db.u("notebook$taobao.us", new VO("list", phoneList));
            Db.u("log.us", new VO("list", phoneList));
        }
    }
    
    private class NotebookCompanyParseBuilder implements IBuilder<VO, List<VO>>
    {
        
        @Override
        public List<VO> build(VO in)
        {
            VO vo = new VO();
            String url =
                "https://s.taobao.com/search?spm=a230r.1.0.0.76587985CRPDiK&q=笔记本&app=vproduct&vlist=1&from_combo=true&cps=yes&ppath=";
            vo.put("url", url);
            VO rest = NetUtil.jsoup(vo);
            
            String str = rest.str("msg");
            int startIndex = str.indexOf("g_page_config =");
            int endIndex = str.indexOf("g_srp_loadCss");
            str = str.substring(startIndex + 15, endIndex);
            str = str.substring(0, str.lastIndexOf(";")).trim();
            JSONObject parseObject = JSON.parseObject(str);
            Map map = parseObject;
            VO jsonVO = new VO(map);
            List<VO> rsList = Find.vo$list(jsonVO, "mods/nav/data/[common[@text=品牌]/[sub");
            
            return rsList;
        }
        
    }
    
    private class NotebookParseBuilder implements IBuilder<VO, List<VO>>
    {
        
        @Override
        public List<VO> build(VO in)
        {
            String companyName = in.str("text");
            String value = in.str("value");
            String url =
                "https://s.taobao.com/search?spm=a230r.1.0.0.76587985CRPDiK&q=笔记本&app=vproduct&vlist=1&from_combo=true&cps=yes&ppath="
                    + value;
            VO rest = NetUtil.jsoup(new VO("url", url));
            String msg = rest.str("msg");
            msg = Find.str$between(msg, "g_page_config =", "g_srp_loadCss");
            msg = Find.str$trim(msg, ";");
            msg = msg.substring(0, msg.length() - 1);
            
            VO jsonVO = new VO(JSON.parseObject(msg));
            List<VO> vo$list = Find.vo$list(jsonVO, "mods/grid/data/[spus");
            for (VO eachVO : vo$list)
            {
                eachVO.put("company", companyName);
                eachVO.put("sellNum", Find.vo$num(eachVO, "seller/num"));
                eachVO.put("price", Find.vo$num(eachVO, "price"));
                eachVO.put("month_sales", Find.vo$num(eachVO, "month_sales"));
            }
            return vo$list;
        }
        
    }
}
