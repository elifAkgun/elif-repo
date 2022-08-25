package code.elif;

public class Client {

    public static void main(String[] args) {
        ComplexService service = new ComplexService("Simple report",
                new NullStorageService());
        service.generateReport();
    }
}
