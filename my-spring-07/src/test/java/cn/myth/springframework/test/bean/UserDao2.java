package cn.myth.springframework.test.bean;

import cn.myth.springframework.beans.factory.DisposableBean;
import cn.myth.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.Map;

public class UserDao2 implements InitializingBean, DisposableBean {

    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "Myth");
        hashMap.put("10002", "Sun");
        hashMap.put("10003", "Tree");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean：destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean：afterPropertiesSet");
    }
}
