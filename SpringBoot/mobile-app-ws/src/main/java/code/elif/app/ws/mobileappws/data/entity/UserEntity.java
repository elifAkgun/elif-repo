package code.elif.app.ws.mobileappws.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50,unique = true)
    private String email;
    @Column(nullable=false, unique=true)
    private String encryptedPassword;}
