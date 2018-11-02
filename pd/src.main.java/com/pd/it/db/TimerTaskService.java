//package com.pd.it.db;
//
//import java.util.LinkedHashMap;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.pd.it.common.util.Mail;
//import com.pd.it.common.vo.MailVO;
//
//@RestController
//@RequestMapping("timerTask")
//public class TimerTaskService
//{
//    
//    @ResponseBody
//    @RequestMapping(value = "{id}", method = {RequestMethod.GET,
//        RequestMethod.POST}, produces = "application/json;charset=utf-8")
//    public String ra(@PathVariable("") LinkedHashMap<String, String> path,
//        @RequestParam LinkedHashMap<String, Object> in)
//    {
//        String content = String.format("Mission [%s] started", path.get("id"));
//        MailVO mailVO = new MailVO();
//        mailVO.setTitle("test");
//        mailVO.setContent(content);
//        mailVO.setFrom("panda_zdwan@hotmail.com");
//        mailVO.setTo("panda_zdwan@hotmail.com");
//        Mail.send(mailVO);
//        return content;
//    }
//    
//}
