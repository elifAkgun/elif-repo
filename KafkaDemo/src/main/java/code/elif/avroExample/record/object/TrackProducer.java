package code.elif.avroExample;

import code.elif.kafka.avro.TrackInfo;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.UUID;

public class TrackProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://localhost:8081");

        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setId(UUID.randomUUID().toString());
        trackInfo.setLatitude("22.2232");
        trackInfo.setLongitude("23.3534");
        trackInfo.setDate(LocalDateTime.now().toString());

        KafkaProducer<CharSequence, TrackInfo> producer = new KafkaProducer<>(properties);
        ProducerRecord<CharSequence, TrackInfo> record = new ProducerRecord<>("trackTopic", trackInfo.getId(), trackInfo);
        producer.send(record);
        System.out.println("Message send successfully!");
        producer.close();
    }
}