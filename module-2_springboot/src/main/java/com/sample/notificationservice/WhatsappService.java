package com.sample.notificationservice;

@Component
public class WhatsappService implements NotificationService{
    @Override
    public void sendMsg(String Msg){
        System.out.println("Whatsapp service is running");
    }
}
