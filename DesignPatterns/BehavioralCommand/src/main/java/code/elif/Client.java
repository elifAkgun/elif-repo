package code.elif;

public class Client {

	public static void main(String[] args) throws InterruptedException {

		Command command = new AddMemberCommand("jane@code-elif.com",
				"coder", new EWSService());
		command.execute();

		
	}

}
