package code.elif.app.ws.mobileappws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull(message = "id cannot null")
    private String id;
    @NotNull(message = "name cannot null")
    private String name;
    @NotNull(message = "lastName cannot null")
    private String lastName;
}
