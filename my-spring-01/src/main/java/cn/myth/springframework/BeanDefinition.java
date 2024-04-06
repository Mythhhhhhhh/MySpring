package cn.myth.springframework;

/**
 * 定义：BeanDefinition，在查阅 Spring 源码时经常看到的一个类，例如它会包括 singleton、prototype、BeanClassName 等。但目前我们初步实现会更加简单的处理，只定义一个 Object 类型用于存放对象。
 * 注册：这个过程就相当于我们把数据存放到 HashMap 中，只不过现在 HashMap 存放的是定义了的 Bean 的对象信息。
 * 获取：最后就是获取对象，Bean 的名字就是key，Spring 容器初始化好 Bean 以后，就可以直接获取了。
 * BeanDefinition，用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象
 * 目前的 Bean 定义中，只有一个 Object 用于存放 Bean 对象
 * 后面陆续的实现中会逐步完善 BeanDefinition 相关属性的填充，例如：SCOPE_SINGLETON、SCOPE_PROTOTYPE、ROLE_APPLICATION、ROLE_SUPPORT、ROLE_INFRASTRUCTURE 以及 Bean Class 信息。
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
