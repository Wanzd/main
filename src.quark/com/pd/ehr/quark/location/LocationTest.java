package com.pd.ehr.quark.location;

import com.pd.ehr.quark.location.util.LocationUtil;
import com.pd.ehr.quark.location.vo.LocationVo;
import com.pd.ehr.util.EhrTestCase;
import com.pd.ehr.util.Show;

public class LocationTest extends EhrTestCase
{
    public void testGetCurLocation()
    {
        LocationVo curLocation = LocationUtil.getCurLocation();
        Show.ln(curLocation);
    }
}
