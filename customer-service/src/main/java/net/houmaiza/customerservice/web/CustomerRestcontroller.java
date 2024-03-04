package net.houmaiza.customerservice.web;

import net.houmaiza.customerservice.entities.Customer;
import net.houmaiza.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestcontroller {
    private CustomerRepository costumerRepository ;
    public CustomerRestcontroller(CustomerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @GetMapping("/customers")
    public List<Customer> customerList(){
        return costumerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
        return costumerRepository.findById(id).get();
    }

}
