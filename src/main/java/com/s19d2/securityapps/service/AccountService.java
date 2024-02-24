package com.s19d2.securityapps.service;

import com.s19d2.securityapps.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account save(Account account);

}
