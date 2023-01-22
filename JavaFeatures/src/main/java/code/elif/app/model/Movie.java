
package code.elif.app.features.java15.record.local;


import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @NonNull
    private String name;
    private List<String> cast;
    private LocalDate dateOfRelease;
    @NonNull
    private String director;
    private int rating;
    private long grossEarning;

}
