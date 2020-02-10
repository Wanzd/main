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

/**
 * AI系统
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("/sari")
public class SariRest {
	private static final String UPLDAD_PATH = "F:/uploadFile/sari/";
	@Inject
	private SariBusiness business;

	@RequestMapping(value = "/parseAll")
	@ResponseBody
	public Object parseAll(@RequestBody(required = false) MapVO fo) {
		business.process(fo);
		return 0;
	}

	@RequestMapping(value = "/parseToday")
	@ResponseBody
	public Object parseToday(@RequestBody(required = false) MapVO fo) {
		fo.put("creationDate", new Date());
		business.process(fo);
		return 0;
	}

	@RequestMapping(value = "/file")
	@ResponseBody
	public Object file(@RequestParam("file") MultipartFile file) {
		// 获取文件名
		String fileName = file.getOriginalFilename();
		System.out.println("上传的文件名为：" + fileName);

		// 获取文件的后缀名,比如图片的jpeg,png
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("上传的后缀名为：" + suffixName);

		// 文件上传后的路径
		fileName = UUID.randomUUID() + suffixName;
		System.out.println("转换后的名称:" + fileName);

		File dest = new File(UPLDAD_PATH + fileName);

		try {
			file.transferTo(dest);
			String in = StringX.file(dest);
			MapVO fo = new MapVO();
			fo.put("in", in);
			business.process(fo);
			return 0;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
