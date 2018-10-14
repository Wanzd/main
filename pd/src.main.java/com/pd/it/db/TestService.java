package com.pd.it.db;

import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pd.it.common.provider.CommonSqlProvider;
import com.pd.it.common.util.AI;
import com.pd.it.common.util.Db;
import com.pd.it.common.vo.VO;
import com.pd.it.task.dig.HouseFangtianxiaDigTask;
import com.pd.it.task.dig.Job51DigTask;
import com.pd.it.task.dig.NotebookTaobaoDigTask;
import com.pd.it.task.dig.PhoneTaobaoDigTask;
import com.pd.it.task.dig.joke.JokeQiushibaikeDigDailyTask;
import com.pd.it.task.heat.HouseLocationHeatTask;

@RestController
@RequestMapping("test")
public class TestService {

	@ResponseBody
	@RequestMapping(value = "test", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String test(LinkedHashMap<String, String> json) {
		return "[{a:'1'}]";
	}

	@ResponseBody
	@RequestMapping(value = "51job", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String job$51(LinkedHashMap<String, String> json) {
		AI.task(new Job51DigTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "house$fangtianxia", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String house$anjuke(LinkedHashMap<String, String> json) {
		AI.task(new HouseFangtianxiaDigTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "house$heat", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String house$heat(LinkedHashMap<String, String> json) {
		AI.task(new HouseLocationHeatTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "phone$taobao", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String phone$taobao(LinkedHashMap<String, String> json) {
		AI.task(new PhoneTaobaoDigTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "notebook$taobao", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String notebook$taobao(LinkedHashMap<String, String> json) {
		AI.task(new NotebookTaobaoDigTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "joke$qiushibaike", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String joke$qiushibaike(LinkedHashMap<String, String> json) {
		// AI.task(new JokeQiushibaikeDigTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "joke$heat", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String joke$heat(LinkedHashMap<String, String> json) {
		// AI.task(new JokeQiushibaikeHeatTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "joke$daily", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String joke$daily(LinkedHashMap<String, String> json) {
		AI.task(new JokeQiushibaikeDigDailyTask());
		return "[{result:'success'}]";
	}

	@ResponseBody
	@RequestMapping(value = "sync$dao", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public String sync$dao() {
		CommonSqlProvider.refresh();
		Db.u("log.u", new VO().nvl("typeId", "refreshSysCfg").nvl("id", "Dao").nvl("cUser", "system")
				.nvl("name", "start").nvl("detail", ""));
		return "[{result:'success'}]";
	}
}
