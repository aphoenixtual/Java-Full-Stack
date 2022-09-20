package com.example;

//this application is going to be console based application
import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
Always remember any project you develop split the project into three phases.
We just call initialization phase are boot face. This is fair spring boot comes.
So every application should get ready to serve.
Then application should Serve to the user and if application is no more required should get now destroyed.
So any project you develope, any microservices, now you're going to develop in future.
They always the case should be in these three phases.
Mostly in the initialization phase.
Based on an old configuration,
Components Should be ready, right to Serve
That is what boot face is all about.
So depends on the configuration. All your components OK should be ready to serve.
 */
public class Application {
    public static void main(String[] args) {

        // init / boot phase
        //Transfer service component that should be ready to serve.
        System.out.println("-".repeat(150));
        //when your application on getting boot and you need to create all the components, and we need to wire up the components.
        //AccountRepository accountRepository = new JdbcAccountRepository();
        /*
        And this dependency
        Should be injected now here, This is the call DI dependency injected to the dependent.
         */
        //TransferService transferService = new TransferServiceImpl(accountRepository); //DI
        /*
        In Spring,Group of all the components build together, it is called application context.
         */
        ConfigurableApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("transfer-service.xml");
        System.out.println("-".repeat(150));

        // use phase
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer(1000.00, "1", "2");
        System.out.println("-".repeat(125));
        transferService.transfer(1000.00, "2", "1");


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