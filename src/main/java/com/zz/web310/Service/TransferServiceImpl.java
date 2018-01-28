package com.zz.web310.Service;
import com.zz.web310.entity.AccountBalance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ImageBanner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferServiceImpl implements ITransferService {


    private  Logger LOGGER = LoggerFactory.getLogger(TransferServiceImpl.class);


    @Autowired
    private IBalanceService balanceService;

    @Override
    public void transBalance() {
        LOGGER.info("Start to transfer");
        AccountBalance zz = balanceService.deposit("zz", new BigDecimal("10"));
        LOGGER.info("In the middle");

        balanceService.withdraw("qk", new BigDecimal("10"));
        LOGGER.info("Transfer ends");
    }
}
