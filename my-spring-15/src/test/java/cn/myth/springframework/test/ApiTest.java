package cn.myth.springframework.test;

import cn.myth.springframework.context.support.ClassPathXmlApplicationContext;
import cn.myth.springframework.test.bean.IUserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_autoProxy_2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring2.xml");
        cn.myth.springframework.test.bean2.IUserService userService = applicationContext.getBean("userService", cn.myth.springframework.test.bean2.IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
