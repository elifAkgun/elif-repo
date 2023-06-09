package code.elif.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class GenericSerializer<T> implements Serializer<T> {

    @Override
    public byte[] serialize(String topic, T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes = new byte[0];
        try {
            bytes = objectMapper.writeValueAsString(object).getBytes();
        } catch (JsonProcessingException e) {
            e.getStackTrace();
        }
        return bytes;
    }
}
