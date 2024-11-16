package com.accessbank.ingressmsspringboot.model;

public class Class implements Interface
{
    @Override
    public void test() {
        System.out.println("TEST method");
    }

    public static void main(String[] args) {
        Class aClass = new Class();
        aClass.test();
        aClass.defaultMethod();
        Interface.staticMethod();
    }
}
