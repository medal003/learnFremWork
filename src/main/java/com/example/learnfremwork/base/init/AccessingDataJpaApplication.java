package com.example.learnfremwork.base.init;

import com.example.learnfremwork.model.po.CustomerPo;
import com.example.learnfremwork.model.repo.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.Optional;


/**
 * comment: 定制化启动类 <br/>
 * @author medal <br/>
 * date:  2020/2/10/0010 9:46 <br/>
 */
//@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.learnfremwork.**")  /**默认扫描启动类的同级及以下包中的repo */
@ComponentScan("com.example.learnfremwork.**") // 加载在启动类上才有效
@EnableSwagger2
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo( CustomerRepo repository) {
        return (args) -> {
            // save a few customers
            repository.save(new CustomerPo("Jack", "张三",new Date()));
            repository.save(new CustomerPo("Chloe", "O'Brian",new Date()));
            repository.save(new CustomerPo("Kim", "Bauer",new Date()));
            repository.save(new CustomerPo("David", "Palmer",new Date()));
            repository.save(new CustomerPo("Michelle", "Dessler",new Date()));
            repository.save(new CustomerPo("Michelle", "Dessler",new Date()));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (CustomerPo customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Optional<CustomerPo> customer = repository.findById(1L);
            log.info("CustomerPo found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("CustomerPo found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
            // for (CustomerPo bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}