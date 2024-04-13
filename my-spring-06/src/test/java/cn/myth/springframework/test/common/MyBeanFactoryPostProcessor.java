package cn.myth.springframework.test.common;

import cn.myth.springframework.beans.BeansException;
import cn.myth.springframework.beans.PropertyValue;
import cn.myth.springframework.beans.PropertyValues;
import cn.myth.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.myth.springframework.beans.factory.config.BeanDefinition;
import cn.myth.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
