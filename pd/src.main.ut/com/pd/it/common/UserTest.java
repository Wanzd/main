// package com.pd.it.common;
//
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;
//
// import java.util.List;
//
// import javax.annotation.Resource;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import com.pd.it.common.util.AI;
// import com.pd.it.common.util.LogUtil;
// import com.pd.it.common.vo.PageVO;
// import com.pd.it.user.IUserDao;
// import com.pd.it.user.UserFO;
// import com.pd.it.user.UserVO;
//
// @RunWith(SpringJUnit4ClassRunner.class) // ��ʾ�̳���SpringJUnit4ClassRunner��
// @ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
// public class UserTest
// {
// @Resource
// private IUserDao userDao;
//
// @Test
// public void test$user$c()
// {
// UserVO vo = AI.c(UserVO.class, "id", "i1", "name", "n1");
// int c = userDao.c(vo);
// UserFO fo = AI.c(UserFO.class, "id", "i1");
// UserVO rVO = userDao.r(fo);
// assertEquals("n1", rVO.getName());
// userDao.d(fo);
// }
//
// @Test
// public void test$user$r()
// {
// UserVO vo = AI.c(UserVO.class, "id", "i1", "name", "n1");
// userDao.c(vo);
// UserFO fo = AI.c(UserFO.class, "id", "i1");
// UserVO rVO = userDao.r(fo);
// assertEquals("n1", rVO.getName());
// userDao.d(fo);
// }
//
// @Test
// public void test$user$ra()
// {
// List<UserVO> rsList = userDao.ra();
// assertNotNull(rsList);
// }
//
// @Test
// public void test$user$u()
// {
// UserFO fo = AI.c(UserFO.class, "id", "i1", "name", "n2");
// int uRs = userDao.u(fo);
// UserVO vo = userDao.r(fo);
// assertEquals("n2", vo.getName());
// fo = AI.c(UserFO.class, "name", "n2");
// int uRs2 = userDao.u(fo);
// vo = userDao.r(fo);
// assertEquals("n1", vo.getName());
// }
//
// @Test
// public void test$user$d()
// {
// UserVO vo = AI.c(UserVO.class, "id", "i1", "name", "n1");
// userDao.c(vo);
// UserFO fo = AI.c(UserFO.class, "id", "i1");
// userDao.d(fo);
// }
//
// @Test
// public void test$pCount()
// {
// UserFO fo = AI.c(UserFO.class, "id", "1");
// PageVO page = AI.c(PageVO.class);
// try
// {
// int pCount = userDao.pCount(fo, page);
// LogUtil.debug("pCount", pCount);
// }
// catch (Exception e)
// {
// LogUtil.err(e);
// }
// }
// }
