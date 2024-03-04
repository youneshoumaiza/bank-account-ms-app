package net.houmaiza.accountservice.web;

import net.houmaiza.accountservice.clients.CustomerRestClient;
import net.houmaiza.accountservice.entities.BankAccount;
import net.houmaiza.accountservice.model.Customer;
import net.houmaiza.accountservice.repository.BankAccountRepository;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository AccountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository AccountRepository, CustomerRestClient customerRestClient) {
        this.AccountRepository = AccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> bankAccounts = AccountRepository.findAll();
        bankAccounts.forEach(bankAccount -> {
            bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        });
        return bankAccounts;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount=AccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }


}
