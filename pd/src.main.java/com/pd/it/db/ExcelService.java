package com.pd.it.db;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.AI;
import com.pd.it.common.vo.VO;
import com.pd.it.db.dbvo.builder.Map2VO;

@RestController
@RequestMapping("/excel")
public class ExcelService
{
    @Autowired
    private RestService dbService;
    
    @ResponseBody
    @RequestMapping(value = "/import", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "text/html;charset=utf-8")
    public String in(@RequestParam List<VO> list)
    {
        // return dbService.us(list);
        return null;
    }
    
    @ResponseBody
    @RequestMapping(value = "/export", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "text/html;charset=utf-8")
    public String out(@RequestParam Map<String, String> in)
    {
        
        VO vo = AI.build(in, new Map2VO());
        // return dbService.p(vo);
        return null;
    }
}
