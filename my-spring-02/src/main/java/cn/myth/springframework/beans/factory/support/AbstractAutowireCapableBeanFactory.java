package cn.myth.springframework.beans.factory.support;

import cn.myth.springframework.beans.factory.BeansException;
import cn.myth.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            // Bean的实例化操作newInstance,暂不考虑有有构造函数入参的对象
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 再处理完Bean对象的实例化后,直接调用addSingleton方法存放到单例对象的缓存中
        addSingleton(beanName, bean);
        return bean;
    }
}
