package com.example;

//this application is going to be console based application
import com.example.service.TransferServiceImpl;
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
        TransferServiceImpl transferService = new TransferServiceImpl();
        System.out.println("-".repeat(150));

        // use phase
        transferService.transfer(1000.00, "1", "2");
        System.out.println("-".repeat(125));
        transferService.transfer(1000.00, "2", "1");


        // destroy phase
        /*
         In this destroy phase. OK, maybe you can clean all the objects properly.
         This is one of the worst way.
         */
        System.out.println("-".repeat(150));
        transferService = null;
        System.out.println("-".repeat(150));

    }
}