package com.sample.fielddi;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Employee {
    @Autowired
    public String getEmployee(){
        return "hi from employee";
    }
}
