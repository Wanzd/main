package com.pd.it.db;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.Db;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;
import com.pd.it.web.PermissionUtil;
import com.pd.it.web.vo.NoPermissionVO;

@RestController
@RequestMapping("")
public class RestService
{
    @Autowired
    private HttpServletRequest request;
    
    @ResponseBody
    @RequestMapping(value = "rest/{action}_{module}", method = {RequestMethod.GET,
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
        String key = path.get("module") + "." + path.get("action");
        switch (action)
        {
            case "r":
                VO rsVO = Db.r(key, new VO(in));
                return JSON.toJSONString(rsVO);
            case "ra":
            case "querys":
                List<VO> rsList = Db.ra(key, new VO(in));
                return JSON.toJSONString(rsList);
            case "str":
                String jsonData = Db.str(key, new VO(in));
                return jsonData;
            case "strs":
                List<String> jsonDatas = Db.strs(key, new VO(in));
                return JSON.toJSONString(jsonDatas);
            case "u":
            case "us":
            case "ds":
                VO vo = new VO(in);
                String object = vo.str("list");
                object = object.replaceAll("'", "''");
                List<VO> list = VO.list$str(object);
                int rs = Db.u(key, new VO("list", list));
                
                return JSON.toJSONString(ResultVO.success(null));
        }
        return "{}";
    }
    
    @ResponseBody
    @RequestMapping(value = "export/{module}", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String export(@PathVariable("") LinkedHashMap<String, String> path,
        @RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        path.put("action", "export");
        in.put("id", path.get("id"));
        VO rsVO = Db.r(path.get("module") + path.get("action"), new VO(in));
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
        VO rsVO = Db.r(path.get("module") + path.get("action"), new VO(in));
        return JSON.toJSONString(rsVO);
    }
}
