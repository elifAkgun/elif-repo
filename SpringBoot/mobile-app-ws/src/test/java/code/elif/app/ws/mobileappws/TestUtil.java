package code.elif.app.ws.mobileappws;

import code.elif.app.ws.mobileappws.model.UserDTO;

public class TestUtil {

	public static UserDTO crateValidUser() {
		UserDTO user = new UserDTO();
		user.setName("test-user");
		user.setLastName("test-display");
		user.setUserId("asAS1234");
		user.setEmail("profile-image@dsad.com");
		return user;
	}
	
	public static UserDTO crateValidUser(String username) {
		UserDTO user = crateValidUser();
		user.setName(username);
		return user;
	}
}
