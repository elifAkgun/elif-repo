package code.elif.basic;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class AsyncProducerClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> record = new ProducerRecord<>("firstTopic",
                "message",
                "Hello Kafka!" + LocalDateTime.now());

        producer.send(record, (recordMetadata, e) -> {
            System.out.println("Message send successfully!");
            System.out.println("recordMetadata.offset() : " + recordMetadata.offset());
            System.out.println("recordMetadata.partition() : " + recordMetadata.partition());

            if (e != null) {
                e.printStackTrace();
            }
        });

        producer.close();
    }
}