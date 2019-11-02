package com.pd.ai.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.ai.dao.IEntitySupposeDao;
import com.pd.it.web.api.ISimpleService;

@Service
public class EntitySupposeService implements ISimpleService {
	@Inject
	private IEntitySupposeDao dao;

}
