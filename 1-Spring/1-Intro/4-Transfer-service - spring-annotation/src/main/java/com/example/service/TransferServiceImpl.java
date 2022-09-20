package com.example.service;
/*
 service layer where we can have our business logic
 */

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransferServiceImpl implements TransferService {

    private AccountRepository accountRepository;
        /*
        we need the dependency here coz now we don't use that evil line
    So make sure you are using only abstraction type here, that's called an interface and we should ask someone to inject it.
    So mostly they are not dependencies not inject via constructor or through set methods.
    Constructor level dependencies now are the required Dependencies
    setter level dependencies know are that's OK even if they are not setting it.
         */

    //So at constructor level getting this dependency.
    //The dependency must be injected now here that's called auto wired.
    //Suggestion to the spring is injected, this dependency to this dependent
    @Autowired
    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository=accountRepository;
        log.info("TransferServiceImpl instance created...");
    }

    public void transfer(double amount, String fromAccNum, String toAccNum) {

        log.info("transfer initiated.");

        //This is that one evil line making all the issues so never do this.
        /*
        JdbcAccountRepository accountRepository = new JdbcAccountRepository();
         */

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