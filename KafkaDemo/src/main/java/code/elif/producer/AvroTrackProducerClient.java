package code.elif.producer;

import code.elif.model.kafka.avro.TrackCoordinates;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;

public class AvroTrackProducerClient {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://localhost:8081");

        TrackCoordinates trackInfo = new TrackCoordinates();
        trackInfo.setId(UUID.randomUUID().toString());
        trackInfo.setLatitude("22.2232");
        trackInfo.setLongitude("23.3534");
        trackInfo.setDate(LocalDateTime.now().toString());

        KafkaProducer<CharSequence, TrackCoordinates> producer = new KafkaProducer<>(properties);
        ProducerRecord<CharSequence, TrackCoordinates> record = new ProducerRecord<>("trackTopic5", trackInfo.getId(), trackInfo);
        producer.send(record);
        System.out.println("Message send successfully!");
        producer.close();
    }
}