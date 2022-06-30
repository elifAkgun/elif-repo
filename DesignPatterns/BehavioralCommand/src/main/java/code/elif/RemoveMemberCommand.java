package code.elif;
//A Concrete implementation of Command.
public class RemoveMemberCommand implements Command {

    private String emailAddress;
    private String contactGroup;
    private EWSService receiver;


    public RemoveMemberCommand(String emailAddress, String contactGroup, EWSService service) {
        this.emailAddress = emailAddress;
        this.contactGroup = contactGroup;
        this.receiver = service;
    }

    @Override
    public void execute() {
        receiver.removeMember(emailAddress,contactGroup);
    }
}

