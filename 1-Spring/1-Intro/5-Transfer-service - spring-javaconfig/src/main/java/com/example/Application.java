package com.example;

import com.example.config.TransferServiceConfiguration;
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // init / boot phase
        //Using annotation config application context. So here we need to provide our configuration class
        ConfigurableApplicationContext applicationContext=null;
        applicationContext=new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);

        // use phase
        TransferService transferService=applicationContext.getBean("txrService",TransferService.class);
        transferService.transfer(1000.00, "1", "2");
        System.out.println();
        transferService.transfer(1000.00, "2", "1");

        // destroy phase
        transferService = null;


    }
}
