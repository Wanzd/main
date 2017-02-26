package com.pd.ehr.base;

import com.pd.EhrApi.Builder.IBuilder;
import com.pd.ehr.base.EhrReport.Dto.EhrReportVo;

public class EhrReport
{
    
    public static enum ReportChannel implements IBuilder<Object, Dto.EhrReportVo>
    {
        DailyCommon();
        @Override
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
