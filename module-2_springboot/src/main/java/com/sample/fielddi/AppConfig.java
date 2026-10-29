package com.sample.fielddi;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AppConfig {
    @AutoWired
    public String getAppConfig(){
        return "Hi from App config";
    }

}
