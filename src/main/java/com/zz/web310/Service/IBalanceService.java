package com.zz.web310.Service;

import com.zz.web310.entity.AccountBalance;

import java.math.BigDecimal;

public interface IBalanceService {
    AccountBalance deposit(String accountName, BigDecimal amount);
    AccountBalance withdraw(String accountName, BigDecimal amount);
}
