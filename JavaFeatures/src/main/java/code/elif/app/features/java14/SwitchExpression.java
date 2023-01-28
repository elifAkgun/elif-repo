package code.elif.app.features.java14;

public class SwitchExpression {

    public static void main(String[] args) {
        int price = 2000;
        double discount = calculateDiscount(price);
        System.out.println("Discount : " + discount);
    }

    private static double calculateDiscount(int price) {
        return switch (price) {
            case 1000 -> 0.1;
            case 2000, 3000 -> 0.25;
            case 4000, 5000 -> 0.35;
            default -> throw new IllegalStateException("Unexpected value: " + price);
        };
    }

    private static double calculateDiscountOldStyle(int price) {
        double discount = 0;

        switch (price) {
            case 1000:
                discount = 0.1;
                break;
            case 2000:
            case 3000:
                discount = 0.25;
                break;
            case 4000:
            case 5000:
                discount = 0.35;
                break;
            default:
                System.out.println("No discount");
        }
        return discount;
    }


}
