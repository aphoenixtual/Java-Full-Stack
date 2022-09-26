package com.example.repository;


import com.example.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Component
@Qualifier("jpa")
public class JpaAccountRepository implements  AccountRepository{

    /*
    Here special annotation called PersistenceContext so spring will understand this annotation,
    so it will obtain one entity manager from the entity manager factory and will inject OK in this place.
     */
    @PersistenceContext
    private EntityManager entityManager;

    public JpaAccountRepository() {
        log.info("JdbcAccountRepository instance created...");
    }

    /*
    So we are loading account from the database based on that account number using this entity manager. Also, we are updating.
    This detached account back to the database
     */
    public Account load(String number) {
        log.info("loading account " + number);
        return entityManager.find(Account.class,number);
    }

    public void update(Account account) {
        log.info("updating account " + account.getNumber());
        entityManager.merge(account);
    }

}