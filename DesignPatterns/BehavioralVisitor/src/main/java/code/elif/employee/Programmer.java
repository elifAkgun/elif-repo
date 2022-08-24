package code.elif.employee;

import code.elif.employee.visitor.Visitor;
import lombok.Getter;

@Getter
public class Programmer extends AbstractEmployee {
	private String skill;
	
	public Programmer(String name, String skill) {
		super(name);
		this.skill = skill;
	}


	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
