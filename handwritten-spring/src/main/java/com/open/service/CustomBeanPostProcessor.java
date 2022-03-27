package com.open.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;

import java.lang.reflect.Proxy;

/**
 * @author liuxiaowei
 * @date 2022年03月27日 18:04
 * @Description
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        System.out.println("初始化前操作");
        if (beanName.equals("userService")) {
            ((UserService) bean).setName("写入name值");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后操作");

        // 匹配切点
        // 模拟代理
        if (beanName.equals("userService")) {
            Object proxyInstance = Proxy.newProxyInstance(CustomBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("代理逻辑"); //找切点
                return method.invoke(bean, args);
            });
            return proxyInstance;
        }
        return bean;
    }
}
