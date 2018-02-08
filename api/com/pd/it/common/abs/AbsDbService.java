//package com.pd.it.common.abs;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.alibaba.fastjson.JSON;
//import com.pd.it.common.itf.IDbDao;
//import com.pd.it.common.itf.IDbService;
//import com.pd.it.common.util.AI;
//import com.pd.it.common.vo.PageList;
//import com.pd.it.common.vo.PageVO;
//import com.pd.it.common.vo.RsVO;
//import com.pd.it.common.vo.RsVO.Status;
//
//public abstract class AbsDbService<VO, Dto extends VO, FO extends VO, Dao extends IDbDao<VO>>
//    implements IDbService<VO, Dto, FO>
//{
//    
//    public abstract Dao getDao(VO vo);
//    
//    @Override
//    @ResponseBody
//    @RequestMapping(value = "/c", method = {RequestMethod.POST})
//    public String c(VO vo)
//    {
//        int rs = getDao(vo).c(vo);
//        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
//    }
//    
//    @Override
//    public Dto r(FO fo)
//    {
//        return getDao(fo).r(fo);
//    }
//    
//    @Override
//    @ResponseBody
//    @RequestMapping(value = "/d", method = {RequestMethod.POST})
//    public String d(VO vo)
//    {
//        int rs = getDao(vo).d(vo);
//        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
//    }
//    
//    @Override
//    @ResponseBody
//    @RequestMapping(value = "/u", method = {RequestMethod.POST})
//    public String u(VO vo)
//    {
//        int rs = getDao(vo).u(vo);
//        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
//    }
//    
//    @ResponseBody
//    @RequestMapping(value = "/p", method = {RequestMethod.GET,
//        RequestMethod.POST}, produces = "text/html;charset=utf-8")
//    public String p(@ModelAttribute("fo") FO fo, @ModelAttribute("page") PageVO page)
//    {
//        int pCount = getDao(fo).pCount(fo, page);
//        AI.u(page, "totalCount", pCount);
//        PageList<Dto> rsList = getDao(fo).p(fo, page);
//        rsList.setPage(page);
//        String rsStr = JSON.toJSONString(rsList);
//        return rsStr;
//    }
//    
//    @Override
//    @ResponseBody
//    @RequestMapping(value = "/ra", method = {RequestMethod.GET,
//        RequestMethod.POST}, produces = "text/html;charset=utf-8")
//    public String ra()
//    {
//        List<Dto> rsList = getDao(null).ra();
//        return JSON.toJSONString(rsList);
//    }
//    
//    @Override
//    @ResponseBody
//    @RequestMapping(value = "/rs", method = {RequestMethod.GET,
//        RequestMethod.POST}, produces = "text/html;charset=utf-8")
//    public String rs(FO fo)
//    {
//        List<Dto> rsList = getDao(fo).rs(fo);
//        return JSON.toJSONString(rsList);
//    }
//    
//    @Override
//    public int ds(List<VO> list)
//    {
//        return 0;
//    }
//    
//    @Override
//    public int cs(List<VO> list)
//    {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//    
//    @Override
//    public int us(List<VO> list)
//    {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//}
