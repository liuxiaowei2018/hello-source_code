package com.open.mybatis.v1;

import com.open.mybatis.v1.mapper.BlogMapper;

/**
 * @author liuxiaowei
 * @date 2022年03月29日 0:07
 * @Description
 */
public class V1Test {
    public static void main(String[] args) {

        SqlSession sqlSession = new SqlSession(new Configuration(), new Executor());
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.selectBlogById(1);
    }
}
