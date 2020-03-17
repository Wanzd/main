package com.pd.it.rest.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.base.model.MapVO;
import com.pd.it.common.ListX;
import com.pd.it.rest.api.IQueryRest;
import com.pd.it.system.taskTree.dao.ITaskTreeDao;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("taskTreeRest")
public class TaskTreeRest implements IQueryRest<MapVO, MapVO> {
	@Inject
	private ITaskTreeDao dao;

	@RequestMapping(value = "/DATA:{id}")
	@ResponseBody
	public List<MapVO> queryData(@PathVariable String id) {
		MapVO fo = new MapVO();
		fo.put("id", id);
		List<MapVO> list = dao.queryList(fo);
		list=ListX.treeList(list,"pid","id","startTime");
		return list;
	}
}
