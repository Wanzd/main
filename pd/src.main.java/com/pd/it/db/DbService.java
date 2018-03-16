package com.pd.it.db;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IBatchService;
import com.pd.it.common.itf.IDbDao;
import com.pd.it.common.itf.IService;
import com.pd.it.common.util.AI;
import com.pd.it.common.vo.BatchList;
import com.pd.it.common.vo.PageList;
import com.pd.it.common.vo.RsVO;
import com.pd.it.common.vo.RsVO.Status;
import com.pd.it.common.vo.VO;
import com.pd.it.db.dbvo.builder.Map2VO;

@RestController
@RequestMapping("/db")
public class DbService implements IService<VO>, IBatchService<VO>
{
    
    private IDbDao getDao(VO vo)
    {
        
        return AI.nvl(DaoUtil.get(vo.get("mid").toString()), null);
    }
    
    private IDbDao getDao(List<VO> list)
    {
        if (list.size() == 0)
        {
            return null;
        }
        return getDao(list.get(0));
    }
    
    @ResponseBody
    @RequestMapping(value = "/c", method = {RequestMethod.POST})
    public String c(@RequestParam Map<String, String> in)
    {
        VO vo = AI.<Map<String, String>, VO> build(in, new Map2VO());
        return c(vo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/r", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "text/html;charset=utf-8")
    public String r(@RequestParam Map<String, String> in)
    {
        VO fo = AI.build(in, new Map2VO());
        IDbDao dao = getDao(fo);
        VO r = dao.r(fo);
        String rsStr = JSON.toJSONString(r);
        return rsStr;
    }
    
    @Override
    public VO r(@RequestParam VO fo)
    {
        return getDao(fo).r(fo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/d", method = {RequestMethod.POST})
    public String d(@RequestParam Map<String, String> in)
    {
        VO vo = AI.build(in, new Map2VO());
        return d(vo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/u", method = {RequestMethod.POST})
    public String u(@RequestParam Map<String, String> in)
    {
        VO vo = AI.build(in, new Map2VO());
        return u(vo);
    }
    
    @Override
    public String c(VO vo)
    {
        int rs = getDao(vo).c(vo);
        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
    }
    
    @Override
    public String u(VO vo)
    {
        int rs = getDao(vo).u(vo);
        return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
    }
    
    @Override
    public String d(VO vo)
    {
        try
        {
            int rs = getDao(vo).d(vo);
            return JSON.toJSONString(new RsVO(Status.SUCCESS, rs + "", null));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return JSON.toJSONString(new RsVO(Status.ERROR, "", null));
    }
    
    @ResponseBody
    @RequestMapping(value = "/p", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "text/html;charset=utf-8")
    public String p(@RequestParam Map<String, String> in)
    {
        in = AI.map(in, "start", 1, "end", 15);
        VO vo = AI.build(in, new Map2VO());
        return p(vo);
    }
    
    @Override
    public String p(VO vo)
    {
        PageList<VO> rsList = getDao(vo).p(vo);
        String rsStr = JSON.toJSONString(rsList);
        return rsStr;
    }
    
    @Override
    public String cs(List<VO> vo)
    {
        String rsStr = getDao(vo).cs(vo) + "";
        return rsStr;
    }
    
    @Override
    public String us(List<VO> vo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String ds(List<VO> vo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String batch(BatchList<VO> vo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String ra()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String rs(VO fo)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}
