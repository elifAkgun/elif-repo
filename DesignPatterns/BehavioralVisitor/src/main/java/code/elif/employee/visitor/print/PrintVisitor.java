package code.elif.employee.visitor.print;

import code.elif.employee.Manager;
import code.elif.employee.Programmer;
import code.elif.employee.ProjectLead;
import code.elif.employee.VicePresident;
import code.elif.employee.visitor.Visitor;

public class PrintVisitor implements Visitor {

    @Override
    public void visit(Programmer programmer) {
        String msg = programmer.getName() + " is a "
                + programmer.getSkill()
                + " programmer.";

        System.out.println(msg);
    }

    @Override
    public void visit(ProjectLead projectLead) {
        String msg = projectLead.getName() + " is a project lead."
                + " with " + projectLead.getDirectReports().size()
                + " programmers reporting.";
        System.out.println(msg);

    }

    @Override
    public void visit(Manager manager) {
        String msg = manager.getName() + " is a manager."
                + " with " + manager.getDirectReports().size()
                + " leads reporting.";
        System.out.println(msg);
    }

    @Override
    public void visit(VicePresident vicePresident) {
        String msg = vicePresident.getName() + " is a vicePresident."
                + " with " + vicePresident.getDirectReports().size()
                + " managers reporting.";
        System.out.println(msg);
    }
}
