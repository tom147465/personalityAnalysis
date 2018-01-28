package com.zz.web310.Service;

import com.zz.web310.entity.AccountBalance;
import com.zz.web310.repo.AccountBalanceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BalanceServiceImpl implements IBalanceService {

    private Logger LOGGER = LoggerFactory.getLogger(BalanceServiceImpl.class);

    @Autowired
    private AccountBalanceRepo accountBalanceRepo;

    @Override
    public AccountBalance deposit(String accountName, BigDecimal amount) {
        // formatter string.format(), e.g.  String.format("..%s.", "XXXX"), same with C Language
        // {} === String.format(%s object.toString) 不是真的toString , logback 自动遍历(基础类型)
        LOGGER.info("Now, deposit [{}]'s account, amount=[{}]", accountName, amount.doubleValue());
        AccountBalance accountBalance = accountBalanceRepo.findByAccountName(accountName);
        BigDecimal balance = accountBalance.getBalance();
        balance = balance.add(amount);
        accountBalance.setBalance(balance);
        accountBalance = accountBalanceRepo.save(accountBalance);
        LOGGER.info("Now, deposit [{}]'s account, amount=[{}] done.", accountName, amount.doubleValue());
        return accountBalance;
    }

    @Override
    public AccountBalance withdraw(String accountName, BigDecimal amount) {
        LOGGER.info("Now, withdraw [{}]'s account, amount=[{}]", accountName, amount.doubleValue());
        AccountBalance accountBalance = accountBalanceRepo.findByAccountName(accountName);
        BigDecimal balance = accountBalance.getBalance();
        balance = balance.subtract(amount);
        accountBalance.setBalance(balance);
        accountBalance = accountBalanceRepo.save(accountBalance);
        LOGGER.info("Now, withdraw [{}]'s account, amount=[{}] done.", accountName, amount.doubleValue());
        return accountBalance;
    }
}