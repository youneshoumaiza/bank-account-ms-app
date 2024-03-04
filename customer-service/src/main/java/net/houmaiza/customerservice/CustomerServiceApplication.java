package net.houmaiza.customerservice;

import net.houmaiza.customerservice.config.GlobalConfig;
import net.houmaiza.customerservice.entities.Customer;
import net.houmaiza.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> CustomerList=List.of(
                    Customer.builder()
                            .firstName("ahmed")
                            .lastName("naja")
                            .email("naja@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("sami")
                            .lastName("radi")
                            .email("radi@gmail.com")
                            .build()
            );

            customerRepository.saveAll(CustomerList);
        };
    }
}
