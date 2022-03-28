package com.open.dubbo.framework;

import java.util.List;
import java.util.Random;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 22:57
 * @Description
 */
public class LoadBalance {

    public static URL random(List<URL> list) {
        if (list == null) {
            return null;
        }
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
