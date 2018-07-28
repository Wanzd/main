package com.pd.it.common.util;

import java.io.StringReader;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultText;

public class XmlUtil
{
    
    public static Document readStr(String str)
    {
        StringReader strReader = new StringReader(str);
        SAXReader reader = new SAXReader();
        Document doc;
        try
        {
            doc = reader.read(strReader);
            return doc;
        }
        catch (DocumentException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Element> readStr(String str, String xpath)
    {
        Document doc = readStr(str);
        XPath x = doc.createXPath(xpath);
        List<Element> selectNodes = x.selectNodes(doc);
        return selectNodes;
    }
    
    public static List<Element> readsStr(Element element, String xpath)
    {
        XPath x = element.createXPath(xpath);
        List<Element> selectNodes = x.selectNodes(element);
        return selectNodes;
    }
    
    public static String readStr(Element element, String xpath)
    {
        XPath x = element.createXPath(xpath);
        List<Object> selectNodes = x.selectNodes(element);
        if (selectNodes.size() > 0)
        {
            Object curElement = selectNodes.get(0);
            if (curElement instanceof DefaultText)
            {
                return ((DefaultText)curElement).getText().trim();
            }
            if (curElement instanceof Attribute)
            {
                return ((Attribute)curElement).getText().trim();
            }
            
        }
        return "";
    }
    
}
