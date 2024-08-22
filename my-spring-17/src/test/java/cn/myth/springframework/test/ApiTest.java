package cn.myth.springframework.test;

import cn.myth.springframework.context.support.ClassPathXmlApplicationContext;
import cn.myth.springframework.core.convert.converter.Converter;
import cn.myth.springframework.core.convert.support.StringToNumberConverterFactory;
import cn.myth.springframework.test.bean.Husband;
import cn.myth.springframework.test.converter.StringToIntegerConverter;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_convert() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        System.out.println("测试结果：" + husband);
    }

    @Test
    public void test_StringToIntegerConverter() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer num = converter.convert("1234");
        System.out.println("测试结构：" + num);
    }

    @Test
    public void test_StringToNumberConverter() {
        StringToNumberConverterFactory converterFactory = new StringToNumberConverterFactory();

        Converter<String, Integer> stringIntegerConverter = converterFactory.getConverter(Integer.class);
        System.out.println("测试结果：" + stringIntegerConverter.convert("1234"));

        Converter<String, Long> stringToLongConverter = converterFactory.getConverter(Long.class);
        System.out.println("测试结果：" + stringToLongConverter.convert("1234"));
    }


}
