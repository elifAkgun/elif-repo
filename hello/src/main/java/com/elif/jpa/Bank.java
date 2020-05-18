package com.elif.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "customer_bank",
        joinColumns = @JoinColumn(name = "bank_id",referencedColumnName = "bank_id"),
        inverseJoinColumns =  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"))
	private Set<Customer> customers= new HashSet<>();
	

//	@OneToMany(mappedBy = "bank", cascade = CascadeType.PERSIST)
//	private List<Payment> payments;
}
