package com.pd.it.system.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IRestService;
import com.pd.it.service.system.textarea.TextareaService;

/**
 * 富文本rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("system/textarea")
public class SystemTextareaRestService implements IRestService {
	@Inject
	private TextareaService serivce;
}
