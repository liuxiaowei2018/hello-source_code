package com.open.dubbo.provider;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 21:28
 * @Description
 */
public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String userName) {
        return "生产者提供接口:" + userName;
    }
}
