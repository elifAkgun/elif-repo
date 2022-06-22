package code.elif;

public class Client {

    public static void main(String[] args) {
        Message m = new TextMessage("The <FORCE> is strong with this one!");
        System.out.println(m.getContent());

        HtmlEncodedMessage htmlEncodedMessage = new HtmlEncodedMessage(m);
        System.out.println(htmlEncodedMessage.getContent());

        Base64EncodedMessage base64EncodedMessage = new Base64EncodedMessage(htmlEncodedMessage);
        System.out.println(base64EncodedMessage.getContent());

    }
}
