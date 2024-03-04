package net.houmaiza.accountservice;

import net.houmaiza.accountservice.clients.CustomerRestClient;
import net.houmaiza.accountservice.entities.BankAccount;
import net.houmaiza.accountservice.enums.AccountType;
import net.houmaiza.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository , CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.customerFindAll().forEach(customer -> {
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random()*40000)
                        .currency("MAD")
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .CustomerId(Long.valueOf(customer.getId()))
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .balance(Math.random()*60000)
                        .currency("MAD")
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .CustomerId(Long.valueOf(customer.getId()))
                        .build();
                bankAccountRepository.save(bankAccount1);
                bankAccountRepository.save(bankAccount2);
            });

        };

    }
}
