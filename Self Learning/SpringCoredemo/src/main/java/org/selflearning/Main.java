package org.selflearning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String []args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

 OrderService order = context.getBean(OrderService.class);
 order.placeorder();

 User user  = context.getBean(User.class)
        System.out.println(user.getName());

// PaymentService payment = context.getBean(PaymentService.class);
// payment.pay();

    }
}
