package code.elif;

import org.apache.commons.text.StringEscapeUtils;

import java.io.*;

//Decorator. Implements component interface
public class HtmlEncodedMessage implements Message {

    private Message message;

    public HtmlEncodedMessage(Message msg) {
        this.message = msg;
    }

    @Override
    public String getContent() {
        return StringEscapeUtils.escapeHtml4(message.getContent());
    }

    public static void main(String[] args) {
        try (OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream("code.txt"))) {
            outputStream.write("Hello".getBytes());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
