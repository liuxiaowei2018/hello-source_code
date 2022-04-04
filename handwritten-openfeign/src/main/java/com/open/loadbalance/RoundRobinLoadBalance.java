package com.open.loadbalance;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

/**
 * @author liuxiaowei
 * @date 2022年04月02日 17:49
 * @Description 轮询算法
 */
public class RoundRobinLoadBalance {

    /**
     * 当前循环的位置
     */
    private static Integer pos = 0;

    public static String getServer() {
        String ip = null;
        // pos同步
        synchronized (pos) {
            if (pos >= ServerIps.LIST.size()) {
                pos = 0;
            }
            ip = ServerIps.LIST.get(pos);
            pos++;
        }
        return ip;
    }

    public static void main(String[] args) {
        // 连续调用10次
        for (int i = 0; i < 11; i++) {
            System.out.println(getServer());
        }
        StringJoiner stringJoiner = new StringJoiner(".");

    }

}
