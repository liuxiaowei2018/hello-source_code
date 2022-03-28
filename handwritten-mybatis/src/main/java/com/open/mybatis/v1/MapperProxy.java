package com.open.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 23:56
 * @Description
 */
public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        String mapperInterfaceName = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String statementId = mapperInterfaceName + "." + methodName;
        return sqlSession.selectOne(statementId, args[0]);
    }
}
