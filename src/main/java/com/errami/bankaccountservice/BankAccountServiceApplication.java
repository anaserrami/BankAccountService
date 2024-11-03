package com.errami.bankaccountservice;

import com.errami.bankaccountservice.entities.BankAccount;
import com.errami.bankaccountservice.entities.Customer;
import com.errami.bankaccountservice.enums.AccountType;
import com.errami.bankaccountservice.repositories.BankAccountRepository;
import com.errami.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Mohamed", "Ali", "Anas", "Imane").forEach(c -> {
                Customer customer = Customer.builder()
                        .id(UUID.randomUUID().toString())
                        .name(c)
                        .build();
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVINGS_ACCOUNT)
                            .balance(10000+Math.random()*9000)
                            .currency("MAD")
                            .createdAt(new Date())
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            });
        };
    }
}
