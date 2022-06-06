package code.elif;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class BookShop implements Cloneable {

    private String shopName;
    List<Book> books = new ArrayList();

    public void loadData() {
        for (int i = 1; i <= 5; i++) {
            Book b = new Book();
            b.setId(i);
            b.setName("Book" + i);
            getBooks().add(b);
        }
    }

//        @Override
//        protected Object clone() throws CloneNotSupportedException {
//                return super.clone();
//        }

    @Override
    protected BookShop clone(){
        BookShop shop = new BookShop();
        for (Book b : this.getBooks()) {

            shop.getBooks().add(b);
        }
        return shop;
    }
}
