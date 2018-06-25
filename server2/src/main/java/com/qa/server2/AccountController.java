package com.qa.server2;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


@RestController
public class AccountController {
	
	private AccountRepository repository;
	
    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/accounts")
    public Collection<Account> accounts() {
        return repository.findAll().stream()
              //  .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Account account) {
        return !account.getFirstName().equals("Ben") &&
                account.getFirstName().equals("Jack") &&
                !account.getFirstName().equals("Harry");
    }
    
    @PostMapping("/add-accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addAccount(@RequestBody String account) {
    	Account newAccount = new Gson().fromJson(account,Account.class);
    	repository.save(newAccount);
    }
    
    
}
    
