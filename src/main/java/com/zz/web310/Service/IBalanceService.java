package com.zz.mall.service.balance;

import com.zz.mall.entity.AccountBalance;

import java.math.BigDecimal;

public interface IBalanceService {
    AccountBalance deposit(String accountName, BigDecimal amount);
    AccountBalance withdraw(String accountName, BigDecimal amount);
}
