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
    
     docker pull mysql 拉去镜像
     docker images 查看镜像
     docker run --name mysql -e MYSQL_ROOT_PASSWORD=123 -P 3306:3306 -d mysql
      –name：给新创建的容器命名，此处命名为pwc-mysql
      -e：配置信息，此处配置mysql的root用户的登陆密码
      -p：端口映射，此处映射主机3306端口到容器pwc-mysql的3306端口
      -d：成功启动容器后输出容器的完整ID，例如上图 73f8811f669ee...后台运行
      
     
       docker ps 默认显示当前正在运行中的container
       docker ps -a 查看包括已经停止的所有容器
       docker ps -l 显示最新启动的一个容器（包括已停止的）
       docker ps -s 查看正在运行的容器
       docker exec -it mysql bash 进去容器
       mysql -uroot -p -h localhost  以root用户名登录
       
   数据库操作
   
    use mysql 适应mysql数据库
    常见用户
    INSERT INTO user (host, user, password, select_priv, insert_priv, update_priv) 
               VALUES ('localhost', 'guest', 
               PASSWORD('guest123'), 'Y', 'Y', 'Y');
    SHOW DATABASES 查看数据库
    SHOW TABLES 查看表
    SHOW COLUMNS FROM 数据表:
    显示数据表的属性，属性类型，主键信息 ，是否为 NULL，默认值等其他信息。
    SHOW INDEX FROM 数据表:
    显示数据表的详细索引信息，包括PRIMARY KEY（主键）。
    
   
       