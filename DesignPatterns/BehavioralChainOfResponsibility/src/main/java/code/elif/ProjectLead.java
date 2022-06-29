package code.elif;

//A concrete handler
public class ProjectLead extends Employee {


    public ProjectLead(LeaveApprover successor) {
        super("ProjectLead", successor);
    }

    @Override
    protected boolean processRequest(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.Sick
                && application.getNoOfDays() <= 2) {
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }
}
