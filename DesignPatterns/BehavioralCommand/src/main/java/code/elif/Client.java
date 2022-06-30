package code.elif;

public class Client {

	public static void main(String[] args) throws InterruptedException {

		Command addMemberCommand = new AddMemberCommand("jane@code-elif.com",
				"coder", new EWSService());
		addMemberCommand.execute();

		Command removeMemberCommand = new RemoveMemberCommand("jane@code-elif.com",
				"coder", new EWSService());
		removeMemberCommand.execute();
	}

}
