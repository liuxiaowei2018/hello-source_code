package com.open.service;

import com.spring.Autowired;
import com.spring.BeanNameAware;
import com.spring.Component;
import com.spring.InitializingBean;

/**
 * @author liuxiaowei
 * @date 2022年03月27日 16:11
 * @Description
 */
@Component("userService")
//@Scope("prototype")
public class UserService implements BeanNameAware, InitializingBean,UserInterface {

    @Autowired
    private OrderService orderService;

    public void setName(String name) {
        this.name = name;
    }

    private String beanName;

    private String name;

    @Override
    public void test() {
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println(name);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化...");
    }
}
