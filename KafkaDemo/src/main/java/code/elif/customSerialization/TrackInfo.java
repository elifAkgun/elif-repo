package code.elif.customSerialization;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TrackInfoCustom {

    private String id;
    private String latitude;
    private String longitude;
}
