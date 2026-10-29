package org.selflearning.payment;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentService {
    @Override
    public void pay() {
        System.out.println("pay via card");
    }
}
