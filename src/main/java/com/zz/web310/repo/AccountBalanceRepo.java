package com.zz.web310.repo;

import com.zz.web310.entity.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountBalanceRepo extends JpaRepository<AccountBalance, Integer> {
    AccountBalance findByAccountName(String accountName);
}


