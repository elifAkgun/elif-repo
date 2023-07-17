package code.elif.custom.producer;

import code.elif.custom.model.TrackInfo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

public class CustomPartitionerProducerClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(VALUE_SERIALIZER_CLASS_CONFIG, " code.elif.serialization.GenericSerializer");
        properties.setProperty(PARTITIONER_CLASS_CONFIG, "code.elif.partitioner.CustomPartitioner");
        properties.setProperty(ACKS_CONFIG, "all");
        properties.setProperty(BUFFER_MEMORY_CONFIG, "231");
        properties.setProperty(COMPRESSION_TYPE_CONFIG, "lz4");
        properties.setProperty(RETRIES_CONFIG, "1");
        properties.setProperty(RETRY_BACKOFF_MS_CONFIG, "75");
        properties.setProperty(BATCH_SIZE_CONFIG, "2048");
        properties.setProperty(LINGER_MS_CONFIG, "2048");
        properties.setProperty(REQUEST_TIMEOUT_MS_CONFIG, "250");
        properties.setProperty(ENABLE_IDEMPOTENCE_CONFIG, "true");

        TrackInfo trackInfo = TrackInfo.builder()
                .id(UUID.randomUUID().toString())
                .latitude("37.2431")
                .longitude("115.793")
                .build();

        KafkaProducer<String, TrackInfo> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, TrackInfo> record = new ProducerRecord<>("OrderPartitionedTopic",
                trackInfo.getId(), trackInfo);
        producer.send(record, (recordMetadata, e) -> {
            System.out.println("Message send successfully! Partition Number : "
                    + recordMetadata.partition());

        });
        producer.close();
    }
}