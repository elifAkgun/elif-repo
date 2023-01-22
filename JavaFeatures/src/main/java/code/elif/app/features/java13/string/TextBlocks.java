package code.elif.app.features.java13;

public class TextBlocks {

//    String fruit = "{\n" +
//            "   \"id\":\"123\"\n" +
//            "   \"firstName\":\"Apple\"\n" +
//            "   \"lastName\":\"Pineapple\"\n" +
//            "}";

    public static void main(String[] args) {
        String fruit = """ 
                {
                   "id":"123"
                   "firstName":"Apple"
                   "lastName":"Pineapple"
                }
                """;
        System.out.println(fruit);
    }
}
