package code.elif.externalservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ClientForWorkingParallelApp {

    private static final Logger logger = LoggerFactory.getLogger(ClientForWorkingParallelApp.class);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        AggregatorService aggregator = new AggregatorService(executor);

        List<Future<ProductDTO>> futures = IntStream.rangeClosed(1, 50)
                .mapToObj(id -> executor.submit(() -> aggregator.getProduct(id)))
                .toList();

        List<ProductDTO> products = futures.stream()
                .map(ClientForWorkingParallelApp::toProduct)
                .toList();

        products.forEach(productDTO -> logger.info(productDTO.toString()));
    }

    private static ProductDTO toProduct(Future<ProductDTO> future) {
        try {
            return future.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

}
