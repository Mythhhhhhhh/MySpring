package cn.myth.springframework.test;

import cn.myth.springframework.beans.factory.PropertyValue;
import cn.myth.springframework.beans.factory.PropertyValues;
import cn.myth.springframework.beans.factory.config.BeanDefinition;
import cn.myth.springframework.beans.factory.config.BeanReference;
import cn.myth.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.myth.springframework.test.bean.UserDao;
import cn.myth.springframework.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ApiTest {

    @Test
    public void test_BeanFactory(){
//        // 1.初始化BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        // 2.注册bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//        // 3.第一次获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//        System.out.println(userService);
//        // 4.第二次获取 bean from Singleton
//        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
//        userService_singleton.queryUserInfo();
//        System.out.println(userService_singleton);

        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService", "Myth");
//        userService.queryUserInfo();

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


}
