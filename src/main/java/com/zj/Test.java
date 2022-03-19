package com.zj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        // 注册 JDBC 驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 打开链接
        System.out.println("连接数据库...");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC", "root", "6258077");

        // 执行查询
        System.out.println(" 实例化Statement对象...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM oldbook";
        ResultSet rs = stmt.executeQuery(sql);

        // 展开结果集数据库
        while (rs.next()) {
            // 通过字段检索
            int id = rs.getInt("id");
            // 输出数据
            System.out.print("ID: " + id);
            System.out.print("\n");
        }
    }
}
