package com.springboot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Repository
public class ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(String name) {
//        String sql = "insert into product (pname) values ('" + name + "')";
        String sql = "insert into product (name) values ('" + name + "')";
        jdbcTemplate.execute(sql);
    }
////(rollbackFor = Exception.class)
    @Transactional
    public void insertBach(String... names) throws Exception {
        for (String name : names) {
            String sql = "insert into product (name) values ('" + name + "')";
            jdbcTemplate.execute(sql);
            if (true) {
                throw new FileNotFoundException();
            }
        }

    }
}
