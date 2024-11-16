package com.accessbank.ingressmsspringboot.model;

public interface Interface {

    void test();
    default  void defaultMethod(){
        System.out.println("default method");
    }

    static  void staticMethod(){
        System.out.println("static method");
    }

}
