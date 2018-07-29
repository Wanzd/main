package com.pd.it.db;

import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.AI;
import com.pd.it.task.dig.HouseFangtianxiaDigTask;
import com.pd.it.task.dig.PhoneTaobaoDigTask;
import com.pd.it.task.heat.HouseLocationHeatTask;
import com.pd.it.task.heat.JobSkillHeatTask;

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
    
    @ResponseBody
    @RequestMapping(value = "51job", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String job$51(LinkedHashMap<String, String> json)
    {
        // AI.execute(new Job51Task());
        AI.execute(new JobSkillHeatTask());
        return "[{result:'success'}]";
    }
    
    @ResponseBody
    @RequestMapping(value = "house$fangtianxia", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String house$anjuke(LinkedHashMap<String, String> json)
    {
        AI.execute(new HouseFangtianxiaDigTask());
        return "[{result:'success'}]";
    }
    
    @ResponseBody
    @RequestMapping(value = "house$heat", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String house$heat(LinkedHashMap<String, String> json)
    {
        AI.execute(new HouseLocationHeatTask());
        return "[{result:'success'}]";
    }
    
    @ResponseBody
    @RequestMapping(value = "phone$taobao", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String phone$taobao(LinkedHashMap<String, String> json)
    {
        AI.execute(new PhoneTaobaoDigTask());
        return "[{result:'success'}]";
    }
}
