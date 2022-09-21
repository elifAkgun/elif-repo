package code.elif;
public class Array {

    public static void main(String[] args) {

        int [][][] threeDimArray = {{{100, 101, 102}, {200, 201, 202}}};

        for (int i = 0; i < threeDimArray.length; i++) {
            for (int j = 0; j < threeDimArray[i].length; j++) {
                for (int k = 0; k < threeDimArray[i][j].length; k++) {
                    System.out.print(threeDimArray[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
