package com.pd.ehr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.EhrApi.Db.IDao;
import com.pd.EhrApi.Db.IDbService;
import com.pd.ehr.EhrStructure.DbAtom;
import com.pd.ehr.Json.Dao;
import com.pd.ehr.Json.Dto.FO;
import com.pd.ehr.Json.Dto.VO;
import com.pd.ehr.Json.Service.DbService;

public class Json extends DbAtom<VO, FO, Dao,  DbService>
{
    public static class Service
    {
        public static class WebService
        {
            public String json(FO fo)
            {
                StringBuffer strBuf = new StringBuffer();
                
                try
                {
                    URL url = new URL(fo.url);
                    URLConnection conn = url.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));// 转码。
                    String line = null;
                    while ((line = reader.readLine()) != null)
                        strBuf.append(line + " ");
                    reader.close();
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                
                return strBuf.toString();
            }
        }
        
        public static class DbService implements IDbService<VO, FO, Dao>
        {
            
        }
    }
    
    public static class Dto
    {
        public static class VO extends EhrDataBaseVO
        {
            protected String title;
            
            protected EhrObject author;
        }
        
        public static class FO extends VO implements IEhrFilterVO
        {
            private String url;

            public String getUrl()
            {
                return url;
            }

            public void setUrl(String url)
            {
                this.url = url;
            }
        }
    }
    
    public static interface Dao extends IDao<VO, FO>
    {
        
    }
    
    
    public static class Action
    {
        public static class ListNewsAction
        {
            public List<VO> list(FO fo)
            {
                return null;
            }
        }
    }
    
    public static class Test extends EhrTestCase
    {
        
    }
}
