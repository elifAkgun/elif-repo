package code.elif;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Represents a request in our chain of responsibility

public class LeaveApplication {

    public enum Type {Sick, PTO, LOP};

    public enum Status {Pending, Approved, Rejected};

    private Type type;

    private LocalDate from;

    private LocalDate to;

    private String processedBy;

    private Status status;

    public LeaveApplication(Type type, LocalDate from, LocalDate to) {
        this.type = type;
        this.from = from;
        this.to = to;
        this.status = Status.Pending;
    }

    public Type getType() {
        return type;
    }

    public long getNoOfDays() {
        return ChronoUnit.DAYS.between(from, to);
    }

    public void approve(String approverName) {
        this.status = Status.Approved;
        this.processedBy = approverName;
    }

    @Override
    public String toString() {
        return type + " leave for " + getNoOfDays() + " day(s) " + status
                + " by " + processedBy;
    }
}