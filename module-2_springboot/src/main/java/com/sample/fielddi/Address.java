package com.sample.fielddi;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Address {
    public String getAddress(){
        return "hi from address";
    }
}
