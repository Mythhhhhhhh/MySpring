package cn.myth.springframework.utils;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link cn.myth.springframework.beans.factory.config.ConfigurableBeanFactory}.
 * <p>
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);

}
