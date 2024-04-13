package cn.myth.springframework.context;

import cn.myth.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册虚拟机钩子的方法
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭
     */
    void close();
}
