package cn.myth.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {

    /**
     * 在获取资源的实现中，主要是把三种不同类型的资源处理方式进行了包装，分为：判断是否为Classpath、URL以及文件
     * @param location
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // ClassPath
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                // Url
                URL url = new URL(location);
                return new UrlResource((url));
            } catch (MalformedURLException e) {
                // File
                return new FileSystemResource(location);
            }
        }
    }
}
