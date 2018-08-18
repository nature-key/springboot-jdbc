package com.springboot.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootConfiguration
public class MyDataBase {

    @Autowired
    private Environment env;

    @Bean
    public DataSource createDataSource() {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(env.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(env.getProperty("spring.datasource.username"));
        druidDataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        druidDataSource.setPassword(env.getProperty("spring.datasource.password"));
        return druidDataSource;
    }
}
