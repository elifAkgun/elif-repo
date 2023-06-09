package code.elif.example.tracking;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TrackInfo {

    private String id;
    private String latitude;
    private String longitude;
}
