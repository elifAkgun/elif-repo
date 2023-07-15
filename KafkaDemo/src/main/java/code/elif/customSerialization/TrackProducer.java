package code.elif.customSerialization;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.UUID;

public class TrackProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", " code.elif.serialization.GenericSerializer");
        properties.setProperty("group.id", "firstGroup");

        TrackInfo trackInfo = TrackInfo.builder()
                .id(UUID.randomUUID().toString())
                .latitude("22.2232")
                .longitude("23.3534")
                .build();
        KafkaProducer<String, TrackInfo> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, TrackInfo> record = new ProducerRecord<>("trackTopic", trackInfo.getId(), trackInfo);
        producer.send(record);
        System.out.println("Message send successfully!");
        producer.close();
    }
}