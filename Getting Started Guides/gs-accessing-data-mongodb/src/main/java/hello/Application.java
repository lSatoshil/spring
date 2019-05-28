package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        //保存数据
        repository.save(new Customer("Alice","Smith"));
        repository.save(new Customer("Bob","Smith"));

        //查询所有的数据
        logger.info("Customers found with findAll():");
        logger.info("-------------------------------");
        for (Customer customer : repository.findAll()) {
            logger.info(customer.toString());
        }
        logger.info("");

        //条件查询
        logger.info("Customer found with findByFirstName('Alice'):");
        logger.info("--------------------------------");
        logger.info(repository.findByFirstName("Alice").toString());

        logger.info("Customers found with findByLastName('Smith'):");
        logger.info("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            logger.info(customer.toString());
        }
    }
}
