package code.elif;

import code.elif.employee.*;
import code.elif.employee.visitor.appraisal.AppraisalVisitor;
import code.elif.employee.visitor.print.PrintVisitor;
import code.elif.employee.visitor.Visitor;

public class Client {

    public static void main(String[] args) {
        Employee vicePresident = buildOrganization();
        Visitor visitor = new PrintVisitor();
		visitOrgStructure(vicePresident,visitor);
    }

    private static void visitOrgStructure(Employee employee, Visitor visitor) {
        employee.accept(visitor);
        employee.getDirectReports()
				.forEach(emp -> visitOrgStructure(emp, visitor));
    }

    private static Employee buildOrganization() {

        Programmer p1 = new Programmer("Rachel", "C++");
        p1.setPerformanceRating(7);

        Programmer p2 = new Programmer("Andy", "Java");
        p2.setPerformanceRating(8);

        Programmer p3 = new Programmer("Josh", "C#");
        p3.setPerformanceRating(9);

        Programmer p4 = new Programmer("Bill", "C++");
        p4.setPerformanceRating(7);

        ProjectLead pl1 = new ProjectLead("Tina", p1, p2);
        pl1.setPerformanceRating(6);

        ProjectLead pl2 = new ProjectLead("Joey", p3, p4);
        pl2.setPerformanceRating(7);

        Manager m1 = new Manager("Chad", pl1);
        m1.setPerformanceRating(5);

        Manager m2 = new Manager("Chad II", pl2);
        m2.setPerformanceRating(3);

        VicePresident vp = new VicePresident("Richard", m1, m2);
        vp.setPerformanceRating(4);

        return vp;
    }


}
