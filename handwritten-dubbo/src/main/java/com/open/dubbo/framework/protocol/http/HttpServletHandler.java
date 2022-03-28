package com.open.dubbo.framework.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.open.dubbo.framework.Invocation;
import com.open.dubbo.framework.registry.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 21:59
 * @Description
 */
public class HttpServletHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        // 处理 请求的逻辑
        // 解析请求---》调用的那个服务--》接口，方法，参数类型，方法参数

        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);
            String interfaceName = invocation.getInterfaceName();
            String methodName = invocation.getMethodName();
            Class[] paramType = invocation.getParamType();

            // 执行子服务
            Class impl = LocalRegister.get(interfaceName);
            Method method = impl.getMethod(methodName, paramType);
            String result = (String) method.invoke(impl.newInstance(), invocation.getParams());

            IOUtils.write(result, resp.getOutputStream());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
