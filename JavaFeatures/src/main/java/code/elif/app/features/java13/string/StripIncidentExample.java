package code.elif.app.features.java13;

public class StripIncidentExample {

    public static void main(String[] args) {
        String fruit =
                "     {\n" +
                "        \"id\":\"123\"\n" +
                "        \"firstName\":\"Apple\"\n" +
                "        \"lastName\":\"Pineapple\"\n" +
                "     }";

        System.out.println(fruit.stripIndent());
    }
}
