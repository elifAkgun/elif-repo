package code.elif.app.features.java13.string;

public class FormattedExample {
    public static void main(String[] args) {
        stringFormat();
    }

    private static void stringFormat() {
        String html =
                "<html>"
                        + "\n  <table>"
                        + "\n     <thead>"
                        + "\n       <tr>"
                        + "\n         <th colspan=\"2\">%s</th>"
                        + "\n       </tr>"
                        + "\n     </thead>"
                        + "\n     <tbody>"
                        + "\n       <tr>"
                        + "\n         <td>%s</td>"
                        + "\n         <td>%s</td>"
                        + "\n       </tr>"
                        + "\n     </tbody>"
                        + "\n  </table>"
                        + "\n</html>";

        System.out.println(String.format(html, "My Favorite Fruit", "Apple", "Orange"));
    }

    private static void stringFormatted() {
        String html = """
                <html>
                   <table>
                      <thead>
                        <tr>
                          <th colspan=\"2\">%s</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>%s</td>
                          <td>%s</td>
                        </tr>
                      </tbody>
                   </table>
                </html>""";

        System.out.println(html.formatted("My Favorite Fruit", "Apple", "Orange"));
    }
}
