package cn.myth.springframework.beans.factory.support;

import cn.myth.springframework.beans.factory.BeanFactory;
import cn.myth.springframework.beans.factory.BeansException;
import cn.myth.springframework.beans.factory.config.BeanDefinition;

/**
 *  模板方法
 *  1.首先继承DefaultSingletonBeanRegister,具备了使用单例注册类方法
 *  2.接下来是实现BeanFactory接口,在方法getBean的实现过程中可以看到,主要是对单例Bean对象的获取以及在获取不到时需要拿到
 *  Bean的定义做相应Bean的实例化操作。那么getBean并没有自身取实现这些方法，而是只定义了调用过程以及提供的抽象方法，由实现
 *  此抽象类的其他类做相应实现。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String bean, BeanDefinition beanDefinition) throws BeansException;
}
