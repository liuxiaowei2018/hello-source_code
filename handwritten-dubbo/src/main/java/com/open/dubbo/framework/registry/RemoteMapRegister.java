package com.open.dubbo.framework.registry;

import com.open.dubbo.framework.URL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 22:47
 * @Description
 */
public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void register(String interfaceName, URL url) {
        List<URL> urls = REGISTER.get(interfaceName);
        if (urls == null) {
            urls = new ArrayList<>();
        }
        urls.add(url);
        REGISTER.put(interfaceName, urls);

        saveFile();
    }

    public static List<URL> get(String interfaceName) {

        //REGISTER = getFile();
        return REGISTER.get(interfaceName);
    }

    public static void saveFile() {
        // 由于生产者和消费者是两个线程 REGISTER不是同一个备份
        // 这里模拟 文件持久化 保证一致
    }

    public static Map<String, List<URL>> getFile() {
        return new HashMap<>();
    }
}
