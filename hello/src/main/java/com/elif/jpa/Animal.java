package com.elif.jpa;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "animal")
@Getter
@Setter
@AttributeOverride(name="id", column = @Column(name = "animal_id"))
@Access(AccessType.FIELD)
public class Animal extends AbstractEntity {

	@Basic
	private String name;
	
	@Lob
	private byte[] picture;
	
	@Transient
	private int age;
	
	@Embedded
	private Address address;
	
	@Access(AccessType.PROPERTY)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}


