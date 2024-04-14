package cn.myth.springframework.beans.factory.support;

import cn.myth.springframework.beans.BeansException;
import cn.myth.springframework.beans.factory.config.BeanDefinition;
import cn.myth.springframework.beans.factory.config.BeanPostProcessor;
import cn.myth.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.myth.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  模板方法
 *  1.首先继承DefaultSingletonBeanRegister,具备了使用单例注册类方法
 *  2.接下来是实现BeanFactory接口,在方法getBean的实现过程中可以看到,主要是对单例Bean对象的获取以及在获取不到时需要拿到
 *  Bean的定义做相应Bean的实例化操作。那么getBean并没有自身取实现这些方法，而是只定义了调用过程以及提供的抽象方法，由实现
 *  此抽象类的其他类做相应实现。
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String bean, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
