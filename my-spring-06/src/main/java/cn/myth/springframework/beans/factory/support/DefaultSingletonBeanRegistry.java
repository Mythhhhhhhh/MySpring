package cn.myth.springframework.beans.factory.support;

import cn.myth.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 *  单例注册接口的实现
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    public final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    // 这个方法可以被继承此类的其他类调用
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
