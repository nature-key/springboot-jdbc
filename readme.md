JDBC

  数据源配置
    
    1.引入驱动
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    2.数据库配置
        spring.datasource.url=jdbc:mysql://localhost:3306/test
        spring.datasource.username=root
        spring.datasource.password=123456
        spring.datasource.driverClassName = com.mysql.jdbc.Driver
    3.数据库操作
        JdbcTemplate  （使用@Repository注解）
    4.主类运行
        SpringApplication app = new SpringApplication(JdbcApplication.class);
        ConfigurableApplicationContext context = app.run(args);
        DataSource ds = context.getBean(DataSource.class);
        Connection connection = ds.getConnection();
        context.getBean(ProductDao.class).insertBach("wangxaun","DDD","RR");
        System.out.println(connection.getClass());
        connection.close();
    5，替换数据源
        （1）spring.datasource.type=com.zaxxer.hikari.HikariDataSource
        （2）排除Tomcat配置
          <!--<exclusions>-->
                  <!--<exclusion>-->
                      <!--<groupId>org.apache.tomcat</groupId>-->
                      <!--<artifactId>tomcat-jdbc</artifactId>-->
                  <!--</exclusion>-->
          <!--</exclusions>-->
           引入其他数据源
           <!--<dependency>-->
                   <!--<groupId>com.zaxxer</groupId>-->
                   <!--<artifactId>HikariCP</artifactId>-->
                   <!--<version>3.2.0</version>-->
            <!--</dependency>-->
    6.支持的数据源         
          
            DataSourceConfiguration.Hikari.class, DataSourceConfiguration.Tomcat.class,
			DataSourceConfiguration.Dbcp2.class, DataSourceConfiguration.Generic.class,
			DataSourceJmxConfiguration.class
  事物
     
     1.@EnableTransactionManagement 
     2.在使用的方法上@Transactional配置 
        默认运行时异常生效 
        rollbackFor 指定异常的事物生效
        noRollbackFor排除异常事物生效
        不支持事物的方法为私有
       
  镜像数据库MySQL
    
    