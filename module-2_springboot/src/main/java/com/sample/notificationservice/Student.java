package com.sample.notificationservice;

@Component
public class Student {
    public NotificationService notificationService;

    @AutoWired
    public Student(NotificationService notificationService){
        this.NotificationService = notificationService;
    }
    public void notifyStudent(){
        notificationService.sendMsg("Your assessment is complete");
    }
}

