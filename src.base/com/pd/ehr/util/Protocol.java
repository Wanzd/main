package com.pd.ehr.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.pd.ehr.util.Protocol.Http.Dto.Fo;

import junit.framework.TestCase;

public class Protocol
{
    public static class Http
    {
        public static enum Type
        {
            GET, POST
        }
        
        public static class Service
        {
            
            public String get(Fo fo)
            {
                return new Action.HttpAction().http(Type.GET, fo);
            }
            
        }
        
        public static class Action
        {
            public static class HttpAction
            {
                public String http(Type type, Fo fo)
                {
                    BufferedReader reader = null;
                    String result = null;
                    StringBuffer sbf = new StringBuffer();
                    try
                    {
                        URL url = new URL(fo.getLocation());
                        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                        connection.setRequestMethod(type.toString());
                        // 填入apikey到HTTP header
                        connection.setRequestProperty("apikey", "2cd25a5a08f30e66adc572c98b574cbc");
                        connection.connect();
                        InputStream is = connection.getInputStream();
                        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        String strRead = null;
                        while ((strRead = reader.readLine()) != null)
                        {
                            sbf.append(strRead);
                            sbf.append("\r\n");
                        }
                        reader.close();
                        result = sbf.toString();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    return result;
                }
            }
        }
        
        public static class Dto
        {
            public static class Vo
            {
                private String url;
                
                private String arg;
                
                public String getUrl()
                {
                    return url;
                }
                
                public void setUrl(String url)
                {
                    this.url = url;
                }
                
                public String getArg()
                {
                    return arg;
                }
                
                public void setArg(String arg)
                {
                    this.arg = arg;
                }
                
                public String getLocation()
                {
                    return EhrString.Valid.IsNullOrBlank.valid(arg) ? url : url + "?" + arg;
                }
                
            }
            
            public static class Fo extends Vo
            {
                
            }
        }
        
        public static class Test extends TestCase
        {
            public void testHttpGet()
                throws UnsupportedEncodingException
            {
                Http.Dto.Fo fo = new Fo();
                fo.setUrl("http://api.map.baidu.com/telematics/v3/weather?location=" + URLEncoder.encode("武汉", "utf-8") + "&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ");
                String resultStr = new Http.Service().get(fo);
                Show.ln(resultStr);
            }
        }
    }
    
}
