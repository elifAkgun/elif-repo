package code.elif.threads.throughtput;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

//7
public class ThroughputHttpServer {

    private static String INPUT_FILE = "resources/war_and_peace.txt";
    private static int THREAD_NUMBER = 4;


    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

    private static void startServer(String text) throws IOException {
        HttpServer httpsServer = HttpServer.create(new InetSocketAddress(8080),0);
        httpsServer.createContext("/search", new WordCountController(text));
        Executor executor = Executors.newFixedThreadPool(THREAD_NUMBER);
        httpsServer.setExecutor(executor);
        httpsServer.start();
    }
}
