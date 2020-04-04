package com.pd.it.app.job.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pd.base.model.MapVO;
import com.pd.it.app.job.dao.IAppJobDao;
import com.pd.it.base.WebUtil;
import com.pd.it.common.DoubleX;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.service.api.IDeleteService;
import com.pd.it.service.api.IInsertListService;
import com.pd.it.service.api.IQueryListService;

@Named
public class Job51Service implements IQueryListService<MapVO, MapVO>, IInsertListService<MapVO>, IDeleteService<MapVO> {
	@Inject
	private IAppJobDao dao;

	public void init(MapVO fo) {
		dao.delete(fo);
	}

	public void process(MapVO fo) {
		String keyword = "java";
		String url = "https://search.51job.com/list/180200,000000,0000,00,9,99," + keyword
				+ ",2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
		String httpStr = WebUtil.post(url, null, "GB2312");
		Document doc = Jsoup.parse(httpStr);
		Element resultList = doc.getElementById("resultList");
		Elements divs = resultList.getElementsByClass("el");
		divs.remove(0);
		List<MapVO> list = divs.stream().map(vo -> new VoBuilder().build(vo)).collect(Collectors.toList());

		dao.insertList(list);
	}

	private static class VoBuilder implements IBuilder<Element, MapVO> {
		@Override
		public MapVO build(Element in) {
			MapVO rsVO = new MapVO();
			rsVO.put("id", in.getElementsByClass("t1").first().getElementsByClass("checkbox").first().attr("value"));
			rsVO.put("location", in.getElementsByClass("t3").first().text());
			rsVO.put("company", in.getElementsByClass("t2").first().getElementsByTag("a").first().attr("title"));
			rsVO.put("jobName", in.getElementsByClass("t1").first().getElementsByTag("span").first()
					.getElementsByTag("a").first().attr("title"));
			rsVO.put("salary", in.getElementsByClass("t4").first().text());
			rsVO.put("salaryFrom", new SalaryFromBuilder().build(in));
			rsVO.put("salaryTo", new SalaryToBuilder().build(in));
			rsVO.put("creationDate", in.getElementsByClass("t5").first().text());
			rsVO.put("url", in.getElementsByClass("t1").first().getElementsByTag("span").first().getElementsByTag("a")
					.first().attr("href"));
			return rsVO;
		}

	}

	private static class SalaryFromBuilder implements IBuilder<Element, String> {
		@Override
		public String build(Element in) {
			try {
				String salaryStr = in.getElementsByClass("t4").first().text().trim();
				int base = 0;
				if (salaryStr.endsWith("万/月")) {
					base = 10000;
				} else if (salaryStr.endsWith("千/月")) {
					base = 1000;
				} else if (salaryStr.endsWith("万/年")) {
					base = 833;
				}
				String from = salaryStr.substring(0, salaryStr.indexOf("-"));
				return DoubleX.str(from) * base + "";
			} catch (Exception e) {
				return "0";
			}
		}

	}

	private static class SalaryToBuilder implements IBuilder<Element, String> {
		@Override
		public String build(Element in) {
			try {
				String salaryStr = in.getElementsByClass("t4").first().text().trim();
				int base = 0;
				if (salaryStr.endsWith("万/月")) {
					base = 10000;
				} else if (salaryStr.endsWith("千/月")) {
					base = 1000;
				} else if (salaryStr.endsWith("万/年")) {
					base = 833;
				}
				String to = salaryStr.substring(salaryStr.indexOf("-") + 1, salaryStr.indexOf("/") - 1);
				return DoubleX.str(to) * base + "";
			} catch (Exception e) {
				return "0";
			}
		}
	}

}
