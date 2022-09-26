package com.example.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@Import(value = {DataSourceConfiguration.class})
public class JpaConfiguration {

    private DataSource dataSource;

    @Autowired
    //Without data source to be in JPA, configuration cannot happen, so we'll look constructor level dependency injection.
    public JpaConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    /*
    In JPA, all database operations can be performed with one object call entity manager.
    We can obtain this entity manager from Entity manager factory.
    this bean is now called as so entity Manager factory being.
    We need to inject their data source bean to this entity manager factory. We have to specify where our models are...
    Uh, entities are...
    Then who is our JPA provider?
    Hibernate it is our JPA provider
     */
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[] { "com.example.entity" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    /*
    We do the transaction management.You were saying one more special instance called transaction manager.
    Even this transaction manager is also based on this entity manager factory.
    Again, this entity manager factory is on based on data source.

    Did you see? Transaction manager also works based on the entity manager factory.
     */
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    /*
     if you want to perform database operations we need entity manager
     we can obtain it from here And EntityManagerFactory we can create from data source
     */

    /*
    sometimes now databases will throw the different SQL exceptions. Oracle will throw different exceptions.
    My SQL will throw the different exception classes.
    We need to translate all the DBMS specific you know, SQL exceptions to.
    Spring data access exceptions. For that we need one more bean.
    Bean called...
    PersistenceExceptionTranslationPostProcessor
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        //properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        //properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }


}