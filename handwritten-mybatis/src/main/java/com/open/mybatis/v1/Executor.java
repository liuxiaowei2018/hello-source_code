package com.open.mybatis.v1;

import com.open.mybatis.v1.mapper.Blog;

import java.sql.*;

/**
 * @author liuxiaowei
 * @date 2022年03月28日 23:55
 * @Description
 */
public class Executor {

    public <T> T query(String sql, Object paramater) {

        Connection conn = null;
        Statement stmt = null;

        Blog blog = new Blog();

        // 注册 JDBC 驱动
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开连接
            conn = DriverManager.getConnection("jdbc:mysql://172.31.2.27:3306/laoshiren", "root", "root");
            // 执行查询
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, paramater));
            // 获取结果集
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T)blog;
    }
}
