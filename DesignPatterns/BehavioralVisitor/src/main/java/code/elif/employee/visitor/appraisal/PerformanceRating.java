package code.elif.employee.visitor.appraisal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceRating {

	private int id;
	
	private int personalRating;
	
	private int teamAverageRating;
	
	private int finalRating;

	public PerformanceRating(int id, int personalRating) {
		this.id = id;
		this.personalRating = personalRating;
	}

}
