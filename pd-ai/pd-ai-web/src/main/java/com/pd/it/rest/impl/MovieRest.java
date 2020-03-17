package com.pd.it.rest.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pd.base.model.MapVO;
import com.pd.it.business.impl.SariBusiness;
import com.pd.it.common.StringX;
import com.pd.it.movie.business.impl.MovieBusiness;

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/movie")
public class MovieRest {
	@Inject
	private MovieBusiness business;

	@RequestMapping(value = "/parseAll")
	@ResponseBody
	public Object parseAll(@RequestBody(required = false) MapVO fo) {
		business.process(fo);
		return 0;
	}

}
