package com.s19d2.securityapps.controller;

import com.s19d2.securityapps.entity.Account;
import com.s19d2.securityapps.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @PostMapping
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

}
