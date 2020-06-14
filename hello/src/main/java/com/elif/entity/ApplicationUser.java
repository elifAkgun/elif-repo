package com.elif.entity;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = ApplicationUser.FIND_USER_BY_CREDENTIALS, query = "select u from ApplicationUser  u where  u.email = :email")
@Table(name = "app_user" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
public class ApplicationUser extends AbstractEntity{

    public static final String FIND_USER_BY_CREDENTIALS = "User.findUserByCredentials";

    @NotEmpty(message = "Email must be set")
    @Email(message = "The email must be in the form user@domain.com")
    @Named("email")
    private String email;

    @Transient
    @Named ("password")
    @NotEmpty(message = "Password must be set")
    private String password;
    
    
    @Named ("hashed_password")
    private String hashedPassword;
    
    
    private String salt;
}
