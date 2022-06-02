package code.elif;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//A product in builder pattern
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDTO {

    private String name;

    private String address;

    private String age;

}
