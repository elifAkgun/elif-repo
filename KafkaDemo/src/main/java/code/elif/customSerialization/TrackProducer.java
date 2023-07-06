package code.elif.example.custom;

import code.elif.example.tracking.TrackInfo;
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

        TrackInfoCustom trackInfo = TrackInfoCustom.builder()
                .id(UUID.randomUUID().toString())
                .latitude("22.2232")
                .longitude("23.3534")
                .build();
        KafkaProducer<String, TrackInfoCustom> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, TrackInfoCustom> record = new ProducerRecord<>("trackTopic", trackInfo.getId(), trackInfo);
        producer.send(record);
        System.out.println("Message send successfully!");
        producer.close();
    }
}