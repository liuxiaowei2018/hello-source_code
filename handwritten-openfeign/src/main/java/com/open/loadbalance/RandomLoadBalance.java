package com.open.loadbalance;

import java.util.Random;

/**
 * @author liuxiaowei
 * @date 2022年04月02日 17:34
 * @Description 随机算法
 */
public class RandomLoadBalance {

    public static String getServer() {
        // 生成一个随机数做list的下标
        Random random = new Random();
        int randomPos = random.nextInt(ServerIps.LIST.size());
        return ServerIps.LIST.get(randomPos);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
