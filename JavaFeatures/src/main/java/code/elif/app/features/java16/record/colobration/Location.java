package code.elif.app.features.java16.record;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location{

    private String country;
    private String city;
}