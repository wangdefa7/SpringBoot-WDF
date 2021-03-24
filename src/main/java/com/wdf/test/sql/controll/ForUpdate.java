package com.wdf.test.sql.controll;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * @ClassName: ForUpdate
 * @Author WDF
 * @Description 测试for update
 * @Date 2020/12/30 10:55
 * @Copyright Dareway 2020/12/30
 * @Version 1.0
 **/
public class ForUpdate {

    

    public static void main(String[] args) {
        JdbcTemplate template = null;
        String sql = "select * from users for update";
        Map<String, Object> map = template.queryForMap(sql, 49);
        System.out.println(map);
    }




}
