package code.elif;

public class Client {

    public static void main(String[] args) {
        Iterator<ThemeColor> iteration = ThemeColor.getIteration();

        while (iteration.hasNext()) {
            System.out.println(iteration.next());
        }
    }

}

