package code.elif.consumer;

import code.elif.model.TrackInfo;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;

public class RebalancedConsumerClient {

    public static void main(String[] args) {

        Properties properties = getConsumerProperties();

        KafkaConsumer<String, TrackInfo> consumer = new KafkaConsumer<>(properties);
        Map<TopicPartition, OffsetAndMetadata> currentOffset = new HashMap<>();

        consumer.subscribe(Collections.singleton("trackTopic"),
                new ConsumerRebalanceListener() {
                    @Override
                    public void onPartitionsRevoked(Collection<TopicPartition> collection) {
                        consumer.commitSync(currentOffset);
                    }

                    @Override
                    public void onPartitionsAssigned(Collection<TopicPartition> collection) {

                    }
                });

        try {
            while (true) {
                ConsumerRecords<String, TrackInfo> records = consumer.poll(Duration.ofSeconds(20));
                int count = 0;
                for (ConsumerRecord<String, TrackInfo> record : records) {
                    String customerName = record.key();
                    TrackInfo order = record.value();

                    System.out.println("Customer Name: " + customerName);
                    System.out.println("Latitude: " + order.getLatitude());
                    System.out.println("Longitude: " + order.getLongitude());
                    System.out.println("Partition: " + record.partition());

                    if (count % 10 == 0) {
                        currentOffset.put(new TopicPartition(record.topic(), record.partition()),
                                new OffsetAndMetadata(record.offset() + 1));

                        consumer.commitAsync(currentOffset,
                                (offset, exception) -> {
                                    if (exception != null) {
                                        System.out.println("Commit failed for offset" + offset);
                                    }
                                });
                        count++;
                    }
                }
            }
        } finally {
            consumer.close();
        }
    }

    private static Properties getConsumerProperties() {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "code.elif.serialization.TrackInfoDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "firstGroup");
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.setProperty(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, "1024");
        properties.setProperty(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, "200");

        properties.setProperty (ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "1MB");
        properties.setProperty (ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty (ConsumerConfig.CLIENT_ID_CONFIG, "OrderConsumer");
        properties.setProperty (ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "100");
        return properties;
    }
}