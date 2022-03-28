package com.open.dubbo.comsumer;

import com.open.dubbo.framework.ProxyFactory;
import com.open.dubbo.provider.HelloService;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 21:29
 * @Description
 */
public class Consumer {

    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class); //Dubbo+spring容器
        String result= helloService.sayHello("hello,我要消费了...");

        System.out.println(result);
    }
}
