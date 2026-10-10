package com.abstractt.demo;

abstract class A {
   abstract  void m1();
   abstract  int m2();

    static void main(String[] args) {
        A obj= new B();
        obj.m1();
        System.out.println(obj.m2());
    }
}

 class B extends A{
    void m1(){
        System.out.println("Hi");
    }
    int m2(){
        return 10;
    }
}



