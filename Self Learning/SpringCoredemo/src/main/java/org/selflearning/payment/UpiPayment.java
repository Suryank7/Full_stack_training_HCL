package org.selflearning.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UpiPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Paying by UPI");
    }
}
