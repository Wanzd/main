package com.pd.ehr.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.Base.IFilterVO;
import com.pd.base.EhrApi.Db.IDao;
import com.pd.base.EhrApi.Db.IDbService;
import com.pd.ehr.util.Json.Dto.Fo;
import com.pd.ehr.util.Json.Dto.Vo;

import net.sf.json.JSONObject;

public class Json 
{
    public static class JsonUtil
    {
        public static String html(Fo fo)
        {
            return JsonHelper.jsonStr(fo);
        }
        
        public static JSONObject json(Fo fo)
        {
            String jsonStr = JsonHelper.jsonStr(fo);
            return JSONObject.fromString(jsonStr);
        }
    }
    
    public static class JsonHelper
    {
        private static String jsonStr(Fo fo)
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
        
        public static class WebService
        {
            
        }
        
        public static class DbService implements IDbService<Vo, Fo, Dao>
        {
            
        }
    }
    
    public static class Dto
    {
        public static class Vo extends EhrDataBaseVO
        {
            protected String title;
            
            protected EhrObject author;
        }
        
        public static class Fo extends Vo implements IFilterVO
        {
            private String url;
            
            public String getUrl()
            {
                return url;
            }
            
            public Fo setUrl(String url)
            {
                this.url = url;
                return this;
            }
        }
    }
    
    public static interface Dao extends IDao<Vo, Fo>
    {
        
    }
    
    public static class Action
    {
        public static class ListNewsAction
        {
            public List<Vo> list(Fo fo)
            {
                return null;
            }
        }
    }
    
    public static class Test extends EhrTestCase
    {
        
    }
}
