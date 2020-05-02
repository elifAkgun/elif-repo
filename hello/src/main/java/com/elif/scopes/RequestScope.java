package com.elif.scopes;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@RequestScoped
public class RequestScope {

	public String getHashCode() {
		return this.getHashCode();
	}

	@Produces
	public List<String> getList() {
		List<String> list = new ArrayList<>();
		list.add("Elma");
		list.add("Armut");
		list.add("Kivi");
		return list;
	}
	
	public void dispose(@Disposes List<String> list) {
		list = null;
	}
}
