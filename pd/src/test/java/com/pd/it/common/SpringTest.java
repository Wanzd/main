// package com.pd.it.common;
//
// import org.junit.Test;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
// import com.pd.it.common.util.AI;
// import com.pd.it.user.UserFO;
// import com.pd.it.user.UserService;
//
// public class SpringTest
// {
// @Test
// public void testGetService()
// {
//// ApplicationContext appContext = new ClassPathXmlApplicationContext("cfg/spring.xml");
// ApplicationContext appContext = new AnnotationConfigApplicationContext("com.pd.it");
// UserService service = appContext.getBean(UserService.class);
// UserFO userVO=AI.c(UserFO.class, "name","test");
// service.c(userVO);
// }
// }
