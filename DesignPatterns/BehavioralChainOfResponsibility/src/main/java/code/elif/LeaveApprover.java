package code.elif;

//This represents a handler in chain of responsibility
public interface LeaveApprover {
    public void processLeaveApplication(LeaveApplication application);
    public String getApproverRole();
}
