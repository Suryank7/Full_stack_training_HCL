package org.selflearning;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    private OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.pay();

        System.out.println("Order Placed");
    }
    public void getOrderDetails(){
        System.out.println("Order Details");
    }
}

