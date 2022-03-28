package com.open.dubbo.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 22:54
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class URL implements Serializable {

    private String hostName;
    private Integer port;
}
