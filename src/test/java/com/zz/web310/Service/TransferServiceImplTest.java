package com.zz.web310.Service;

import com.zz.web310.RunTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TransferServiceImplTest extends RunTest {
    @Autowired
    private ITransferService transferService;

    @Test
    public void transBalance() throws Exception {
        transferService.transBalance();
    }
}