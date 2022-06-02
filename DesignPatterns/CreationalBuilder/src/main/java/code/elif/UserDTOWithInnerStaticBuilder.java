package code.elif;

import java.time.LocalDate;
import java.time.Period;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Product class
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class UserDTOWithInnerStaticBuilder {

	private String name;
	
	private String address;
	
	private String age;

	//Get builder instance
	public static UserDTOBuilder getBuilder() {
		return new UserDTOBuilder();
	}
	//Builder
	public static class UserDTOBuilder {
		
		private String firstName;
		
		private String lastName;
		
		private String age;
		
		private String address;
		
		private UserDTOWithInnerStaticBuilder userDTO;
		
		public UserDTOBuilder withFirstName(String fname) {
			this.firstName = fname;
			return this;
		}
		
		public UserDTOBuilder withLastName(String lname) {
			this.lastName = lname;
			return this;
		}
		
		public UserDTOBuilder withBirthday(LocalDate date) {
			age = Integer.toString(Period.between(date, LocalDate.now()).getYears());
			return this;
		}
		
		public UserDTOBuilder withAddress(Address address) {
			this.address = address.getHouseNumber() + " " +address.getStreet()
						+ "\n"+address.getCity()+", "+address.getState()+" "+address.getZipcode(); 

			return this;
		}
		
		public UserDTOWithInnerStaticBuilder build() {
			this.userDTO = new UserDTOWithInnerStaticBuilder();
			userDTO.setName(firstName+" " + lastName);
			userDTO.setAddress(address);
			userDTO.setAge(age);
			return this.userDTO;
		}
		
		public UserDTOWithInnerStaticBuilder getUserDTO2() {
			return this.userDTO;
		}
	}
}
