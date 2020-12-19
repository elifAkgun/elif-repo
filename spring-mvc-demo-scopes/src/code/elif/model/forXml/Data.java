package code.elif.model.forXml;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Data {
	
	@NonNull
	private Integer id;
	
	@NonNull
	private String  name;

}
