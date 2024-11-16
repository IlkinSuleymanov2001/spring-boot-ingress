package com.accessbank.ingressmsspringboot.example.scope;

public class ComputerFactory {

    public Computer create(){
        return Computer.createNewComputer("lenova",1224.1f);
    }
}
