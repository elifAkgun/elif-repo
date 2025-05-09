package code.elif.externalservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Random;

public class Client {

    private Client() {
    }

    private static final Logger logger = LoggerFactory.getLogger(Client.class);
    private static final String PRODUCT_REQ = "http://localhost:7070/sec01/product/%d";
    private static final String RATING_REQ = "http://localhost:7070/sec01/rating/%d";

    private static final Random random = new Random();


    public static String callProductService(int id) {
        // Simulated external call - could be replaced with real HTTP call
        return "Product-" + id;
    }

    public static int callRatingService(int id) {
        // Simulated external call - could be replaced with real HTTP call
        return random.nextInt(5) + id;
    }

    public static String getProduct(int productId) {
        return externalService(String.format(PRODUCT_REQ, productId));
    }

    public static String getRating(int ratingId) {
        return externalService(String.format(RATING_REQ, ratingId));
    }

    private static String externalService(String url)  {
        logger.info("External Service URL: {}", url);
        try (var stream = URI.create(url).toURL().openStream()) {
            return new String(stream.readAllBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
