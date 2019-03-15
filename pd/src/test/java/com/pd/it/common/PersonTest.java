package com.pd.it.common;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.pd.it.common.vo.FO;
import com.pd.it.test.curInfo.CurInfoService;

public class PersonTest {

	@Autowired
	private CurInfoService service;

	@Before
	public void getBefore() {
		System.out.println("*******************************************test");
		String xmlPath = "WebContent/applicationContext.xml";
		ApplicationContext ac = new FileSystemXmlApplicationContext(xmlPath);
		service = ac.getBean(CurInfoService.class);
	}

	@Test
	public void test$user$c() {
		System.out.println("*******************************************test");
		Object ra = service.ra(new FO());
		System.out.println(ra);
	}

}
