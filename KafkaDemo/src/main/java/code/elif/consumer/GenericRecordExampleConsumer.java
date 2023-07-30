package code.elif.consumer;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class GenericRecordExampleConsumer {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,  KafkaAvroDeserializer.class.getName());
        properties.setProperty("schema.registry.url", "http://localhost:8081");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "firstGroup");

        KafkaConsumer<String, GenericRecord> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singleton("trackTopic3"));

        ConsumerRecords<String, GenericRecord> records = consumer.poll(Duration.ofSeconds(20));

        for (ConsumerRecord<String, GenericRecord> record : records) {
            System.out.println(record.key() + " " + record.value());
        }

        consumer.close();
    }
}
