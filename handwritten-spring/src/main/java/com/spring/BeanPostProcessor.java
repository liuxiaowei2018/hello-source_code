package com.spring;

/**
 * @author liuxiaowei
 * @date 2022年03月27日 17:53
 * @Description
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
