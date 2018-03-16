//package com.pd.it.i18n;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.alibaba.fastjson.JSON;
//import com.pd.it.common.abs.AbsDbService;
//import com.pd.it.common.util.AI;
//import com.pd.it.common.vo.PageList;
//import com.pd.it.common.vo.PageVO;
//import com.pd.it.common.vo.RsVO;
//import com.pd.it.common.vo.RsVO.Status;
//
//@RestController
//@RequestMapping("/i18")
//public class I18Service extends AbsDbService<I18nVO, I18nVO, I18nFO, II18nDao>
//{
//    @Autowired
//    private II18nDao dao;
//    
//    @Override
//    public II18nDao getDao()
//    {
//        return dao;
//    }
//    
////    @ResponseBody
////    @RequestMapping(value = "/r", method = {RequestMethod.GET})
////    public I18nVO r(@ModelAttribute("fo") I18nFO fo)
////    {
////        I18nVO userVO = dao.r(fo);
////        return userVO;
////    }
////    
////    @ResponseBody
////    @RequestMapping(value = "/c", method = {RequestMethod.POST})
////    public String c(@ModelAttribute("fo") I18nFO fo)
////    {
////        int rs = dao.c(fo);
////        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
////    }
////    
////    @ResponseBody
////    @RequestMapping(value = "/d", method = {RequestMethod.POST})
////    public String d(@ModelAttribute("fo") I18nFO fo)
////    {
////        int rs = dao.d(fo);
////        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
////    }
////    
////    @ResponseBody
////    @RequestMapping(value = "/u", method = {RequestMethod.POST})
////    public String u(@ModelAttribute("fo") I18nFO fo)
////    {
////        int rs = dao.u(fo);
////        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
////    }
////    
////    @ResponseBody
////    @RequestMapping(value = "/p", method = {RequestMethod.GET,
////        RequestMethod.POST}, produces = "text/html;charset=utf-8")
////    public String p(@ModelAttribute("fo") I18nFO fo, @ModelAttribute("page") PageVO page)
////    {
////        int pCount = dao.pCount(fo, page);
////        AI.u(page, "totalCount", pCount);
////        PageList<I18nVO> rsList = dao.p(fo, page);
////        rsList.setPage(page);
////        return JSON.toJSONString(rsList);
////    }
//    
//}
