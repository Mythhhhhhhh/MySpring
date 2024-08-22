package cn.myth.springframework.context.support;

import cn.myth.springframework.beans.factory.FactoryBean;
import cn.myth.springframework.beans.factory.InitializingBean;
import cn.myth.springframework.core.convert.ConversionService;
import cn.myth.springframework.core.convert.converter.Converter;
import cn.myth.springframework.core.convert.converter.ConverterFactory;
import cn.myth.springframework.core.convert.converter.ConverterRegistry;
import cn.myth.springframework.core.convert.converter.GenericConverter;
import cn.myth.springframework.core.convert.support.DefaultConversionService;
import cn.myth.springframework.core.convert.support.GenericConversionService;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * A factory providing convenient access to a ConversionService configured with
 * converters appropriate for most environments. Set the
 * setConverters "converters" property to supplement the default converters.
 *
 * 提供创建 ConversionService 工厂
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    /**
     * 有了 FactoryBean 的实现就可以完成工程对象的操作，可以提供出转换对象的服务 GenericConversionService
     * 另外在 afterPropertiesSet 中调用了注册转换操作的类。最终这个类会被配置到 spring.xml 中在启动的过程加载。
     */

    @Nullable
    private Set<?> converters;


    @Nullable
    private GenericConversionService conversionService;


    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = new DefaultConversionService();
        registerConverters(converters, conversionService);
    }

    private void registerConverters(Set<?> converters, ConverterRegistry registry) {
        if (converters != null) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter<?, ?>) {
                    registry.addConverter((Converter<?, ?>) converter);
                } else if (converter instanceof ConverterFactory<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implement one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }


}
