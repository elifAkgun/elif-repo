package code.elif.externalservice;

import java.util.concurrent.ExecutorService;

public class AggregatorService {

    private final ExecutorService executor;

    public AggregatorService(ExecutorService executor) {
        this.executor = executor;
    }

    public ProductDto getProductDto(int id) throws Exception {
        var product = executor.submit(() -> Client.getProduct(id));
        var rating = executor.submit(() -> Client.getRating(id));

        return new ProductDto(id, product.get(), rating.get());
    }
}
