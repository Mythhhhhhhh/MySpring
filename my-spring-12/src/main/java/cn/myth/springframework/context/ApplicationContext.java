package cn.myth.springframework.context;

import cn.myth.springframework.beans.factory.HierarchicalBeanFactory;
import cn.myth.springframework.beans.factory.ListableBeanFactory;
import cn.myth.springframework.core.io.ResourceLoader;

/**
 * 上下文接口
 * ApplicationContext，继承于ListableBeanFactory，也就继承了关于BeanFactory方法，比如一些getBean的方法
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
