package com.pd.it.db;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.DbUtil;
import com.pd.it.common.util.MailUtil;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.ICommonDao;
import com.pd.it.web.PermissionUtil;
import com.pd.it.web.vo.NoPermissionVO;

@RestController
@RequestMapping("rest")
public class RestService
{
    @Autowired
    private ICommonDao dao;
    
    @Autowired
    private HttpServletRequest request;
    
    @ResponseBody
    @RequestMapping(value = "{module}/{action}", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String r(@PathVariable("") LinkedHashMap<String, String> path,
        @RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        KV pathKV = new KV(path);
        if (!PermissionUtil.check(request, pathKV))
        {
            return JSON.toJSONString(new NoPermissionVO(path));
        }
        String action = pathKV.v("action");
        VO sqlCfg = CommonSqlProvider.cfg(new KV(path), new VO(in));
        switch (action)
        {
            case "r":
                VO rsVO = DbUtil.r(dao, sqlCfg);
                return JSON.toJSONString(rsVO);
            case "ra":
                List<VO> rsList = DbUtil.ra(dao, sqlCfg);
                return JSON.toJSONString(rsList);
        }
        return "";
    }
    
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
    
    @ResponseBody
    @RequestMapping(value = "test", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String test(@RequestBody String jsonStr)
    {
        WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
        VO vo = new VO(jsonStr);
        MailUtil.send("daily", vo);
        return "send success";
    }
    
}
