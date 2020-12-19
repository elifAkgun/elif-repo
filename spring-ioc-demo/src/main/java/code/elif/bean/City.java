package code.elif.bean;

import code.elif.service.MyService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class City {

	@NonNull
	private String cityName;
	
	@NonNull
	private String postalCode;
	
	private int population;
	
	private String favoritePlace;
	
	@NonNull
	private MyService myService;

	public void getMyInfo() {
		System.out.println(this);
		myService.getMyInfo();
	}

}
