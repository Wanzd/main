package com.pd.ehr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.pd.EhrApi.Builder.IBuilder;
import com.pd.ehr.EhrCollection.Valid.NotEmpty;

public class EhrCollection
{
    
    public static class Builder
    {
        public static class ByArray<_In> implements IBuilder<_In[], List<_In>>
        {
            
            @Override
            public List<_In> build(_In[] _in)
            {
                List<_In> resultSet = new ArrayList<_In>();
                if (NotEmpty.valid(_in))
                {
                    for (_In evenIn : _in)
                    {
                        resultSet.add(evenIn);
                    }
                }
                return resultSet;
            }
            
        }
    }
    
    public static class Valid
    {
        public static class IsNullOrEmpty
        {
            public static boolean valid(Collection<?> obj)
            {
                return null == obj || obj.isEmpty();
            }
            
            public static boolean valid(Object[] arr)
            {
                return null == arr || 0 == arr.length;
            }
        }
        
        public static class NotEmpty
        {
            public static boolean valid(Collection<?> obj)
            {
                return !IsNullOrEmpty.valid(obj);
            }
            
            public static boolean valid(Object[] arr)
            {
                return !IsNullOrEmpty.valid(arr);
            }
        }
    }
    
}
