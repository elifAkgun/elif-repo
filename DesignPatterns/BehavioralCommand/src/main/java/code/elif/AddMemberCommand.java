package code.elif;

//A Concrete implementation of Command.
public class AddMemberCommand implements Command {

    private String emailAddress;
    private String contactGroup;
    private EWSService receiver;


    public AddMemberCommand(String emailAddress, String contactGroup, EWSService service) {
        this.emailAddress = emailAddress;
        this.contactGroup = contactGroup;
        this.receiver = service;
    }


    @Override
    public void execute() {
        receiver.addMember(emailAddress,contactGroup);
    }
}
