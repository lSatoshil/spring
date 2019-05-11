package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication 注解包含以下注解
//@Configuration 将该类标记为定义应用程序上下文 bean 的来源
//@EnableAutoConfiguration 告诉 Spring Boot 基于 classpath 设置，其他 beans 和各种属性设置来添加 beans
//@ComponentScan 告诉 Spring 查找其他  components, configurations, 和 services在当前包下，允许他找到控制器（controllers）
//通常在 Spring MVC 中需要添加 @EnableWebMvc 注解，但是 Spring Boot 会自动添加当他在 classpath 上看到 spring-webmvc 时，这将应用程序标记为 web 应用程序，并激活关键行为，比如 DispatcherServlet
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
