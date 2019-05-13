package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    //Spring Boot 支持内存中的关系数据库引擎 H2 ,并自动创建
    //@Autowired JdbcTemplate 字段自动加载 JdbcTemplate 并使其可用
    //Application 实现 Spring Boot 的 CommandLineRunner ，这意味着在加载完后会自动执行 run 方法

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Create tables");

        jdbcTemplate.execute("DROP TABLE  customers IF EXISTS ");
        jdbcTemplate.execute("CREATE TABLE customers("+
                " id SERIAL,first_name VARCHAR(255), last_name VARCHAR(255)) ");

        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        splitUpNames.forEach(name -> logger.info(String.format("Inserting customer record for %s %s",name[0],name[1])));

        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name,last_name) values(?,?)",splitUpNames);
        //插入多条数据使用 batchUpdate 比较好
        //使用 ？ 参数避免 SQL 注入攻击

        logger.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query("SELECT id,first_name,last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
        (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> logger.info(customer.toString()));
    }
}
