package code.elif.app.features.java11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.net.http.HttpRequest.newBuilder;

public class HTTPClientExample {

    private static final String API_URI = "https://www.boredapi.com/api/activity";

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        getAsyncRequestJava11();
    }

    private static void getAsyncRequestJava11() throws IOException, InterruptedException, ExecutionException {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .build();

        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(API_URI))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> completableFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Request sent...");
        completableFuture.thenApply(HttpResponse::body).exceptionally(ex-> "Something went wrong...")
                .thenAccept(System.out::println);
        completableFuture.join();
        System.out.println("Request processed...");

    }

    private static void getRequestJava11() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(API_URI))
                .GET()
                .build();
        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (httpResponse.statusCode() == 200)
            System.out.println(httpResponse.body());
    }




    private static void getRequestBeforeJava11() throws IOException {
        var url = new URL(API_URI);
        var httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        if (httpURLConnection.getResponseCode() == 200) {
            System.out.println(readResponse(httpURLConnection.getInputStream()));
        } else {
            System.out.println("Something went wrong...");
        }
    }

    private static String readResponse(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String response = "";
        String line;
        while ((line = reader.readLine()) != null) {
            response += line;
        }
        return response;
    }

}
