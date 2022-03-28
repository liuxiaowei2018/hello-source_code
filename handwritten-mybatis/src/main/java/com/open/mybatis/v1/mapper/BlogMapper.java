package com.open.mybatis.v1.mapper;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 23:53
 * @Description
 */
public interface BlogMapper {

    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    Blog selectBlogById(Integer bid);
}
