package com.pd.it.db;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.DbUtil;
import com.pd.it.common.util.MailUtil;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.MailVO;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.ICommonDao;

@RestController
@RequestMapping("timerTask")
public class TimerTaskService
{
    
    @ResponseBody
    @RequestMapping(value = "{id}", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String ra(@PathVariable("") LinkedHashMap<String, String> path,
        @RequestParam LinkedHashMap<String, Object> in)
    {
        String content = String.format("Mission [%s] started", path.get("id"));
        MailVO mailVO = new MailVO();
        mailVO.setTitle("test");
        mailVO.setContent(content);
        mailVO.setFrom("panda_zdwan@hotmail.com");
        mailVO.setTo("panda_zdwan@hotmail.com");
        MailUtil.send(mailVO);
        return content;
    }
    
}
