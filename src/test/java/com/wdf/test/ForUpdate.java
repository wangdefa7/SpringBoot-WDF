package com.wdf.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
public class ForUpdate {


    JdbcTemplate template;
    @Test
    public void ForUpdate() {
        String sql = "select * from users for update";
        Map<String, Object> map = template.queryForMap(sql, 49);
        System.out.println(map);
    }




}
