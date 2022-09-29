package com.example;

import com.example.config.TransferServiceConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {

        // init / boot phase
        ConfigurableApplicationContext applicationContext=null;
        applicationContext=new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);

        System.out.println("-".repeat(150));

        // use phase
        TransferService transferService=applicationContext.getBean("txrService",TransferService.class);
        transferService.transfer(1000.00, "1", "2");
//        applicationContext.close();
//        transferService.transfer(1000.00, "2", "1");

        // destroy phase
        /*
         In this destroy phase. OK, maybe you can clean all the objects properly.
         This is one of the worst way.
         */
        System.out.println("-".repeat(150));
        applicationContext.close();
        System.out.println("-".repeat(150));



    }
}
