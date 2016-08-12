package com.pd.common.vo;

public class ReportVO
{
    private String name;
    private String rule;
    private String xml;
    private String xsl;
    public String getName()
    {
        return name;
    }
    public String getRule()
    {
        return rule;
    }
    public String getXml()
    {
        return xml;
    }
    public String getXsl()
    {
        return xsl;
    }
    public ReportVO(String name, String rule, String xml, String xsl)
    {
        super();
        this.name = name;
        this.rule = rule;
        this.xml = xml;
        this.xsl = xsl;
    }
}
