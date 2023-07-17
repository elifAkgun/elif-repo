package code.elif.custom.consumer;

import code.elif.custom.model.TrackInfo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ObjectSerializationExampleConsumerClient {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "code.elif.serialization.TrackInfoDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "firstGroup");

        KafkaConsumer<String, TrackInfo> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singleton("trackTopic"));

        ConsumerRecords<String, TrackInfo> records = consumer.poll(Duration.ofSeconds(20));

        for (ConsumerRecord<String, TrackInfo> record : records) {
            System.out.println(record.key() + " " + record.value());
        }

        consumer.close();
    }
}