package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
          //保存一些 customer 数据
          repository.save(new Customer("Jack","Bauer"));
          repository.save(new Customer("Chloe", "O'Brian"));
          repository.save(new Customer("Kim", "Bauer"));
          repository.save(new Customer("David", "Palmer"));
          repository.save(new Customer("Michelle", "Dessler"));

          //查询所有的 customer
         logger.info("Customers found with findAll()");
         logger.info("--------------------------------");
         for (Customer customer : repository.findAll()){
             logger.info(customer.toString());
         }
         logger.info("");

         //通过 ID 查找用户
            repository.findById(1L)
                .ifPresent(customer -> {
                    logger.info("Customer found with findById(1L):");
                    logger.info("--------------------------------");
                    logger.info(customer.toString());
                    logger.info("");
                });
            //通过名字找 customer
            logger.info("Customer found with findByLastName('Bauer'):");
            logger.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                logger.info(bauer.toString());
            });

            logger.info("");
        };
    }
}
