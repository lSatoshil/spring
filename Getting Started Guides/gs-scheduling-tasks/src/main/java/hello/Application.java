package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableScheduling 开启定时任务，确保任务执行器可以在后台执行
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
