package com.elif.jpa;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AttributeOverride(name="id", column = @Column(name = "bank_id"))
@Table(name = "bank")
public class Bank extends AbstractEntity {

	@Column(name = "name")
	private String name;
	
	@ManyToMany
    @JoinTable(name = "customer_bank",
        joinColumns = @JoinColumn(name = "bank_id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "bank")
	private List<Payment> payments;
}
