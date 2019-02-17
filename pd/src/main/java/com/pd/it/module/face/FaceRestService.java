package com.pd.it.module.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pd.it.common.itf.IRestService;

/**
 * 人脸识别Rest服务
 * 
 *
 */
@RequestMapping("/faceRest")
public class FaceRestService implements IRestService<FaceService> {
	@Autowired
	private FaceService service;

}
