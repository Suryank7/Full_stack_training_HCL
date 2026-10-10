package com.abstractt.demo;

interface Printable{
    void print();
}

class Document implements Printable{
    @Override
    public void print(){
        System.out.println("Hello");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        Printable obj = new Document();
        obj.print();
    }
}
