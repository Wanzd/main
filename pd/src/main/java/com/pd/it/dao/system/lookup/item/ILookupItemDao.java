package com.pd.it.dao.system.lookup.item;

import org.springframework.stereotype.Repository;

import com.pd.it.common.itf.IDao;
import com.pd.it.model.system.lookup.item.LookupItemDto;
import com.pd.it.model.system.lookup.item.LookupItemFO;
import com.pd.it.model.system.lookup.item.LookupItemVO;

@Repository
public interface ILookupItemDao extends IDao<LookupItemVO, LookupItemFO, LookupItemDto> {

}