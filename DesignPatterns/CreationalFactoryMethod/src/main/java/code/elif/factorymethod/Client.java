package code.elif.factorymethod;


import code.elif.factorymethod.message.Message;

public class Client {

	public static void main(String[] args) {
		printMessage(new JSONMessageCreator());
		
		printMessage(new TextMessageCreator());
	}

	public static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg.getContent());
	}
}
