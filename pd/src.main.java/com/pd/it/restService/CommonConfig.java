package com.pd.it.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pd.it.common.vo.VO;

@Configuration
public class CommonConfig {

	@Bean(name = "testDemo")
	public VO generateDemo() {
		VO demo = new VO();
		demo.p("a", 11);
		return demo;
	}

}
