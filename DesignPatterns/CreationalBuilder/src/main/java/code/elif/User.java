package code.elif;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Entity class used to construct the DTO
@Getter
@Setter
public class User {

	private String firstName;

	private String lastName;

	private LocalDate birthday;

	private Address address;

}
