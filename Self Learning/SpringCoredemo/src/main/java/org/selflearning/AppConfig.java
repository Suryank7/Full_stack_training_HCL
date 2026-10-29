package org.selflearning;

import org.selflearning.payment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.selflearning")
public class AppConfig
{
    @Bean
    public User createUser(){
        return new User("Raman",34);
    }

    @Bean
    public CartService createCartService(){
        return new CartService();
    }

    @Bean
    public PaymentService createCartPayment(){
        return new cardPayment();
    }

    @Bean
    public OrderService createOrder(){
        return new OrderService();
    }
    //empty
}
