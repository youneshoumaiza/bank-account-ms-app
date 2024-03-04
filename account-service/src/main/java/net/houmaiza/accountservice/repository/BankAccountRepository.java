package net.houmaiza.accountservice.repository;

import net.houmaiza.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount , String> {

}
