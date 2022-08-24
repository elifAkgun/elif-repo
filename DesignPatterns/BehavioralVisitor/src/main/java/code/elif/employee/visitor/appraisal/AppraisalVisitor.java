package code.elif.employee.visitor.appraisal;

import code.elif.employee.*;
import code.elif.employee.visitor.Visitor;
import lombok.Getter;

import java.util.HashMap;

public class AppraisalVisitor implements Visitor {

	private Ratings ratings = new Ratings();

	@SuppressWarnings("serial")
	public class Ratings extends HashMap<Integer, PerformanceRating> {
		public int getFinalRating(int empId) {
			return get(empId).getFinalRating();
		}
	}

	@Override
	public void visit(Programmer programmer) {
		calculateEmployeePerformance(programmer, 0.25f, 0.0f);
	}

	@Override
	public void visit(ProjectLead lead) {
		//25% team & 75% personal
		calculateEmployeePerformance(lead, 0.25f, 0.75f);
	}

	@Override
	public void visit(Manager manager) {
		//50% team & 50% personal
		calculateEmployeePerformance(manager, 0.50f, 0.50f);
	}

	@Override
	public void visit(VicePresident vp) {
		//75% team & 25% personal
		calculateEmployeePerformance(vp, 0.25f, 0.75f);
	}

	private void calculateEmployeePerformance(Employee emp, float performanceRating, float teamRating) {
		PerformanceRating finalRating = new PerformanceRating(emp.getEmployeeId(), emp.getPerformanceRating());
		int teamAverage = teamRating > 0 ? getTeamAverage(emp) : 0;
		int rating = Math.round(performanceRating * emp.getPerformanceRating() + teamRating * teamAverage);
		finalRating.setFinalRating(rating);
		finalRating.setTeamAverageRating(teamAverage);

		ratings.put(emp.getEmployeeId(),
				finalRating);
	}

	private int getTeamAverage(Employee emp) {
		return (int) Math.round(emp.getDirectReports().stream()
				.mapToDouble(e -> e.getPerformanceRating()).average().getAsDouble());
	}

	public Ratings getRatings() {
		return ratings;
	}
}
