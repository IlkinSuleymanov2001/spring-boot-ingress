package com.accessbank.ingressmsspringboot.example.scope;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ComputerConfiguration {

    @Bean("scope")
    public ComputerFactory getComputerFactory() {
        return new ComputerFactory();
    }

    @Bean
    public Computer getComputer(ComputerFactory computerFactory) {
        return computerFactory.create();
    }

}
