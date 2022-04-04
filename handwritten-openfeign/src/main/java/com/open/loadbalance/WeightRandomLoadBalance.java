package com.open.loadbalance;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author liuxiaowei
 * @date 2022年04月02日 17:34
 * @Description 权重随机算法
 * 这种实现方法在遇到权重之和特别大的时候就会比较消耗内存，因为需要对ip地址进行复制，权重之和越大那么上文中的ips就需要越多的内存
 */
public class WeightRandomLoadBalance {

    public static String getServer() {

        ArrayList<String> ips = new ArrayList<>();
        for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);
            for (int i = 0; i < weight; i++) {
                // 按权重进行复制ip
                ips.add(ip);
            }
        }
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
