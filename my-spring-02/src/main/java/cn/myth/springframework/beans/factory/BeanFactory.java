package cn.myth.springframework.beans.factory;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;

}
