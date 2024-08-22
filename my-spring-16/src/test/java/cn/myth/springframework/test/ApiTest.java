package cn.myth.springframework.test;

import cn.myth.springframework.context.support.ClassPathXmlApplicationContext;
import cn.myth.springframework.test.bean.Husband;
import cn.myth.springframework.test.bean.Wife;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }




}