package code.elif.employee.visitor;

import code.elif.employee.Manager;
import code.elif.employee.Programmer;
import code.elif.employee.ProjectLead;
import code.elif.employee.VicePresident;

public interface Visitor {
    void visit(Programmer programmer);
    void visit(ProjectLead projectLead);
    void visit(Manager manager);
    void visit(VicePresident vicePresident);
}
