package org.selflearning;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    OrderService orderService;

    public PaymentService(OrderService orderService) {
        this.orderService = orderService;
    }
    public void play(){
        System.out.println("Payment done");
    }
    orderService.getOrderDetails();
}
