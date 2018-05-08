package com.pd.it.db;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.util.DbUtil;
import com.pd.it.common.vo.KV;
import com.pd.it.common.vo.VO;
import com.pd.it.dao.ICommonDao;

@RestController
@RequestMapping("user")
public class UserService
{
    @Autowired
    private ICommonDao dao;
    
    @Autowired
    private HttpServletRequest request;
    
    @ResponseBody
    @RequestMapping(value = "login", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String login(@RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        HttpSession session = request.getSession();
        
        /** 校验用户合法性 */
        session.setAttribute("user", in.get("user"));
        
        VO sqlCfg = CommonSqlProvider.cfg(new KV().p("module", "permission").p("action", "ra"), new VO(in));
        List<VO> rsList = DbUtil.ra(dao, sqlCfg);
        session.setAttribute("role", in.get("role"));
        Set<String> permission = new HashSet<String>();
        
        for (VO vo : rsList)
        {
            permission.add(vo.str("permission"));
        }
        session.setAttribute("permission", permission);
        Object user = session.getAttribute("user");
        Object role = session.getAttribute("role");
        return user == null ? "null" : user.toString() + ":" + role.toString();
    }
    
    @ResponseBody
    @RequestMapping(value = "logout", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String logout(@RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        Object user = session.getAttribute("user");
        return user == null ? "null" : user.toString();
    }
    
    @ResponseBody
    @RequestMapping(value = "userInfo", method = {RequestMethod.GET,
        RequestMethod.POST}, produces = "application/json;charset=utf-8")
    public String userInfo(@RequestParam LinkedHashMap<String, Object> in, LinkedHashMap<String, String> json)
    {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        Object role = session.getAttribute("role");
        return user == null ? "null" : user.toString() + ":" + role.toString();
    }
}
