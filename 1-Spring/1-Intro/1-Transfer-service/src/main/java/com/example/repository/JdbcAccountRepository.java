package com.example.repository;


import com.example.model.Account;
import lombok.extern.slf4j.Slf4j;

@Slf4j
/*
I need this logging object so I have SLF4J as part of this application,
so this particular annotation will give this log object for us, so we could be able to log.
this JdbcAccountRepository() constructor is called, the intention is account repository instance now created,
load that account and also update the account
 */
public class JdbcAccountRepository {

    public JdbcAccountRepository() {
        log.info("JdbcAccountRepository instance created...");
    }

    public Account load(String number) {
        log.info("loading account " + number);
        return new Account(number, 1000.00);
    }

    public void update(Account account) {
        log.info("updating account " + account.getNumber());
    }

}