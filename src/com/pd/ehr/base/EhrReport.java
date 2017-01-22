package com.pd.ehr.base;

public class EhrReport
{
    public static class VO
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
        
        public VO(String name, String rule, String xml, String xsl)
        {
            this.name = name;
            this.rule = rule;
            this.xml = xml;
            this.xsl = xsl;
        }
    }
    
    public static class Service
    {
        public static class EhrReportService
        {
            public static String report(VO vo)
            {
                return vo.getXml();
            }
        }
    }
}
