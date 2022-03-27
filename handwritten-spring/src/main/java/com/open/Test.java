package com.open;

import com.open.service.UserInterface;
import com.open.service.UserService;
import com.spring.CustomApplicationContext;

/**
 * @author liuxiaowei
 * @date 2022年03月27日 16:04
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        CustomApplicationContext customApplicationContext = new CustomApplicationContext(AppConfig.class);

//        System.out.println(customApplicationContext.getBean("userService"));
//        System.out.println(customApplicationContext.getBean("userService"));
//        System.out.println(customApplicationContext.getBean("userService"));

        //UserService userService = (UserService) customApplicationContext.getBean("userService");
        // jdk动态代理
        UserInterface userService = (UserInterface) customApplicationContext.getBean("userService");
        userService.test();
    }
}
