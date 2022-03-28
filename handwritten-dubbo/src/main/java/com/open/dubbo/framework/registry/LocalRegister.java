package com.open.dubbo.framework.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 22:11
 * @Description
 */
public class LocalRegister {

    public static Map<String, Class> map = new HashMap<>();

    public static void register(String interfaceName, Class implClazz) {
        map.put(interfaceName, implClazz);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
