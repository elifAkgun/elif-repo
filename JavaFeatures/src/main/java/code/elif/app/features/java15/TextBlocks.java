package code.elif.app.features.java15;

public class TextBlocks {
    public static void main(String[] args) {
        explicitSpaceExample();

    }

    private static void explicitSpaceExample() {
        String tower = """
                ------------
                     ()    \s 
                    (  )   \s
                   (    )  \s 
                ------------
                """;

        System.out.println(tower);
    }


    private static void printTextBlockInSingleLine() {
        String textBlock = """
                Hello this
                is an apple
                story""";

        System.out.println(textBlock);

        textBlock = """
                Hello this \
                is an apple \
                story""";

        System.out.println(textBlock);
    }


    private static void stringAndTextBlockComparator() {
        String text = "Apple";

        String textBlock = """
                Apple""";

        System.out.println(text);
        System.out.println(textBlock);

        System.out.println(text.equals(textBlock));
        System.out.println(text == textBlock);
    }
}
