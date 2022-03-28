package com.open.dubbo.provider;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 21:28
 * @Description
 */
public class HelloServiceImpl2 implements HelloService{

    @Override
    public String sayHello(String userName) {
        return "Hello2" + userName;
    }
}
