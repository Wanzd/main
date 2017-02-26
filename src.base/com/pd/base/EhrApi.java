package com.pd.base;

import java.util.List;

import com.pd.base.Base.EhrDataBaseVO;
import com.pd.base.Base.IFilterVO;
import com.pd.base.Base.PageList;

public class EhrApi
{
    
    public static class Agent
    {
        public static interface ISender<_Msg>
        {
            void send(_Msg _msg);
        }
        
        public static interface ITask
        {
            void execute(Object _in);
        }
    }
    
    public static class Builder
    {
        public static interface IFactory<_Out>
        {
            _Out build();
        }
        
        public static interface IBuilder<_In, _Out>
        {
            _Out build(_In _in);
        }
        
        public static interface IValidRule<_In>
        {
            boolean valid(_In _in);
        }
    }
    
    public static class Db
    {
        public static interface IDao<_Vo extends EhrDataBaseVO, _Fo extends IFilterVO>
        {
            long nextSeq();
            
            _Vo r(_Fo vo);
            
            List<_Vo> rs(_Fo vo);
            
            PageList<_Vo> p(_Fo fo);
            
            int c(List<_Vo> list);
            
            int u(List<_Vo> list);
            
            int d(List<_Vo> list);
            
        }
        
        public static interface IDbService<_Vo extends EhrDataBaseVO, _Fo extends IFilterVO, _Dao extends IDao<_Vo, _Fo>>
        {
            
        }
    }
}
