package cn.myth.springframework.beans.factory.support;

import cn.myth.springframework.core.io.DefaultResourceLoader;
import cn.myth.springframework.core.io.ResourceLoader;

/**
 *  抽象类把BeanDefinitionReader接口的前两个方法全部实现了，并提供了构造函数，让外部的调用使用方，把Bean定义注入类，传递进来
 *  这样在接口BeanDefinitionReader的具体实现类中，就可以把解析后的XML文件中的Bean信息，注册到Spring容器去了。
 *  以前我们是通过单元测试使用，调用BeanDefinitionRegistry完成Bean的注册，现在可以放到XML中操作了
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }



}
