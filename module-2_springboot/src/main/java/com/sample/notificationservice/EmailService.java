package com.sample.notificationservice;

@Component
public class EmailService  implements NotificationService {
    @Override
    public void sendMsg(String Msg){
        System.out.println("Email Service is running");
    }
}
