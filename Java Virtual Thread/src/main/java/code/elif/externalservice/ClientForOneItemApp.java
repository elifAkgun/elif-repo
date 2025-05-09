package code.elif.externalservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;

public class ClientForOneItemApp {

    private static final Logger logger = LoggerFactory.getLogger(ClientForOneItemApp.class);

    public static void main(String[] args) throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

            var aggregatorService = new AggregatorService(executor);
            ProductDTO productDto = aggregatorService.getProduct(1);

            logger.info("Product: {}", productDto);
        }
    }
}
