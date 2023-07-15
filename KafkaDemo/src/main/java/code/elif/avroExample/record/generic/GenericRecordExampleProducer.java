package code.elif.avroExample.record.generic;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
import java.util.UUID;

public class GenericRecordExampleProducer {


    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://localhost:8081");
        properties.setProperty("specific.avro.reader", "true");
        properties.setProperty("group.id", "firstGroup");

        KafkaProducer<CharSequence, GenericRecord> producer = new KafkaProducer<>(properties);

        Schema.Parser parser = new Schema.Parser();

        Schema schema = parser.parse("{\n" + "  \"namespace\": \"code.elif.kafka.avro\",\n" + "  \"type\": \"record\",\n" + "  \"name\": \"TrackInfo\",\n" + "  \"fields\": [\n" + "    {\n" + "      \"name\": \"id\",\n" + "      \"type\": \"string\"\n" + "    },\n" + "    {\n" + "      \"name\": \"latitude\",\n" + "      \"type\": \"string\"\n" + "    },\n" + "    {\n" + "      \"name\": \"longitude\",\n" + "      \"type\": \"string\"\n" + "    },\n" + "    {\n" + "      \"name\": \"date\",\n" + "      \"type\": \"string\"\n" + "    }\n" + "  ]\n" + "}\n");

        GenericRecord coordinate = new GenericData.Record(schema);
        coordinate.put("id", UUID.randomUUID().toString());
        coordinate.put("latitude", "56.454");
        coordinate.put("longitude", "53.343");
        coordinate.put("date", "12.03.2023");

        ProducerRecord<CharSequence, GenericRecord> record = new ProducerRecord<>("trackTopic3", coordinate.get("id").toString(), coordinate);
        producer.send(record);
        System.out.println("Message send successfully!");
        producer.close();
    }
}
