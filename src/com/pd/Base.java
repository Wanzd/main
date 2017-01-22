package com.pd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pd.Base.EhrBaseModule.IDao;
import com.pd.Base.EhrBaseModule.IDatabaseService;
import com.pd.ehr.EhrTestCase;

public class Base
{
    public static class PageList<T>
    {
        private List<T> list;
        
        private PageVO pageV;
        
        public List<T> getList()
        {
            return list;
        }
        
        public void setList(List<T> list)
        {
            this.list = list;
        }
        
        public PageVO getPageV()
        {
            return pageV;
        }
        
        public void setPageV(PageVO pageV)
        {
            this.pageV = pageV;
        }
        
    }
    
    public static class Dto
    {
        private Map<String, String> map = new HashMap<String, String>();
        
        public String r(String key)
        {
            return map.get(key);
        }
        
        public Dto u(String key, String value)
        {
            map.put(key, value);
            return this;
        }
    }
    
    public static class EhrBaseVO
    {
        protected Dto dto;
    }
    
    public static interface IEhrFilterVO
    {
        
    }
    
    public static class EhrDataBaseVO extends EhrBaseVO
    {
        protected Long idxId, flowId;
        
        protected Long code;
        
        protected String name, number, key, value;
        
        protected String createrId, createTime, lastModifyTime, lastModifyId;
        
        public Long getIdxId()
        {
            return idxId;
        }
        
        public void setIdxId(Long idxId)
        {
            this.idxId = idxId;
        }
        
        public Long getFlowId()
        {
            return flowId;
        }
        
        public void setFlowId(Long flowId)
        {
            this.flowId = flowId;
        }
        
        public String getCreaterId()
        {
            return createrId;
        }
        
        public void setCreaterId(String createrId)
        {
            this.createrId = createrId;
        }
        
        public String getCreateTime()
        {
            return createTime;
        }
        
        public void setCreateTime(String createTime)
        {
            this.createTime = createTime;
        }
        
        public String getLastModifyTime()
        {
            return lastModifyTime;
        }
        
        public void setLastModifyTime(String lastModifyTime)
        {
            this.lastModifyTime = lastModifyTime;
        }
        
        public String getLastModifyId()
        {
            return lastModifyId;
        }
        
        public void setLastModifyId(String lastModifyId)
        {
            this.lastModifyId = lastModifyId;
        }
        
        public String getName()
        {
            return name;
        }
        
        public EhrDataBaseVO setName(String name)
        {
            this.name = name;
            return this;
        }
        
        public String getNumber()
        {
            return number;
        }
        
        public void setNumber(String number)
        {
            this.number = number;
        }
        
        public String getKey()
        {
            return key;
        }
        
        public void setKey(String key)
        {
            this.key = key;
        }
        
        public String getValue()
        {
            return value;
        }
        
        public void setValue(String value)
        {
            this.value = value;
        }
    }
    
    public static class AreaVO<_VO>
    {
        private _VO start;
        
        private _VO end;
        
        public _VO getStart()
        {
            return start;
        }
        
        public void setStart(_VO start)
        {
            this.start = start;
        }
        
        public _VO getEnd()
        {
            return end;
        }
        
        public void setEnd(_VO end)
        {
            this.end = end;
        }
    }
    
    public static class BatchVO<_VO extends EhrDataBaseVO>
    {
        private List<_VO> addList;
        
        private List<_VO> updateList;
        
        private List<_VO> delList;
        
        public List<_VO> getAddList()
        {
            return addList;
        }
        
        public void setAddList(List<_VO> addList)
        {
            this.addList = addList;
        }
        
        public List<_VO> getUpdateList()
        {
            return updateList;
        }
        
        public void setUpdateList(List<_VO> updateList)
        {
            this.updateList = updateList;
        }
        
        public List<_VO> getDelList()
        {
            return delList;
        }
        
        public void setDelList(List<_VO> delList)
        {
            this.delList = delList;
        }
    }
    
    public static class PageVO
    {
        private int totalCount;
        
        private int pageSize;
        
        private int pageCount;
        
        private int curPage;
        
        private int startIdx;
        
        private int endIdx;
        
        public int getStartIdx()
        {
            return startIdx;
        }
        
        public void setStartIdx(int startIdx)
        {
            this.startIdx = startIdx;
        }
        
        public int getEndIdx()
        {
            return endIdx;
        }
        
        public void setEndIdx(int endIdx)
        {
            this.endIdx = endIdx;
        }
        
        public int getTotalCount()
        {
            return totalCount;
        }
        
        public void setTotalCount(int totalCount)
        {
            this.totalCount = totalCount;
        }
        
        public int getPageCount()
        {
            return pageCount;
        }
        
        public void setPageCount(int pageCount)
        {
            this.pageCount = pageCount;
        }
        
        public int getCurPage()
        {
            return curPage;
        }
        
        public void setCurPage(int curPage)
        {
            this.curPage = curPage;
        }
        
        public void setPageSize(int pageSize)
        {
            this.pageSize = pageSize;
        }
        
        public int getPageSize()
        {
            return pageSize;
        }
    }
    
    public static class UpdateVO<_VO>
    {
        private _VO oldV;
        
        private _VO newV;
        
        public _VO getOldV()
        {
            return oldV;
        }
        
        public void setOldV(_VO oldV)
        {
            this.oldV = oldV;
        }
        
        public _VO getNewV()
        {
            return newV;
        }
        
        public void setNewV(_VO newV)
        {
            this.newV = newV;
        }
        
    }
    
    @Deprecated
    public static class EhrBaseModule<_VO extends EhrDataBaseVO, _FO extends IEhrFilterVO, _Dao extends IDao<_VO, _FO>, _Service extends IDatabaseService<_VO, _FO, _Dao>, _Test extends EhrTestCase>
    {
        public static interface IDao<_VO extends EhrDataBaseVO, _FO extends IEhrFilterVO>
        {
            long nextSeq();
            
            _VO r(_FO vo);
            
            int c(_VO vo);
            
            int u(_VO vo);
            
            int d(_VO vo);
            
            PageList<_VO> p(_FO fo);
        }
        
        public interface IValidator<_VO, _FO, _Dao>
        {
            
        }
        
        public interface IDatabaseService<_VO extends EhrDataBaseVO, _FO extends IEhrFilterVO, _Dao extends IDao<_VO, _FO>>
        {
            default _Dao getDao()
            {
                return null;
            };
            
            default _VO r(_FO vo)
            {
                return getDao().r(vo);
            };
            
            default int c(_VO vo)
            {
                return getDao().c(vo);
            };
            
            default int u(_VO vo)
            {
                return getDao().u(vo);
            };
            
            default int d(_VO vo)
            {
                return getDao().d(vo);
            };
            
            default PageList<_VO> p(_FO fo)
            {
                return getDao().p(fo);
            };
        }
        
    }
    
}
