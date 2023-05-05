package code.elif.domain.model;

import com.github.javafaker.Book;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookOrder {
    private Book book;
    private Integer price;
}
