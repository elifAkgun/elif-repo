package code.elif.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StandaloneConsumerClient {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "SimpleConsumerGroup");

        KafkaConsumer<String, Integer> consumer = new KafkaConsumer<>(properties);
        List<PartitionInfo> partitionInfos = consumer.partitionsFor("SimpleConsumerTopic");

        ArrayList<TopicPartition> partitions = new ArrayList<>();
        for (PartitionInfo info : partitionInfos) {
            System.out.println(info.partition());
            partitions.add(new TopicPartition("SimpleConsumerTopic", info.partition()));
        }
        consumer.assign(partitions);

        ConsumerRecords<String, Integer> orders = consumer.poll(Duration.ofSeconds(20));
        for (ConsumerRecord<String, Integer> order : orders) {
            System.out.println("Product Name " + order.key());
            System.out.println("Quantity " + order.value());
        }
        consumer.commitAsync();
        consumer.close();
    }
}
