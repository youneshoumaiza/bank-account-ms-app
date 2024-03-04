package net.houmaiza.customerservice.repository;

import net.houmaiza.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository< Customer , Long> {

}
