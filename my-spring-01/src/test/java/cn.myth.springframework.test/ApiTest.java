package cn.myth.springframework.test;

import cn.myth.springframework.BeanDefinition;
import cn.myth.springframework.BeanFactory;
import cn.myth.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1.初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
