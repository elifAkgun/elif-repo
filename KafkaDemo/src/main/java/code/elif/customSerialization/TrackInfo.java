package code.elif.customSerialization;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrackInfo {

    private String id;
    private String latitude;
    private String longitude;
}
