package code.elif.externalservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ClientForWorkingParallelApp {

    private static final Logger logger = LoggerFactory.getLogger(ClientForWorkingParallelApp.class);

    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var aggregatorService = new AggregatorService(executor);

            List<Future<ProductDto>> futureList =
                    IntStream.range(1, 30)
                            .mapToObj(i -> executor.submit(() -> aggregatorService.getProductDto(i))).toList();

            List<ProductDto> productDtoList = futureList.stream().map(ClientForWorkingParallelApp::getProductDto).toList();

            logger.info(productDtoList.toString());
        }
    }

    private static ProductDto getProductDto(Future<ProductDto> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
