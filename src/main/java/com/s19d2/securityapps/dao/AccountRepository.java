package com.s19d2.securityapps.dao;

import com.s19d2.securityapps.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
