package com.pd.it.service.system.textarea;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pd.it.dao.system.textarea.TextareaDao;
import com.pd.it.web.itf.service.IService;

@Service
public class TextareaService implements IService {

	@Inject
	private TextareaDao dao;

}
