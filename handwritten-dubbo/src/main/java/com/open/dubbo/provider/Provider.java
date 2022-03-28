package com.open.dubbo.provider;

import com.open.dubbo.framework.URL;
import com.open.dubbo.framework.protocol.http.HttpServer;
import com.open.dubbo.framework.registry.LocalRegister;
import com.open.dubbo.framework.registry.RemoteMapRegister;
import java.net.MalformedURLException;



/**
 * @author liuxiaowei
 * @date 2022年03月28日 21:33
 * @Description
 */
public class Provider {
    public static void main(String[] args) {

        // 用户的配置 tomcat、netty、jetty
        HttpServer httpServer = new HttpServer();

        // 暴露服务 多实现类对应多版本 --》服务版本号
        LocalRegister.register(HelloService.class.getName(),HelloServiceImpl.class);
        //LocalRegister.register(HelloService.class.getName()+version2,HelloServiceImpl.class);



        URL url = new URL("localhost", 8080);
        RemoteMapRegister.register(HelloService.class.getName(),url);

        httpServer.start("localhost",8080);

//        DubboServer dubboServer = new DubboServer();
//        dubboServer.start();



    }
}
