package code.elif.threads.throughtput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class WordCountController implements HttpHandler {

    private String text;

    public WordCountController(String text) {
        this.text = text;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String query = httpExchange.getRequestURI().getQuery();
        String [] keyValue = query.split("=");
        String action = keyValue[0];
        String searchWord = keyValue[1];

        if(!action.equals("word")){
            httpExchange.sendResponseHeaders(400,0);
            return;
        }

        long count = countWord(searchWord);

        byte [] response = Long.toString(count).getBytes();
        httpExchange.sendResponseHeaders(200,response.length);
        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response);
        outputStream.close();


    }

    private long countWord(String searchWord) {
        long count =0;
        int index =0;

        while (index>=0){
            index = text.indexOf(searchWord,index);
            if(index>=0) {
                count++;
                index++;
            }
        }
        return count;
    }
}
