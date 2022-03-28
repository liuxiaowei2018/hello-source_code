package com.open.dubbo.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 22:03
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] paramType;
    private Object[] params;

}
