package com.elif.event;

import java.math.BigDecimal;
import java.util.Date;

import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentEvent {
	public String paymentType;
    public BigDecimal value;
    public Date datetime;
    
    public void creditPayment(@Observes @Credit PaymentEvent event) {
        System.out.println("Credit payment");
    }

    public void debitPayment(@Observes @Debit PaymentEvent event) {
    	System.out.println("Debit payment");
    }
    
    
    public void debitPayment2(@ObservesAsync @Debit PaymentEvent event) {
    	System.out.println("Debit (@ObservesAsync) payment");
    }
}
