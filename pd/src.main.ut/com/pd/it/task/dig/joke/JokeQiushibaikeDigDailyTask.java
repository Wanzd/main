//package com.pd.it.task.dig.joke;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.pd.it.common.itf.IBuilder;
//import com.pd.it.common.itf.ITask;
//import com.pd.it.common.util.AI;
//import com.pd.it.common.util.Db;
//import com.pd.it.common.util.Find;
//import com.pd.it.common.util.Format;
//import com.pd.it.common.util.Mail;
//import com.pd.it.common.util.NetUtil;
//import com.pd.it.common.vo.VO;
//
//public class JokeQiushibaikeDigDailyTask implements ITask {
//
//	private final String taskId = "JokeQiushibaikeDigDailyTask" + Format.date2Str(new Date(), "yyyyMMddHHmmss");
//
//	@Override
//	public void execute() {
//		Db.u("log.u", new VO().nvl("typeId", "timerTask").nvl("id", taskId).nvl("cUser", "system").nvl("name", "start")
//				.nvl("detail", "ok"));
//		// 清除旧数据
//		Db.u("joke$qiushibaike.truncate");
//
//		// 获取新数据
//		AI.build(new JokeQiushibaikeParseBuilder());
//
//		// 邮件
//		AI.build(new MailQiushibaikeBuilder());
//
//		Db.u("log.u", new VO().nvl("typeId", "timerTask").nvl("id", taskId).nvl("cUser", "system").nvl("name", "end")
//				.nvl("detail", "ok"));
//
//	}
//
//	private class JokeQiushibaikeParseBuilder implements IBuilder<VO, List<VO>> {
//
//		private VO vo = new VO();
//
//		@Override
//		public List<VO> build(VO in) {
//
//			// List<String> pageUrls = getPageUrls();
//			List<VO> jokeList = getJokeListDaily();
//
//			// Db.u("joke$qiushibaike.us", new VO("list", jokeList));
//
//			return null;
//		}
//
//		private List<VO> getJokeListDaily() {
//			int startIndex = 0;
//			boolean hasNextPage = true;
//
//			List<VO> rsList = new ArrayList<VO>();
//			while (hasNextPage) {
//				List<VO> pageList = getJokeList$pageIndex(++startIndex);
//				if (pageList == null || pageList.size() == 0) {
//					hasNextPage = false;
//					break;
//				}
//				rsList.addAll(pageList);
//			}
//			return rsList;
//		}
//
//		private List<VO> getJokeList$pageIndex(int pageIndex) {
//
//			String url = "https://www.qiushibaike.com/text/" + pageIndex;
//
//			vo.put("url", url);
//			VO rest = NetUtil.jsoup(vo);
//
//			if (rest == null) {
//				return null;
//			}
//			String str = rest.str("msg");
//			List<String> idList = Find.strs$between(str, " <a href=\"/article/", "\"");
//
//			for (String eachId : idList) {
//				VO tmpVO = getJoke$id(eachId);
//				if (tmpVO != null) {
//
//					Db.u("joke$qiushibaike.us", new VO("list", AI.list(tmpVO)));
//				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					Db.u("log.u", new VO().nvl("typeId", "timerTask").nvl("id", taskId).nvl("cUser", "system")
//							.nvl("name", "error").nvl("detail", e.getStackTrace().toString()));
//
//				}
//			}
//			return null;
//		}
//
//		private VO getJoke$id(String id) {
//			VO rest = NetUtil.jsoup(new VO("url", "https://www.qiushibaike.com/article/" + id));
//
//			if (rest == null) {
//				return null;
//			}
//			String msg = rest.str("msg");
//
//			VO rsVO = new VO();
//			rsVO.put("id", id);
//			String content = Find.str$between(msg, "<div class=\"content", "</div>");
//			content = Find.str$start(content, ">");
//			content = Find.str$trim(content, ";");
//			content=content.replaceAll("<.*>", "");
//			content = content.substring(0, content.length() - 1);
//			if (content.length() > 2000) {
//				return null;
//			}
//			rsVO.put("content", content);
//
//			String thumbs = Find.str$between(msg, "data-votes=\"", "\"");
//			thumbs = Find.str$trim(thumbs, ";");
//			rsVO.put("thumbs", AI.num(thumbs));
//
//			String comments = Find.str$between(msg, "<span class=\"comments\">", " 评论");
//			comments = Find.str$trim(comments, ";");
//			rsVO.put("comments", AI.num(comments));
//			return rsVO;
//		}
//	}
//
//	private class MailQiushibaikeBuilder implements IBuilder<VO, VO> {
//
//		@Override
//		public VO build(VO in) {
//			// 查询糗事百科按赞数倒序排列
//			List<VO> topList = Db.ra("joke$top.ra");
//
//			VO vo = new VO().nvl("title", "testTitle");
//			vo.nvl("to", "379331690@qq.com,496019830@qq.com,panda_zdwan@hotmail.com,testwzd@163.com");
//			vo.nvl("list", topList);
//			Mail.send("dailyJoke", vo);
//			return null;
//		}
//
//	}
//}
