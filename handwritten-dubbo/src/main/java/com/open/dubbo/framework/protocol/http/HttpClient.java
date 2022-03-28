package com.open.dubbo.framework.protocol.http;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.open.dubbo.framework.Invocation;


/**
 * @author liuxiaowei
 * @date 2022年03月28日 22:21
 * @Description
 */
public class HttpClient {

    public static String send(String hostName, Integer port, Invocation invocation) {
        // 用户的配置
        String result = HttpUtil.post("http://" + hostName + ":" + port + "/", JSONObject.toJSONString(invocation));
        return result;
    }
}
