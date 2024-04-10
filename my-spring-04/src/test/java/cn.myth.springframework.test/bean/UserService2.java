package cn.myth.springframework.test.bean;

public class UserService2 {
    private String name;

    public UserService2() {

    }

    public UserService2(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
