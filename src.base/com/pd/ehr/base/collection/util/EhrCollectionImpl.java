package com.pd.ehr.base.collection.util;

import java.util.Collection;

import com.pd.base.EhrApi.Builder.IValidRule;

class EhrCollectionImpl
{
    public static class Valid
    {
        public static class IsNullOrEmpty implements IValidRule<Collection<?>>
        {
            public boolean valid(Collection<?> obj)
            {
                return null == obj || obj.isEmpty();
            }
            
        }
        
    }
    
}
