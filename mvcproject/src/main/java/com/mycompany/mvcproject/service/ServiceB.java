package com.mycompany.mvcproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ServiceB {

    @Autowired
    private ServiceA serviceA;

    @Autowired
    public ServiceB(@Lazy ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Autowired
    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void methodB(){
        System.out.println("method in ServiceB");
        serviceA.methodA();
    }
}
