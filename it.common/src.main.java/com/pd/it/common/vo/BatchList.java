package com.pd.it.common.vo;

import java.util.List;

public class BatchList<Vo>
{
    private List<Vo> createList;
    
    private List<Vo> updateList;
    
    private List<Vo> deleteList;

	public List<Vo> getCreateList() {
		return createList;
	}

	public void setCreateList(List<Vo> createList) {
		this.createList = createList;
	}

	public List<Vo> getUpdateList() {
		return updateList;
	}

	public void setUpdateList(List<Vo> updateList) {
		this.updateList = updateList;
	}

	public List<Vo> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<Vo> deleteList) {
		this.deleteList = deleteList;
	}
    
}
