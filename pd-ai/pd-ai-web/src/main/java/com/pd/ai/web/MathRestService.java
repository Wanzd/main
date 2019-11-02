package com.pd.ai.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.web.api.ISimpleRest;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/mathRest")
public class MathRestService implements ISimpleRest {
}
