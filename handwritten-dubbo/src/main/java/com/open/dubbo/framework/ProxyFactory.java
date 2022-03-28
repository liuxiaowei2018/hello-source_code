package com.open.dubbo.framework;

import com.open.dubbo.framework.protocol.http.HttpClient;
import com.open.dubbo.framework.registry.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 22:38
 * @Description
 */
public class ProxyFactory {

    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {

                // mock功能

                String result = null;
                try {

                    //HttpClient httpClient = new HttpClient();
                    Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);

                    //这里需要考虑本地缓存进行性能优化  同时要考虑缓存数据一致性
                    // 例如 zookeeper的watch模式 redis的发布订阅模式 保证数据一致性
                    /*if (cache) {
                        List<URL> urls = cache.get();
                    }*/

                    // zookeeper 配置中心
                    List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());

                    //cache.put(urls);

                    // 负载均衡
                    URL url = LoadBalance.random(urls);

                    //result = httpClient.send(url.getHostName(), url.getPort(), invocation);
                    String response = HttpClient.send("localhost", 8080, invocation);
                    result = response;
                } catch (Exception e) {
                    // 容错功能
                }
                return result;
            }
        });
    }
}
