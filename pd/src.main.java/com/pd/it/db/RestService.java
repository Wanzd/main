package com.pd.it.db;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.util.AI;
import com.pd.it.common.vo.PageList;
import com.pd.it.common.vo.VO;
import com.pd.it.db.dbvo.builder.Map2VO;
import com.pd.web.util.Db;

@RestController
@RequestMapping("rest/{mid}/{dimension}/{action}")
public class RestService
{
    
    @ResponseBody
    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/html;charset=utf-8")
    public String rest(@PathVariable("") LinkedHashMap<String, Object> path,
        @RequestParam LinkedHashMap<String, Object> in)
    {
        return Db.action(new VO(in), new VO(path));
    }
    
    
   
}
