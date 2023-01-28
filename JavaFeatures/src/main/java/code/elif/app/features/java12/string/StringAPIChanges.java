package code.elif.app.features.java12.string;

import code.elif.app.model.Stock;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * String API changes in Java 12
 */
public class StringAPIChanges {

    public static void main(String[] args) {
        List<Stock> data = List.of(
                new Stock("fruit", new BigDecimal(10)),
                new Stock("vegetable", new BigDecimal(12)),
                new Stock("device", new BigDecimal(3)),
                new Stock("book", new BigDecimal(5))
        );
        String jsonString = convertJsonString(data);
        System.out.println(jsonString);
    }
    private static String convertJsonString(List<Stock> data) {
        AtomicReference<String> json = new AtomicReference<>("");
        data.forEach((o) -> json.set(json + getJsonLine(o.getName(), o.getValue().toString())));

        return wrapJson(String.valueOf(json));
    }
    private static String wrapJson(String jsonBody) {
        return "{\n" + jsonBody.indent(4) + "}";
    }
    private static String getJsonLine(String key, String value) {
        return "\"" + key + "\" : \"" + value + "\"\n";
    }


}