package com.elif.config.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class ApplicationState implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3026472979778703323L;
	private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
