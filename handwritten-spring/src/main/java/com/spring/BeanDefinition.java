package com.spring;

/**
 * @author liuxiaowei
 * @date 2022年03月27日 16:53
 * @Description
 */
public class BeanDefinition {

    private Class clazz;

    private String scope;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
