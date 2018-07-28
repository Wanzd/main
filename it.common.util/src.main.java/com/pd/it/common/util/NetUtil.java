package com.pd.it.common.util;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.pd.it.common.provider.CommonRestProvider;
import com.pd.it.common.vo.VO;

public class NetUtil
{
    
    public static VO rest(String key)
    {
        VO cfg = CommonRestProvider.cfg(key, new VO());
        return rest(cfg);
    }
    
    public static VO rest(VO vo)
    {
        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(vo.str("url"));
        httpPost.addHeader("Content-type", "application/json;charset=GBK");
        httpPost.addHeader("Accept", "application/json");
        HttpResponse res = null;
        try
        {
            res = httpclient.execute(httpPost);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final int statusCode = res.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK)
        {
            System.out.println("Error authenticating to Force.com: " + statusCode);
            return null;
        }
        
        String getResult = null;
        try
        {
            getResult = EntityUtils.toString(res.getEntity(), Charset.forName("GBK"));
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
        VO rsVO = new VO();
        rsVO.put("msg", getResult);
        return rsVO;
    }
    
    public static VO jsoup(VO vo)
    {
        
        Document document;
        try
        {
            document = Jsoup.connect(vo.str("url")).get();
            Elements select = document.select("dl[class=clearfix]");
            return AI.vo("msg", select.toString());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static void testJsoup()
    {
        
    }
    
    public static void main(String[] args)
    {
        testJsoup();
    }
}
