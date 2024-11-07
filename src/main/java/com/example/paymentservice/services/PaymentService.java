package com.example.paymentservice.services;

import com.example.paymentservice.paymentgateway.PaymentGateway;
import com.example.paymentservice.paymentgateway.PaymentGatewayChooserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    public String getPaymentLink(Long amount,String orderId,String phoneNumber,String name) {
        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.getPaymentGateway();
        return paymentGateway.getPaymentLink(amount, orderId, phoneNumber, name);
    }
}
