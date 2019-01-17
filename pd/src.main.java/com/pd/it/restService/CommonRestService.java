package com.pd.it.restService;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.itf.IDbService;
import com.pd.it.common.util.SpringUtil;
import com.pd.it.common.util.X;
import com.pd.it.common.vo.FO;
import com.pd.it.common.vo.PageFO;
import com.pd.it.common.vo.ResultVO;
import com.pd.it.common.vo.VO;

/**
 * 通用rest服务
 * 
 * @author thinkpad
 *
 */
@RestController
@RequestMapping("common")
public class CommonRestService {

	@ResponseBody
	@RequestMapping(value = "{action}/{module}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rest(@PathVariable("action") String action, @PathVariable("module") String module,
			@RequestBody(required = false) FO in) {
		return rest(action, module, "", in);
	}

	@ResponseBody
	@RequestMapping(value = "{action}/{module}/{dimension}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String rest(@PathVariable("action") String action, @PathVariable("module") String module,
			@PathVariable("dimension") String dimension, @RequestBody(required = false) FO in) {
		Object rs = execute(module, dimension, action, in);
		return X.jsonStr(rs);

	}

	private Object execute(String module, String dimension, String action, FO in) {
		try {
			String serviceName = SpringUtil.getServiceName(module, dimension);
			IDbService service = SpringUtil.getBean(serviceName, IDbService.class);

			switch (action) {
			case "us":
				VO usVO = new VO(in);
				String usList = usVO.str("list");
				usList = usList.replaceAll("'", "''");
				List<VO> rs = VO.list$str(usList);
				return service.us(rs);
			case "ds":
				VO dsVO = new VO(in);
				String dsList = dsVO.str("list");
				dsList = dsList.replaceAll("'", "''");
				List<VO> list = VO.list$str(dsList);
				return service.ds(list);
			case "rs":
				PageFO fo$page = new PageFO();
				fo$page.setFo(new FO(in));
				return service.rs(fo$page);
			case "ra":
				FO inVO = new FO(in);
				Object rsRa = service.ra(inVO);
				if (rsRa == null) {
					return ResultVO.error("Not found data.");
				}
				return rsRa;
			default:
				return ResultVO.error("Not support action:" + action);
			}
		} catch (Exception e) {
			return X.jsonStr(ResultVO.error(e));
		}
	}

}
