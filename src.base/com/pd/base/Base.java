package com.pd.base;

import java.util.Date;
import java.util.List;

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
    
    public static class EhrBaseVO
    {
    }
    
    public static interface IFilterVO
    {
        
    }
    
    public static class EhrDataBaseVO extends EhrBaseVO
    {
        private Long rowNumber, dbFlowId;
        
        private String id, name, value;
        
        private String createId, lastModifyId;
        
        private Date createTime, lastModifyTime;

        public Long getRowNumber()
        {
            return rowNumber;
        }

        public Long getDbFlowId()
        {
            return dbFlowId;
        }

        public String getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public String getValue()
        {
            return value;
        }

        public String getCreateId()
        {
            return createId;
        }

        public String getLastModifyId()
        {
            return lastModifyId;
        }

        public Date getCreateTime()
        {
            return createTime;
        }

        public Date getLastModifyTime()
        {
            return lastModifyTime;
        }

        public void setRowNumber(Long rowNumber)
        {
            this.rowNumber = rowNumber;
        }

        public void setDbFlowId(Long dbFlowId)
        {
            this.dbFlowId = dbFlowId;
        }

        public void setId(String id)
        {
            this.id = id;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        public void setCreateId(String createId)
        {
            this.createId = createId;
        }

        public void setLastModifyId(String lastModifyId)
        {
            this.lastModifyId = lastModifyId;
        }

        public void setCreateTime(Date createTime)
        {
            this.createTime = createTime;
        }

        public void setLastModifyTime(Date lastModifyTime)
        {
            this.lastModifyTime = lastModifyTime;
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
    
}
