package com.pd.ehr.util;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.Base.IFilterVO;
import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.base.EhrApi.Db.IDao;
import com.pd.ehr.util.Ip.Dto.IpFO;
import com.pd.ehr.util.Ip.Dto.IpVo;
import com.pd.ehr.util.Ip.IpBuilder.FromIp138;
import com.pd.ehr.util.Json.JsonUtil;

public class Ip
{
    public static enum IpChannel implements IBuilder<String, IpVo>
    {
        Ip138("ip138", new FromIp138());
        
        private String name;
        
        public String getName()
        {
            return name;
        }

        public IBuilder<String, IpVo> getBuilder()
        {
            return builder;
        }

        private IBuilder<String, IpVo> builder;
        
        private IpChannel(String _name, IBuilder<String, IpVo> _builder)
        {
            name = _name;
            builder = _builder;
        }
        
        @Override
        public IpVo build(String _in)
        {
            return builder.build(_in);
        }
        
        public static IpVo builds(String _in)
        {
            for (IpChannel evenChannel : IpChannel.values())
            {
                IpVo curVo = evenChannel.build(_in);
                if (curVo != null)
                {
                    return curVo;
                }
            }
            return null;
        }
    }
    
    public static class IpUtil
    {
        public static String getCurW3Ip()
        {
            return IpChannel.builds(null).getIp();
        }
    }
    
    public static class IpService
    {
        
    }
    
    public static class Single
    {
        
        private static IpVo singleton = new IpVo();
        
        public static IpVo getSingleton()
        {
            return singleton;
        }
    }
    
    public static IpVo getCurIp()
    {
        return Single.getSingleton();
    }
    
    public static class IpBuilder
    {
        public static class FromIp138 implements IBuilder<String, IpVo>
        {
            
            @Override
            public IpVo build(String _in)
            {
                Json.Dto.Fo fo = new Json.Dto.Fo().setUrl("http://1212.ip138.com/ic.asp");
                String json = JsonUtil.html(fo);
                int startIndex = json.indexOf("[");
                int endIndex = json.indexOf("]");
                String ip = json.substring(startIndex + 1, endIndex);
                return new IpVo().setIp(ip);
            }
            
        }
        
    }
    
    public static class Dto
    {
        public static class IpVo extends EhrDataBaseVO
        {
            private String ip;
            
            private IpVo()
            {
                
            }
            
            public String getIp()
            {
                return ip;
            }
            
            public IpVo setIp(String ip)
            {
                this.ip = ip;
                return this;
            }
            
        }
        
        public static class IpFO extends IpVo implements IFilterVO
        {
            
        }
    }
    
    public static interface Dao extends IDao<IpVo, IpFO>
    {
        
    }
    
    public static class Test extends EhrTestCase
    {
        public void testGetSelfPublicIp()
        {
            String curW3Ip = IpUtil.getCurW3Ip();
            Show.ln(curW3Ip);
        }
    }
}
