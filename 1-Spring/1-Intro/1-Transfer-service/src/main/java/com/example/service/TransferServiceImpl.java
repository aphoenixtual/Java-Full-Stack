package com.example.service;
/*
 service layer where we can have our business logic
 */

import com.example.model.Account;
import com.example.repository.JdbcAccountRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransferServiceImpl {

    public TransferServiceImpl() {
        log.info("TransferServiceImpl instance created...");
    }

    public void transfer(double amount, String fromAccNum, String toAccNum) {

        log.info("transfer initiated.");

        //This is that one evil line making all the issues so never do this.
        JdbcAccountRepository accountRepository = new JdbcAccountRepository();

        //So debiting the money from the account and crediting the money to the target account.
        Account fromAccount = accountRepository.load(fromAccNum);
        Account toAccount = accountRepository.load(toAccNum);

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        //And updating on both accounts and transfer now successfully finished.
        accountRepository.update(fromAccount);
        accountRepository.update(fromAccount);

        log.info("transfer finished.");

    }

}