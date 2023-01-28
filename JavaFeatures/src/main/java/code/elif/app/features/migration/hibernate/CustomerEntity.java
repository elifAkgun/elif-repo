package code.elif.app.features.migration.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerEntity implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

}