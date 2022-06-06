package code.elif;

public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
      System.out.println("Beginning of the program");

       BookShop bs = new BookShop();
        bs.setShopName("Novelty");
        bs.loadData();
        System.out.println(bs);
        BookShop bs1 = (BookShop) bs.clone();
        bs1.setShopName("Novelty-2");
        System.out.println(bs1);
        bs1.books.remove(1);

        System.out.println("After the remove operation");
        System.out.println(bs);
        System.out.println(bs1);
    }
}
