package cn.myth.springframework.beans.factory.config;

/**
 *  单例注册接口定义
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
