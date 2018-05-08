package com.pd.it.db;

import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.MailUtil;
import com.pd.it.common.vo.VO;

@RestController
@RequestMapping("test")
public class TestService
{
    
    @ResponseBody
    @RequestMapping(value = "test", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String test(LinkedHashMap<String, String> json)
    {
        return "[{a:'1'}]";
    }
    
}
