package com.pd.it.module.face;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.it.common.itf.IService;

@Service
public class FaceService implements IService<IFaceDao> {
	@Autowired
	protected IFaceDao dao;

}
