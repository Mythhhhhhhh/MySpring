package cn.myth.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.myth.springframework.beans.factory.config.BeanDefinition;
import cn.myth.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A component provider that scans the classpath from a base package. It then
 * applies exclude and include filters to the resulting classes to find candidates.
 * <p>
 */
public class ClassPathScanningCandidateComponentProvider {

    /**
     * 提供一个可以通过配置路径 basePackage
     * 解析出 classes 信息的工具方法 findCandidateComponents，通过这个方法就可以扫描到所有 @Component 注解的 Bean 对象了
     */
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {

        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
