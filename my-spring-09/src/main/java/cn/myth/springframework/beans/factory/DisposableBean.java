package cn.myth.springframework.beans.factory;

public interface DisposableBean {

    void destroy() throws Exception;

}
