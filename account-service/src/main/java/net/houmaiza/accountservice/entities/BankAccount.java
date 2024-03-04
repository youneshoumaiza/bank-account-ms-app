package net.houmaiza.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.houmaiza.accountservice.enums.AccountType;
import net.houmaiza.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private String currency;
    private LocalDate createAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long CustomerId;
}
