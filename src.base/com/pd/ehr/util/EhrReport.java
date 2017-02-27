package com.pd.ehr.util;

import com.pd.base.EhrApi.Builder.IBuilder;
import com.pd.ehr.util.EhrReport.Dto.EhrReportVo;

public class EhrReport
{
    
    public static enum ReportChannel implements IBuilder<Object, Dto.EhrReportVo>
    {
        DailyCommon(){
            
        };
        public EhrReportVo build(Object _in)
        {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
    public static class Dto
    {
        public static class EhrReportVo
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
            
            public EhrReportVo(String name, String rule, String xml, String xsl)
            {
                this.name = name;
                this.rule = rule;
                this.xml = xml;
                this.xsl = xsl;
            }
        }
    }
}
