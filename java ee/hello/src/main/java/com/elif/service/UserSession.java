package com.elif.service;

import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import com.elif.entity.Bank;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Stateful
public class UserSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5668019149081738836L;
	
	private String userName;
	
	@PrePassivate
	private void passivate() {
		System.out.println("@PrePassivate->>> " + this.hashCode());
	}

	@PostActivate
	private void active() {
		System.out.println("@PostActivate->>> " + this.hashCode());
	}

	public List<Bank> getBanks() {
        return null;
    }
}
