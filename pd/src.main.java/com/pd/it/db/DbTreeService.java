package com.pd.it.db;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.pd.it.common.itf.IDbTreeDao;
import com.pd.it.common.itf.ITreeService;
import com.pd.it.common.util.AI;
import com.pd.it.common.vo.VO;
import com.pd.it.db.dbvo.builder.Map2VO;

@RestController
@RequestMapping("/pd/dbTree")
public class DbTreeService implements ITreeService
{
    
    private IDbTreeDao getDao(VO vo)
    {
        
        return TreeDaoUtil.get(vo.get("mid").toString());
    }
    
    @ResponseBody
    @RequestMapping(value = "/root", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "text/html;charset=utf-8")
    public String root(@RequestParam Map<String, String> in)
    {
        VO vo = AI.build(in, new Map2VO());
        return root(vo);
    }
    
    @ResponseBody
    @RequestMapping(value = "/sub", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "text/html;charset=utf-8")
    public String sub(@RequestParam Map<String, String> in)
    {
        
        VO vo = AI.build(in, new Map2VO());
        return sub(vo);
    }
    
    @Override
    public String root(VO vo)
    {
        IDbTreeDao dao = getDao(vo);
        List<VO> rsList = dao.root(vo);
        String rsStr = JSON.toJSONString(rsList);
        return rsStr;
    }
    
    @Override
    public String sub(VO vo)
    {
        List<VO> rsList = getDao(vo).sub(vo);
        String rsStr = JSON.toJSONString(rsList);
        return rsStr;
    }
}
