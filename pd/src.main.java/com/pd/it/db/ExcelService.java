package com.pd.it.db;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.DbUtil;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.ICommonDao;

@RestController
@RequestMapping("excel")
public class ExcelService
{
    @Autowired
    private ICommonDao dao;
    
    @Autowired
    private HttpServletRequest request;
    
    @ResponseBody
    @RequestMapping(value = "export/{module}", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String export(@PathVariable("") LinkedHashMap<String, String> path,
        @RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        path.put("action", "export");
        in.put("id", path.get("id"));
        VO sqlCfg = CommonSqlProvider.cfg(new KV(path), new VO(in));
        VO rsVO = DbUtil.r(dao, sqlCfg);
        return JSON.toJSONString(rsVO);
    }
    
    @ResponseBody
    @RequestMapping(value = "import/{module}", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String importExcel(@PathVariable("") LinkedHashMap<String, String> path,
        @RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        path.put("action", "import");
        in.put("id", path.get("id"));
        VO sqlCfg = CommonSqlProvider.cfg(new KV(path), new VO(in));
        VO rsVO = DbUtil.r(dao, sqlCfg);
        return JSON.toJSONString(rsVO);
    }
    
}
