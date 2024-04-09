package cn.myth.springframework.beans.factory;

import cn.myth.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

}
