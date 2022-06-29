package code.elif;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class Client {



    public static void main(String[] args) {
        LeaveApplication application
                = new LeaveApplication(LeaveApplication.Type.Sick,
                LocalDate.of(2022, 6, 28),
                LocalDate.of(2022, 9, 3));

        LeaveApprover projectLead = createChain();
        System.out.println(application);
        System.out.println("**************************");
        projectLead.processLeaveApplication(application);
        System.out.println(application);
    }

    private static LeaveApprover createChain() {
        Director director = new Director(null);
        Manager manager = new Manager(director);
        ProjectLead projectLead = new ProjectLead(manager);

        return projectLead;
    }
}
