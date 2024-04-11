package cn.myth.springframework.beans.factory.support;

import cn.myth.springframework.beans.BeansException;
import cn.myth.springframework.core.io.Resource;
import cn.myth.springframework.core.io.ResourceLoader;

/**
 *  Simple interface for bean definition readers
 *  getRegistry()、getResourceLoader()，都是用于提供给后面三个方法的工具，加载和注册，
 *  这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
