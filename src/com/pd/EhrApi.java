package com.pd;

import java.util.List;

import com.pd.Base.EhrDataBaseVO;
import com.pd.Base.IEhrFilterVO;
import com.pd.Base.PageList;

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
        
    }
    
    public static class Db
    {
        public static interface IDao<_Vo extends EhrDataBaseVO, _Fo extends IEhrFilterVO>
        {
            long nextSeq();
            
            _Vo r(_Fo vo);
            
            List<_Vo> rs(_Fo vo);
            
            PageList<_Vo> p(_Fo fo);
            
            int c(List<_Vo> list);
            
            int u(List<_Vo> list);
            
            int d(List<_Vo> list);
            
        }
        
        public static interface IDbService<_Vo extends EhrDataBaseVO, _Fo extends IEhrFilterVO, _Dao extends IDao<_Vo, _Fo>>
        {
            
        }
    }
}
