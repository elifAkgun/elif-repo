package com.elif.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.elif.enums.PaymentType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment")
@AttributeOverride(name="id", column = @Column(name = "payment_id"))
public class Payment extends AbstractEntity {

	@Enumerated(EnumType.STRING) 
	@Column(name = "payment_type")
	private PaymentType paymentType;

	@Column(name = "value")
	private BigDecimal value;
	
	@Column(name = "pay_date")
	private LocalDate payDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id")
	private Bank bank;
	
}
