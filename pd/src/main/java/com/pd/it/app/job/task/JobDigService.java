package com.pd.it.app.job.task;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.pd.it.app.job.dao.IAppJobDao;
import com.pd.it.base.util.x.DoubleX;
import com.pd.it.common.itf.IBuilder;
import com.pd.it.common.util.Builds;
import com.pd.it.common.util.NetUtil;
import com.pd.it.common.util.XmlUtil;
import com.pd.it.common.vo.VO;
import com.pd.it.web.itf.service.IParallelService;

@Service
public class JobDigService implements IParallelService {

	@Inject
	protected IAppJobDao dao;

	@Override
	public Object executeTask(VO in) {

		// 清除旧数据
		dao.truncate();

		// 获取新数据
		VO vo = new VO();
		boolean flag = true;
		int curPage = 1;
		while (flag) {
			if (curPage > 30) {
				flag = false;
			}
			String url = "https://search.51job.com/list/180200,000000,0000,00,9,99,Java,2," + curPage
					+ ".html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
			vo.put("url", url);
			VO rest = NetUtil.rest(vo);

			List<VO> rsList = Builds.build(rest, new Job51ParseBuilder());

			if (rsList == null && rsList.size() == 0) {
				flag = false;
				break;
			}
			dao.cs(rsList);
			curPage++;
		}
		return null;
	}

	private static class Job51ParseBuilder implements IBuilder<VO, List<VO>> {
		static String xPath = "//div:class[e1]";

		@Override
		public List<VO> build(VO in) {
			String str = in.str("msg");
			int startIndex = str.indexOf("<div class=\"el\">");
			int lastIndex = str.lastIndexOf("<div class=\"el\">");
			int endIndex = str.indexOf("</div>", lastIndex);
			str = str.substring(startIndex, endIndex) + "</div>";
			str = str.replaceAll("&", "&amp;").replaceAll("<img .*>", "");
			str = str.replaceAll("<div", "@@<div");
			String[] split = str.split("@@");
			List<VO> rsList = new ArrayList<VO>();
			for (String eachStr : split) {
				if (eachStr.length() == 0) {
					continue;
				}
				try {
					List<Element> list = XmlUtil.readStr(eachStr, "//div");
					for (Element eachElement : list) {
						rsList.add(element2VO(eachElement));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return rsList;
		}

		private VO element2VO(Element element) {
			VO rsVO = new VO();
			// rsVO.put("jobName", XmlUtil.readStr(element, "p[class=t1
			// tg1]/span/a/text()"));
			rsVO.put("job", XmlUtil.readStr(element, "p[contains(@class,'t1')]/span/a/text()"));
			rsVO.put("company", XmlUtil.readStr(element, "span[contains(@class,'t2')]/a/text()"));
			rsVO.put("location", XmlUtil.readStr(element, "span[contains(@class,'t3')]/text()"));
			rsVO.put("url", XmlUtil.readStr(element, "p/span/a/@href"));
			String detail = Builds.build(new JobDetailBuilder(), rsVO);
			rsVO.put("detail", detail);
			String salaryStr = XmlUtil.readStr(element, "span[contains(@class,'t4')]/text()");
			VO salaryVO = Builds.build(new SalaryVOBuilder(), salaryStr);
			rsVO.put("salary", salaryStr);
			rsVO.put("salaryStart", salaryVO.num("salaryStart"));
			rsVO.put("salaryEnd", salaryVO.num("salaryEnd"));
			rsVO.put("createDate", XmlUtil.readStr(element, "span[contains(@class,'t5')]/text()"));
			return rsVO;
		}
	}

	private static class JobDetailBuilder implements IBuilder<VO, String> {

		@Override
		public String build(VO in) {
			VO htmlStr = NetUtil.rest(in);
			String mainStr = htmlStr.str("msg");
			int startIndex = mainStr.indexOf("<div class=\"bmsg job_msg inbox\">");
			int endIndex = mainStr.indexOf("<div class=\"tBorderTop_box\">\r\n" + "", startIndex);
			mainStr = mainStr.substring(startIndex, endIndex);
			mainStr = mainStr.replaceAll("<br>", "").replaceAll("&", "&amp;").replaceAll("<img .*>", "");
			List<Element> list = XmlUtil.readStr(mainStr, "//div/*");
			StringBuffer sBuffer = new StringBuffer();
			for (Element eachElement : list) {
				sBuffer.append(element2VO(eachElement) + "\n");
			}
			return sBuffer.toString().trim();
		}

		private String element2VO(Element element) {
			return XmlUtil.readStr(element, "text()");
		}

		public static void main(String[] args) {
			VO vo = new VO();
			vo.put("url", "https://jobs.51job.com/wuhan/102909708.html?s=01&t=0");
			String rsStr = new JobDetailBuilder().build(vo);
			System.out.println(rsStr);
		}
	}

	private static class SalaryVOBuilder implements IBuilder<String, VO> {

		@Override
		public VO build(String in) {
			int unitValue = 0;
			if (in.endsWith("千/月")) {
				unitValue = 1000;
			} else if (in.endsWith("万/月")) {
				unitValue = 10000;
			}

			if (in.length() < 3) {
				VO rsVO = new VO();
				rsVO.put("salaryStart", 0);
				rsVO.put("salaryEnd", 0);
				return rsVO;
			}
			String valueStr = in.substring(0, in.length() - 3);
			String[] split = valueStr.split("-");
			VO rsVO = new VO();
			rsVO.put("salaryStart", DoubleX.str(split[0]) * unitValue);
			rsVO.put("salaryEnd", DoubleX.str(split[1]) * unitValue);
			return rsVO;
		}

	}
}