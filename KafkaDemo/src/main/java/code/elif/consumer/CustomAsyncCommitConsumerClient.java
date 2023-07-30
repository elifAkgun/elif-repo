package code.elif.consumer;

import code.elif.model.TrackInfo;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class CustomAsyncCommitConsumerClient {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "code.elif.serialization.TrackInfoDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "firstGroup");
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        //properties.setProperty(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "6000");

        KafkaConsumer<String, TrackInfo> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singleton("trackTopic"));

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
                        consumer.commitAsync(Collections.singletonMap(
                                        new TopicPartition(record.topic(),
                                                record.partition()), new OffsetAndMetadata(record.offset() + 1)),
                                new OffsetCommitCallback() {
                                    @Override
                                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
                                        if (exception != null) {
                                            System.out.println("Commit failed for offset" + offsets);
                                        }
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
}

