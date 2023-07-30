package code.elif.consumer;

import code.elif.model.TrackInfo;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class ManuelAsyncCommitConsumerClient {

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

                for (ConsumerRecord<String, TrackInfo> record : records) {
                    System.out.println(record.key() + " " + record.value());
                }
                consumer.commitAsync(new OffsetCommitCallback() {
                    @Override
                    public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {

                    }
                });
            }
        } finally {
            consumer.close();
        }
    }
}
