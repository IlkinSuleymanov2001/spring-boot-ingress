package com.accessbank.ingressmsspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
/*
        ApplicationContext context =
        new AnnotationConfigApplicationContext(ComputerConfiguration.class);

        ComputerFactory bean = context.getBean(ComputerFactory.class);
        System.out.println(bean);
        Computer bean2 = context.getBean(Computer.class);
        System.out.println(bean2);
        Computer bean3 = context.getBean(Computer.class);
        System.out.println(bean3);*/

    }

}
