package code.elif.externalservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AggregatorService {

    private final ExecutorService executor;

    public AggregatorService(ExecutorService executor) {
        this.executor = executor;
    }

    public ProductDTO getProduct(int id) throws Exception {
        Future<String> productFuture = executor.submit(() -> Client.callProductService(id));
        Future<Integer> ratingFuture = executor.submit(() -> Client.callRatingService(id));

        String productDescription = productFuture.get(2, TimeUnit.SECONDS);
        int rating = ratingFuture.get(2, TimeUnit.SECONDS);

        return new ProductDTO(id, productDescription, rating);
    }
}
