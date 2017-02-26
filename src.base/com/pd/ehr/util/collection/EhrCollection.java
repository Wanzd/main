package com.pd.ehr.util.collection;

import java.util.Collection;

import com.pd.base.EhrApi.Builder.IValidRule;

public class EhrCollection
{
    public static class ValidBridge<_In extends Collection<?>> implements IValidRule<_In>
    {
        
        private IValidRule<_In> validRule;
        
        public ValidBridge(IValidRule<_In> _validRule)
        {
            validRule = _validRule;
        }
        
        @Override
        public boolean valid(_In _in)
        {
            // TODO Auto-generated method stub
            return validRule.valid(_in);
        }
        
    }
}
