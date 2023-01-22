package code.elif.app.features.java12;

import code.elif.app.model.Stock;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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

    private static void withoutTransform() {
        var joke = "the only programming joke i know is my code";
		/*Expected output-
		            "Only Programming Joke I Know Is My Code..."
		*/
        var result = upperCase(dropFirstWord(joke)).concat("...");
        System.out.println(result);
    }

    private static void withTransform() {
        var joke = "the only programming joke i know is my code";
        var result = joke.transform(StringAPIChanges::dropFirstWord)
                .transform(StringAPIChanges::upperCase)
                .concat("...");

        System.out.println(result);
    }

    private static String dropFirstWord(String string) {
        return List.of(string.split("\\W+"))
                .stream()
                .skip(1)
                .collect(Collectors.joining(" "));
    }


    private static String upperCase(String string) {
        return List.of(string.split("\\W+"))
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}