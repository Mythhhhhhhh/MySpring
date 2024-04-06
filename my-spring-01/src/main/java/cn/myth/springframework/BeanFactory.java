package cn.myth.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BeanFactory，代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取
 * 在 Bean 工厂的实现中，包括了 Bean 的注册，这里注册的是 Bean 的定义信息。同时在这个类中还包括了获取 Bean 的操作。
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
