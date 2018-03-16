//package com.pd.it.lookup;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSON;
//import com.pd.it.common.util.AI;
//import com.pd.it.common.vo.PageList;
//import com.pd.it.common.vo.PageVO;
//import com.pd.it.common.vo.RsVO;
//import com.pd.it.common.vo.RsVO.Status;
//
//@RestController
//@RequestMapping("/lookup")
//public class LookupService
//{
//    
//    @Autowired
//    private ILookupDao dao;
//    
//    @ResponseBody
//    @RequestMapping(value = "/c", method = {RequestMethod.POST})
//    public String c(@ModelAttribute("vo") LookupVO fo)
//    {
//        int rs = dao.c(fo);
//        RsVO rsVO = new RsVO(Status.SUCCESS, rs + "", null);
//        return JSON.toJSONString(rsVO);
//    }
//    
//    @ResponseBody
//    @RequestMapping(value = "/d", method = {RequestMethod.POST})
//    public String d(@ModelAttribute("vo") LookupFO fo)
//    {
//        int rs = dao.d(fo);
//        RsVO rsVO = new RsVO(Status.SUCCESS, rs + "", null);
//        return JSON.toJSONString(rsVO);
//    }
//    
//    @ResponseBody
//    @RequestMapping(value = "/u", method = {RequestMethod.POST})
//    public String u(@ModelAttribute("fo") LookupVO vo)
//    {
//        int rs = dao.u(vo);
//        RsVO rsVO = new RsVO(Status.SUCCESS, rs + "", null);
//        return JSON.toJSONString(rsVO);
//    }
//    
//    @ResponseBody
//    @RequestMapping(value = "/p", method = {RequestMethod.GET,
//        RequestMethod.POST}, produces = "text/html;charset=utf-8")
//    public String p(@ModelAttribute("fo") LookupFO fo, @ModelAttribute("page") PageVO page)
//    {
//        int pCount = dao.pCount(fo, page);
//        AI.u(page, "totalCount", pCount);
//        PageList<LookupDto> rsList = dao.p(fo, page);
//        rsList.setPage(page);
//        return JSON.toJSONString(rsList);
//    }
//    
//}
