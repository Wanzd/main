package com.pd.it.rest.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.rest.api.ICustomsQueryRest;

/**
 * 系统API案例REST
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/demoRest")
public class DemoRest implements ICustomsQueryRest<String, String> {

}
