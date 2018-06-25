package com.qa.server2;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountApplication {
	
	private int accountNumber = 1000;


	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(AccountRepository repository) {
        return args -> {
            Stream.of("Ben", "Jack", "Harry").forEach(name -> {
            	Stream.of("Smith", "Jones", "Baker").forEach(lastName -> {
                Account account = new Account();
                account.setFirstName(name);
                account.setLastName(lastName);
                account.setAccountNumber(accountNumber);
                accountNumber+=463;
                repository.save(account);});
            });
            repository.findAll().forEach(System.out::println);
        };
    }
	
}
