package com.springboot.jdbc;

//import com.mysql.jdbc.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;

//import javax.sql.DataSource;
@EnableTransactionManagement
@SpringBootApplication
public class JdbcApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(JdbcApplication.class);
        ConfigurableApplicationContext context = app.run(args);
//		System.out.println("jdbc="+context.getBean(DataSource.class));
//		System.out.println(context.getBean(JdbcTemplate.class));
//		System.out.println(connection.getCatalog());
//		context.getBean(ProductDao.class).insert("lisi");
        DataSource ds = context.getBean(DataSource.class);
        Connection connection = ds.getConnection();
        context.getBean(ProductDao.class).insertBach("wangxaun","DDD","RR");
        System.out.println(connection.getClass());
        connection.close();

    }
}
