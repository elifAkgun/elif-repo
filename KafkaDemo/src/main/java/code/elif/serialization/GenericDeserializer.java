package code.elif.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class GenericDeserializer<T> implements Deserializer<T> {
    private Class<T> typeParameterClass;

    public GenericDeserializer(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    @Override
    public T deserialize(String s, byte[] bytes) {
        T value;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            value = objectMapper.readValue(bytes, typeParameterClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
